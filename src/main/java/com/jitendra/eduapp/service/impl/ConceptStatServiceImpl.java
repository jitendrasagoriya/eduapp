package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ConceptStatDaoService;
import com.jitendra.eduapp.domin.ConceptStat;
import com.jitendra.eduapp.domin.key.ConceptStatPrimeryKey;
import com.jitendra.eduapp.service.ConceptStatService;

@Service
public class ConceptStatServiceImpl implements ConceptStatService {
	
	@Autowired
	private ConceptStatDaoService service;

	@Override
	public ConceptStat save(ConceptStat conceptStat) {
		return service.getRepository().save(conceptStat);
	}

	@Override
	public Boolean delete(ConceptStatPrimeryKey id) {
		try {
			 service.getRepository().deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public ConceptStat update(ConceptStat conceptStat) {
		return service.getRepository().save(conceptStat);
	}

	@Override
	public Page<ConceptStat> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<ConceptStat> getAll() {
		return service.getRepository().findAll();
	}

	@Override
	public ConceptStat getById(ConceptStatPrimeryKey id) {
		return service.getRepository().getOne(id);
	}

}
