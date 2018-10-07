package com.jitendra.eduapp.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Video;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface CommenDaoService {	
	
	public List<Video> getVideoByChapterId(Long id);

}
