package com.jitendra.eduapp.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.dao.ConceptDaoService;
import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.domin.McqAnswer;
import com.jitendra.eduapp.service.ChapterService;
import com.jitendra.eduapp.service.ConceptService;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class ConceptServiceImpl extends BaseService<Concept> implements ConceptService {
	
	public static Logger logger = LoggerFactory.getLogger(ConceptServiceImpl.class);
	
	@Autowired
	private ConceptDaoService daoService;
	
	@Autowired
	private ChapterService chapterService;

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
		  concept = daoService.getRepository().save(concept);
		
		try {
			if(concept.getId() != null ) {				 
				chapterService.updateConceptCount(concept.getChapterId());
			}
		}catch (Exception e) {
			logger.error(e.getMessage() );
		}
		
		return concept;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			daoService.getRepository().deleteById(id);
			
			chapterService.reduceConceptCount(id);
			
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

	@Override
	public StringBuffer downlaod() {
		List<Concept> concepts = getAll();
		StringBuffer stringBuffer = new StringBuffer();
		for (Concept concept : concepts) {
			stringBuffer.append(concept.toCSVString()); 
		}
		return stringBuffer;
	}

	@Override
	public List<Concept> uploadFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMax(Long id) {
		return daoService.getRepository().getMax(id);
	}

}
