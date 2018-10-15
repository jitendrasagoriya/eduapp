package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Concept;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface ConceptService {
	
	public Page<Concept> getAll(Pageable pageable);
	
	public Page<Concept> getAllByChapter(Long id,Pageable pageable);

	public List<Concept> getAll();

	public Concept getById(Long id);

	public Concept getByName(String id);

	public Concept save(Concept concept);

	public Boolean delete(Long id);

	public Concept update(Concept concept);
	
	public Integer getMax(Long id);

}
