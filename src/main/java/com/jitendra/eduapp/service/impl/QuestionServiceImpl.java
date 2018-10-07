package com.jitendra.eduapp.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.constants.Constant;
import com.jitendra.eduapp.dao.McqAnswerDaoService;
import com.jitendra.eduapp.dao.QuestionDaoService;
import com.jitendra.eduapp.domin.McqAnswer;
import com.jitendra.eduapp.domin.Question;
import com.jitendra.eduapp.enums.QuestionType;
import com.jitendra.eduapp.service.ChapterService;
import com.jitendra.eduapp.service.QuestionService;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class QuestionServiceImpl extends BaseService<Question> implements QuestionService {
	
	public static Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);
	
	@Autowired
	private QuestionDaoService daoService;
	
	@Autowired
	private McqAnswerDaoService mcqDaoService;
	
	@Autowired
	private ChapterService chapterService;

	@Override
	public Page<Question> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public List<Question> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public Question getById(Long id) {
		Question question = daoService.getRepository().getOne(id);		
		
		if(question.getType().name().equalsIgnoreCase(QuestionType.MCQ.name())) {
			McqAnswer answer = mcqDaoService.getByQuestion(id);
			if(answer == null) {
				logger.error("Answer is not found for this question: id"+question.getId());
			}
			question.setMcqAnswer(answer);
		}
		return question;
	}

	@Override
	public Page<Question> getByChapter(String id, Pageable pageable) {
		return null;
	}

	@Override
	public Question save(Question question) {
		question = daoService.getRepository().save(question);
		try {
			if(question.getId() != null ) {	
				
				chapterService.updateVideoCount(question.getChapterId());
			}
		}catch (Exception e) {
			logger.error(e.getMessage() );
		}
		return question;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			daoService.getRepository().deleteById(id);
			
			chapterService.reduceQuestionCount(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			logger.error("No such elenemt found. Id: "+id);
			return Boolean.FALSE;
		}
	}

	
	@Override
	public Question update(Question question) throws Exception {
		if(question.getId() != null )
			return daoService.getRepository().save(question);
		else
			throw new Exception("Invalid data.");
	}

	
	
	@Override
	public StringBuffer downlaod() {
		List<Question> questions = getAll();
		StringBuffer stringBuffer = new StringBuffer();
		for (Question question : questions) {
			stringBuffer.append(question.toCsvString()); 
		}
		return stringBuffer;
	}

	
	
	@Override
	public List<Question> uploadFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMax(Long id) {
		return daoService.getRepository().getMax(id);
	}

}
