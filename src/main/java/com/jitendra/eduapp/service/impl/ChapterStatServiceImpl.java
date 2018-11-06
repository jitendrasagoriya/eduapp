package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ChapterStatDaoService;
import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.domin.key.ChapterStatPrimaryKey;
import com.jitendra.eduapp.service.ChapterStatService;

@Service
public class ChapterStatServiceImpl implements ChapterStatService {

	public static Logger logger = LoggerFactory.getLogger(ChapterStatServiceImpl.class);

	@Autowired
	private ChapterStatDaoService service;

	@Override
	public ChapterStat save(ChapterStat chapterStat) {
		return service.getRepository().save(chapterStat);
	}

	@Override
	public Boolean delete(ChapterStatPrimaryKey id) {
		try {
			service.getRepository().deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public ChapterStat update(ChapterStat chapterStat) {
		return service.getRepository().save(chapterStat);
	}

	@Override
	public Page<ChapterStat> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<ChapterStat> getAll() {
		return service.getRepository().findAll();
	}

	@Override
	public ChapterStat getById(ChapterStatPrimaryKey id) {
		try {
			return service.getRepository().findById(id).get();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

}
