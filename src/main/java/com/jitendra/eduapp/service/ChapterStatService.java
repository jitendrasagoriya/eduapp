package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.domin.key.ChapterStatPrimaryKey;

@Service
public interface ChapterStatService {
	
	public ChapterStat save(ChapterStat chapterStat);

	public Boolean delete(ChapterStatPrimaryKey id);

	public ChapterStat update(ChapterStat chapterStat);
	
	public Page<ChapterStat> getAll(Pageable pageable);

	public List<ChapterStat> getAll();

	public ChapterStat getById(ChapterStatPrimaryKey id);
	
	public ChapterStat getResume(Long studentId );
	
	public ChapterStat getResume(Long studentId,Long subjectId);

}
