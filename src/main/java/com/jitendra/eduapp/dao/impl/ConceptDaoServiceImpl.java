package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ConceptDaoService;
import com.jitendra.eduapp.repository.ConceptRepository;

@Service
public class ConceptDaoServiceImpl implements ConceptDaoService {
	
	@Autowired
	private ConceptRepository conceptRepositroy;

	@Override
	public ConceptRepository getRepository() {
		return conceptRepositroy;
	}

}
