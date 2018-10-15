package com.jitendra.eduapp.service.impl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.dao.ChapterDaoService;
import com.jitendra.eduapp.domin.Chapter;
import com.jitendra.eduapp.service.ChapterService;

/**
 * @author jitendra sagoriya
 *
 */
@Service
@Transactional
public class ChapterServiceImpl extends BaseService<Chapter> implements ChapterService {
	
	public static Logger logger = LoggerFactory.getLogger(ChapterServiceImpl.class);
	
	@Autowired
	private ChapterDaoService  daoService;

	@Override
	public Page<Chapter> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public List<Chapter> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public Chapter getById(Long id) {
		Chapter chapter = daoService.getRepository().getOne(id);		 
		return chapter;
	}

	@Override
	public Page<Chapter> getByNameSubject(String id,Pageable pageable) {
		Example<Chapter> example = Example.of(new Chapter(null, null, id, null));
		return daoService.getRepository().findAll(example, pageable);
	}
	
	@Override
	public List<Chapter> getAll(String id) {
		Example<Chapter> example = Example.of(new Chapter(null, null, id, null));
		return daoService.getRepository().findAll(example);
	}
	
	@Override
	public Page<Chapter> getByClass(String classz, Pageable pageable) {
		Example<Chapter> example = Example.of(new Chapter(null, null, null, classz));
		return daoService.getRepository().findAll(example,pageable);
	}

	@Override
	public Page<Chapter> getByNameSubjectAndClass(String id, String classz, Pageable pageable) {
		Example<Chapter> example = Example.of(new Chapter(null, null, id, classz));
		return daoService.getRepository().findAll(example,pageable);
	}

	@Override
	public Chapter save(Chapter chapter) {
		chapter.setSequence( getMax(chapter.getSubject(), chapter.getClassz())+1);
		chapter.setQuestionCount(0);
		chapter.setConceptCount(0);
		chapter.setVideoCount(0);
		return daoService.getRepository().save(chapter);
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
	public Chapter update(Chapter chapter) {
		return daoService.getRepository().save(chapter);
	}
	
	@Override
	public Integer getMax(String subject, String classz) {	
		Integer max = daoService.getRepository().getMax(subject, classz);
		if(max == null)
			max = 1;
		return max;
	}


	@Override
	public StringBuffer downlaod() {
		List<Chapter> chapters = getAll();
		StringBuffer stringBuffer = new StringBuffer();
		for (Chapter chapter : chapters) {
			stringBuffer.append(chapter.toCSVString()); 
		}
		return stringBuffer;
	}

	@Override
	public List<Chapter> uploadFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateVideoCount(Long id) {
		return daoService.updateVideoCount(id,1);
	}

	@Override
	public int updateQuestionCount(Long id) {
		return daoService.updateQuestionCount(id,1);
	}

	@Override
	public int updateConceptCount(Long id) {
		return daoService.updateConceptCount(id,1);
	}

	@Override
	public int reduceVideoCount(Long id) {
		return daoService.reduceVideoCount(id,1);
	}

	@Override
	public int reduceQuestionCount(Long id) {
		return daoService.reduceQuestionCount(id,1);
	}

	@Override
	public int reduceConceptCount(Long id) {
		return daoService.reduceConceptCount(id,1);
	}

	
	 

	@Override
	public int updateVideoCount(Long id,Integer count) {
		return daoService.updateVideoCount(id,count);
	}

	@Override
	public int updateQuestionCount(Long id,Integer count) {
		return daoService.updateQuestionCount(id,count);
	}

	@Override
	public int updateConceptCount(Long id,Integer count) {
		return daoService.updateConceptCount(id,count);
	}

	@Override
	public int reduceVideoCount(Long id,Integer count) {
		return daoService.reduceVideoCount(id,count);
	}

	@Override
	public int reduceQuestionCount(Long id,Integer count) {
		return daoService.reduceQuestionCount(id,count);
	}

	@Override
	public int reduceConceptCount(Long id,Integer count) {
		return daoService.reduceConceptCount(id,count);
	}

	@Override
	@Transactional
	public void updateResumeFalse() {
		daoService.updateResumeFalse();		
	}

	@Override
	public int updateResume(Long id) {
		return daoService.updateResume(id);
	}

	@Override
	public Chapter getResume(String classz) {
		return daoService.getResume(classz);
	}
	
	
}
