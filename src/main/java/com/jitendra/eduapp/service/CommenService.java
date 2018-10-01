package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Video;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface CommenService {
	
	public List<Video> getVideoByChapterId(Long id);

}
