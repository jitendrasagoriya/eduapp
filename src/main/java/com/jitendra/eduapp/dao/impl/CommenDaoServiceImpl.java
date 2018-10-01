package com.jitendra.eduapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.CommenDaoService;
import com.jitendra.eduapp.dao.ConceptDaoService;
import com.jitendra.eduapp.dao.QuestionDaoService;
import com.jitendra.eduapp.dao.VideoDaoService;
import com.jitendra.eduapp.domin.Video;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class CommenDaoServiceImpl implements CommenDaoService {
	
	@Autowired
	private VideoDaoService videoDaoService;
	

	@Autowired
	private ConceptDaoService conceptDaoService;
	
	@Autowired
	private QuestionDaoService questionDaoService;

	@Override
	public List<Video> getVideoByChapterId(Long id) {
		Example<Video> videoExample = Example.of(new Video(null, null, id));
		List<Video> videos =  videoDaoService.getRepository().findAll(videoExample);		
		return videos;
	}
	
	

}
