package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Chapter;

@Service
public interface ChapterService {
	
	public Page<Chapter> getAll(Pageable pageable);

	public List<Chapter> getAll();

	public Chapter getById(Long id);

	public Page<Chapter> getByNameSubject(String id,Pageable pageable);

	public Chapter save(Chapter chapter);

	public Boolean delete(Long id);

	public Chapter update(Chapter chapter);

}
