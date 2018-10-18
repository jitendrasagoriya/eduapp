package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ChapterStatDaoService;
import com.jitendra.eduapp.repository.ChapterStatRepository;


@Service
public class ChapterStatDaoServiceImpl implements ChapterStatDaoService {
	
	@Autowired
	private ChapterStatRepository repository;

	@Override
	public ChapterStatRepository getRepository() {
		return repository;
	}

}
