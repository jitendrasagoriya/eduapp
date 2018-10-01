package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ConceptDaoService;
import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.service.ConceptService;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class ConceptServiceImpl implements ConceptService {
	
	public static Logger logger = LoggerFactory.getLogger(ConceptServiceImpl.class);
	
	@Autowired
	private ConceptDaoService daoService;

	@Override
	public Page<Concept> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public Page<Concept> getAllByChapter(Long id, Pageable pageable) {
		return daoService.getAllByChapter(id, pageable);
	}

	@Override
	public List<Concept> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public Concept getById(Long id) {
		return daoService.getRepository().getOne(id);
	}

	@Override
	public Concept getByName(String name) {
		return daoService.getByName(name);
	}

	@Override
	public Concept save(Concept concept) {
		return daoService.getRepository().save(concept);
	}

	@Override
	public Boolean delete(Long id) {
		try {
			daoService.getRepository().deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			logger.error("No such elenemt found. Id: "+id);
			return Boolean.FALSE;
		}
	}

	@Override
	public Concept update(Concept concept) {
		return daoService.getRepository().save(concept);
	}

}
