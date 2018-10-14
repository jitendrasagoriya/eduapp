package com.jitendra.eduapp.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ChapterDaoService;
import com.jitendra.eduapp.repository.ChapterRepositroy;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class ChapterDaoServiceImpl implements ChapterDaoService {

	@Autowired
	private ChapterRepositroy chapterRepositroy;

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
		// TODO Auto-generated method stub
		return 0;
	}

}
