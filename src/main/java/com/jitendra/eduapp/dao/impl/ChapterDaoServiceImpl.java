package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ChapterDaoService;
import com.jitendra.eduapp.repository.ChapterRepositroy;

@Service
public class ChapterDaoServiceImpl implements ChapterDaoService {
	
	@Autowired
	private ChapterRepositroy chapterRepositroy;

	@Override
	public ChapterRepositroy getRepository() {
		return chapterRepositroy;
	}

	 
}