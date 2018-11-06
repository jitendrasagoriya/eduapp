package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.QuestionStatDaoService;
import com.jitendra.eduapp.repository.QuestionStatRepository;


@Service
public class QuestionStatDaoServiceImpl implements QuestionStatDaoService {
	
	@Autowired
	private QuestionStatRepository repository;

	@Override
	public QuestionStatRepository getRepository() {
		return repository;
	}

}
