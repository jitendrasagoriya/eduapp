package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.VideoStat;
import com.jitendra.eduapp.domin.key.VideoStatPrimaryKey;


@Service
public interface VideoStatService {
	
	public VideoStat save(VideoStat videoStat);

	public Boolean delete(VideoStatPrimaryKey id);

	public VideoStat update(VideoStat videoStat);
	
	public Page<VideoStat> getAll(Pageable pageable);

	public List<VideoStat> getAll();

	public VideoStat getById(VideoStatPrimaryKey id);

}
