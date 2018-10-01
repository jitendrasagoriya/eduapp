package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.VideoDaoService;
import com.jitendra.eduapp.repository.VideoRepository;

@Service
public class VideoDaoServiceImpl implements VideoDaoService {
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public VideoRepository getRepository() {
		return videoRepository;
	}



}
