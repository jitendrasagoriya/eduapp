package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.QuestionDaoService;
import com.jitendra.eduapp.domin.Question;
import com.jitendra.eduapp.enums.QuestionType;
import com.jitendra.eduapp.repository.QuestionRepository;
 
@Service
public class QuestionDaoServiceImpl implements QuestionDaoService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public QuestionRepository getRepository() {
		return questionRepository;
	}

	@Override
	public Page<Question> getByChapter(String id, Pageable pageable) {
		Example<Question> videoExample = Example.of(new Question(null, null, null,Long.valueOf(id) , null));
		Page<Question> questions =  questionRepository.findAll(videoExample, pageable);
		return questions;
	}
	
	@Override
	public Page<Question> getByChapter(String id, QuestionType type, Pageable pageable) {
		Example<Question> videoExample = Example.of(new Question(type, null, null,Long.valueOf(id) , null));
		Page<Question> questions =  questionRepository.findAll(videoExample, pageable);
		return questions;
	}

}
