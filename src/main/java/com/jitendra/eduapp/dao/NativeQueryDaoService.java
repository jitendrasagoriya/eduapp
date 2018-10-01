package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface NativeQueryDaoService {
	
	public int insertIntoVideo(Long viodeId,Long chapterId);
	
}
