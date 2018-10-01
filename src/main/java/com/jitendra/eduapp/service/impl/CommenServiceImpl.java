package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.CommenDaoService;
import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.service.CommenService;


@Service
public class CommenServiceImpl implements CommenService {
	
	@Autowired
	private CommenDaoService commenDaoService;

	@Override
	public List<Video> getVideoByChapterId(Long id) {
		return commenDaoService.getVideoByChapterId(id);
	}

}
