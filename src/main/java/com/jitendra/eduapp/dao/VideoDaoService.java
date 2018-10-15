package com.jitendra.eduapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.repository.VideoRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface VideoDaoService extends BaseDaoService<VideoRepository>{
	
	public Page<Video> getAllByChapter(Long id,Pageable pageable);

}
