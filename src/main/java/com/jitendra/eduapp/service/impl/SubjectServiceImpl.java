package com.jitendra.eduapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.SubjectDaoService;
import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.service.SubjectService;


@Service
public class SubjectServiceImpl implements SubjectService {
	
	public static Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);
	
	@Autowired
	private SubjectDaoService service;

	@Override
	public Page<Subject> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<Subject> getAll() {
		return service.getRepository().findAll();
	}

	@Override
	public Subject getById(Long id) {
		try {
			return  service.getRepository().findById(id).get();
		}catch (NoSuchElementException e) {
			logger.error("No such element found : id "+id);
			return  null;			
		}		
	}

	@Override
	public Subject getByName(Long id) {
		return null;
	}

	@Override
	public Subject save(Subject subject) {
		return service.getRepository().save(subject);
	}

	@Override
	public void delete(Long id) {
		service.getRepository().deleteById(id);	
	}

	@Override
	public Subject update(Subject subject) {
		return service.getRepository().saveAndFlush(subject);
	}

}
