package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ConceptDaoService;
import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.repository.ConceptRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class ConceptDaoServiceImpl implements ConceptDaoService {
	
	@Autowired
	private ConceptRepository conceptRepositroy;

	@Override
	public ConceptRepository getRepository() {
		return conceptRepositroy;
	}

	@Override
	public Page<Concept> getAllByChapter(Long id, Pageable pageable) {
		Example<Concept> videoExample = Example.of(new Concept(null, null, null,id));
		Page<Concept> concepts =  conceptRepositroy.findAll(videoExample, pageable);
		return concepts;
	}

	@Override
	public Concept getByName(String name) {
		Example<Concept> conceptExample = Example.of(new Concept(null, name, null,null));
		Concept concept =  conceptRepositroy.findOne(conceptExample).get();
		return concept;
	}

	

	 

}
