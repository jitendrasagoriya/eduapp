package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.VideoDaoService;
import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.repository.VideoRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class VideoDaoServiceImpl implements VideoDaoService {
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public VideoRepository getRepository() {
		return videoRepository;
	}

	@Override
	public Page<Video> getAllByChapter(Long id, Pageable pageable) {
		Example<Video> videoExample = Example.of(new Video(null, null, id));
		Page<Video> videos =  videoRepository.findAll(videoExample, pageable);
		return videos;
	}



}
