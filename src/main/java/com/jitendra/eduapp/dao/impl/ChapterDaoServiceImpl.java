package com.jitendra.eduapp.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ChapterDaoService;
import com.jitendra.eduapp.domin.Chapter;
import com.jitendra.eduapp.endpoint.ChapterEndpoint;
import com.jitendra.eduapp.repository.ChapterRepositroy;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class ChapterDaoServiceImpl implements ChapterDaoService {

	public static Logger logger = LoggerFactory.getLogger(ChapterEndpoint.class);

	@Autowired
	private ChapterRepositroy chapterRepositroy;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ChapterRepositroy getRepository() {
		return chapterRepositroy;
	}

	@Transactional
	@Override
	public int updateVideoCount(Long id, Integer count) {
		return chapterRepositroy.increaseVideoCount(id, count);
	}

	@Override
	public int updateQuestionCount(Long id, Integer count) {
		return chapterRepositroy.increaseQuestionCount(id, count);
	}

	@Override
	public int updateConceptCount(Long id, Integer count) {
		return chapterRepositroy.increaseConceptCount(id, count);
	}

	@Override
	public int reduceVideoCount(Long id, Integer count) {
		return chapterRepositroy.reduceVideoCount(id, count);
	}

	@Override
	public int reduceQuestionCount(Long id, Integer count) {
		return chapterRepositroy.reduceQuestionCount(id, count);
	}

	@Override
	public int reduceConceptCount(Long id, Integer count) {
		return chapterRepositroy.reduceConceptCount(id, count);
	}

	@Override
	public int updateResume(Long id) {
		return chapterRepositroy.setResume(id, new Timestamp(System.currentTimeMillis()));
	}

	@Transactional
	@Override
	public void updateResumeFalse() {
		chapterRepositroy.getUpdateResume();
	}

	@Override
	public Chapter getResume(String classz) {
		return (Chapter) entityManager
				.createNativeQuery("SELECT * FROM CHAPTER  WHERE RESUME = TRUE AND CLASS = ?1 ORDER BY RESUMETIME DESC",Chapter.class)
				.setParameter(1, classz)
				.getResultList().get(0);
		  		
	}

}
