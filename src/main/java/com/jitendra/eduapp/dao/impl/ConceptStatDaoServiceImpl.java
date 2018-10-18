package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ConceptStatDaoService;
import com.jitendra.eduapp.repository.ConceptStatRepository;


@Service
public class ConceptStatDaoServiceImpl implements ConceptStatDaoService {
	
	@Autowired
	private ConceptStatRepository repository;

	@Override
	public ConceptStatRepository getRepository() {		 
		return repository;
	}

}
