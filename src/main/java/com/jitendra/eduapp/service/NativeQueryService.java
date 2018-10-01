package com.jitendra.eduapp.service;

import org.springframework.stereotype.Service;

@Service
public interface NativeQueryService {
	
	public int insertIntoVideo(Long viodeId,Long chapterId);
}
