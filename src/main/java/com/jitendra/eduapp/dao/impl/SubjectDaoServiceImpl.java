package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.SubjectDaoService;
import com.jitendra.eduapp.repository.SubjectRepository;


@Service
public class SubjectDaoServiceImpl implements SubjectDaoService {
	
	@Autowired
	private SubjectRepository subjectRepository;


	@Override
	public SubjectRepository getRepository() {
		return subjectRepository;
	}

}
