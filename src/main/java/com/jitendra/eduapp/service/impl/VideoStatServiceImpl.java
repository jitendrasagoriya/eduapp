package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.VideoStatDaoService;
import com.jitendra.eduapp.domin.VideoStat;
import com.jitendra.eduapp.domin.key.VideoStatPrimaryKey;
import com.jitendra.eduapp.service.VideoStatService;


@Service
public class VideoStatServiceImpl implements VideoStatService {
	
	@Autowired
	private VideoStatDaoService service;

	@Override
	public VideoStat save(VideoStat videoStat) {
		return service.getRepository().save(videoStat);
	}

	@Override
	public Boolean delete(VideoStatPrimaryKey id) {
		try {
			 service.getRepository().deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public VideoStat update(VideoStat videoStat) {
		return service.getRepository().save(videoStat);
	}

	@Override
	public Page<VideoStat> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<VideoStat> getAll() {
		return service.getRepository().findAll();
	}

	@Override
	public VideoStat getById(VideoStatPrimaryKey id) {
		return service.getRepository().getOne(id);
	}

}
