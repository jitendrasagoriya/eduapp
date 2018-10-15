package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.QuestionDaoService;
import com.jitendra.eduapp.repository.QuestionRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class QuestionDaoServiceImpl implements QuestionDaoService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public QuestionRepository getRepository() {
		return questionRepository;
	}

}
