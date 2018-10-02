package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.QuestionDaoService;
import com.jitendra.eduapp.domin.Question;
import com.jitendra.eduapp.service.QuestionService;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {
	
	public static Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);
	
	@Autowired
	private QuestionDaoService daoService;

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
		return daoService.getRepository().getOne(id);
	}

	@Override
	public Page<Question> getByChapter(String id, Pageable pageable) {
		return null;
	}

	@Override
	public Question save(Question question) {
		return daoService.getRepository().save(question);
	}

	@Override
	public Boolean delete(Long id) {
		try {
			daoService.getRepository().deleteById(id);
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

}
