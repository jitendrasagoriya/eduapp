package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.ConceptStat;
import com.jitendra.eduapp.domin.key.ConceptStatPrimeryKey;

@Service
public interface ConceptStatService {
	
	public ConceptStat save(ConceptStat conceptStat);

	public Boolean delete(ConceptStatPrimeryKey id);

	public ConceptStat update(ConceptStat conceptStat);
	
	public Page<ConceptStat> getAll(Pageable pageable);

	public List<ConceptStat> getAll();

	public ConceptStat getById(ConceptStatPrimeryKey id);

}
