package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.McqAnswerDaoService;
import com.jitendra.eduapp.domin.McqAnswer;
import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.repository.McqAnswerRepository;

@Service
public class McqAnswerDaoServiceImpl implements McqAnswerDaoService {
	
	
	@Autowired
	private McqAnswerRepository mcqAnswerRepository;

	@Override
	public McqAnswerRepository getRepository() {
		return mcqAnswerRepository;
	}

	@Override
	public  McqAnswer getByQuestion(Long id) {
		Example<McqAnswer> mcqAnswerExample = Example.of(new McqAnswer(id));
		 McqAnswer  mcqAnswer =  mcqAnswerRepository.findOne(mcqAnswerExample ).get();
		return mcqAnswer;
	}

}
