package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.domin.Video;

@Service
public interface VideoService {

	public Page<Video> getAll(Pageable pageable);

	public List<Video> getAll();

	public Video getById(Long id);

	public Video getByName(Long id);

	public Video save(Video subject);

	public Boolean delete(Long id);

	public Video update(Video subject);

}
