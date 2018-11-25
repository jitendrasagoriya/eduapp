package com.jitendra.eduapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.ChapterStatDaoService;
import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.repository.ChapterStatRepository;


@Service
public class ChapterStatDaoServiceImpl implements ChapterStatDaoService {
	
	@Autowired
	private ChapterStatRepository repository;

	@Override
	public ChapterStatRepository getRepository() {
		return repository;
	}

	@Override
	public ChapterStat getResume(Long studentId ) {
		List<ChapterStat> chapterStats = repository.getChapterResume(studentId);
		if(chapterStats!=null && !chapterStats.isEmpty()) {
			return chapterStats.get(0);
		}
		return null;
	}

	@Override
	public ChapterStat getResume(Long studentId, Long subjectId) {
		List<ChapterStat> chapterStats = repository.getChapterResumeBySubject(studentId,subjectId);
		if(chapterStats!=null && !chapterStats.isEmpty()) {
			return chapterStats.get(0);
		}
		return null;
	}

}
