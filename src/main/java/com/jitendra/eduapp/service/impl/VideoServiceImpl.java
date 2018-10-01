package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.VideoDaoService;
import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.service.NativeQueryService;
import com.jitendra.eduapp.service.VideoService;


@Service
public class VideoServiceImpl implements VideoService {
	
	public static Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);
	
	@Autowired
	private VideoDaoService daoService;
	
	@Autowired
	private NativeQueryService nativeQueryService;

	@Override
	public Page<Video> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public List<Video> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public Video getById(Long id) {
		return daoService.getRepository().getOne(id);
	}

	@Override
	public Video getByName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video save(Video video) {
		video = daoService.getRepository().save(video);
		try {
			if(video.getId() != null ) {
				if(video.getChapterId() == null ) video.setChapterId(0l);
				nativeQueryService.insertIntoVideo(video.getId(), video.getChapterId());
			}
		}catch (Exception e) {
			logger.error(e.getMessage() );
		}
		return video;
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
	public Video update(Video video) {
		return daoService.getRepository().save(video);
	}

}
