package com.jitendra.eduapp.service;

import org.springframework.stereotype.Service;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface NativeQueryService {
	
	public int insertIntoVideo(Long viodeId,Long chapterId);
}
