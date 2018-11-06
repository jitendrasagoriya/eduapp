package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.VideoStatDaoService;
import com.jitendra.eduapp.repository.VideoStatRepository;


@Service
public class VideoStatDaoServiceImpl implements VideoStatDaoService {

	@Autowired
	private VideoStatRepository repository;

	@Override
	public VideoStatRepository getRepository() {
		return repository;
	}

}
