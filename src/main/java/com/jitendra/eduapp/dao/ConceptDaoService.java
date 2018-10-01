package com.jitendra.eduapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.repository.ConceptRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface ConceptDaoService extends BaseDaoService<ConceptRepository> {
 
	
	public Page<Concept> getAllByChapter(Long id,Pageable pageable);

	public Concept getByName(String name);
	
	 

}
