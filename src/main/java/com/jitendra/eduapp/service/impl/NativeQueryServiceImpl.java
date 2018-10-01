package com.jitendra.eduapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.NativeQueryDaoService;
import com.jitendra.eduapp.service.NativeQueryService;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public class NativeQueryServiceImpl implements NativeQueryService {
	
	@Autowired
	private NativeQueryDaoService nativeQueryDaoService;

	@Override
	public int insertIntoVideo(Long viodeId, Long chapterId) {
		return nativeQueryDaoService.insertIntoVideo(viodeId, chapterId);
	}

}
