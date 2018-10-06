package com.jitendra.eduapp.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.dao.ChapterDaoService;
import com.jitendra.eduapp.domin.Chapter;
import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.service.ChapterService;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class ChapterServiceImpl extends BaseService<Chapter> implements ChapterService {
	
	public static Logger logger = LoggerFactory.getLogger(ChapterServiceImpl.class);
	
	@Autowired
	private ChapterDaoService  daoService;

	@Override
	public Page<Chapter> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public List<Chapter> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public Chapter getById(Long id) {
		Chapter chapter = daoService.getRepository().getOne(id);		 
		return chapter;
	}

	@Override
	public Page<Chapter> getByNameSubject(String id,Pageable pageable) {
		Example<Chapter> example = Example.of(new Chapter(null, null, id, null));
		return daoService.getRepository().findAll(example, pageable);
	}

	@Override
	public Chapter save(Chapter chapter) {
		return daoService.getRepository().save(chapter);
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
	public Chapter update(Chapter chapter) {
		return daoService.getRepository().save(chapter);
	}

	@Override
	public StringBuffer downlaod() {
		List<Chapter> chapters = getAll();
		StringBuffer stringBuffer = new StringBuffer();
		for (Chapter chapter : chapters) {
			stringBuffer.append(chapter.toCSVString()); 
		}
		return stringBuffer;
	}

	@Override
	public List<Chapter> uploadFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
