package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.repository.ChapterStatRepository;

@Service
public interface ChapterStatDaoService extends BaseDaoService<ChapterStatRepository> {
	
	public ChapterStat getResume(Long studentId);
	
	public ChapterStat getResume(Long studentId,Long subjectId);

}
