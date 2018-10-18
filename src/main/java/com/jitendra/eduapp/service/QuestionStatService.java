package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.QuestionStat;
import com.jitendra.eduapp.domin.key.QuestionStatPromeryKey;

@Service
public interface QuestionStatService {
	
	public QuestionStat save(QuestionStat questionStat);

	public Boolean delete(QuestionStatPromeryKey id);

	public QuestionStat update(QuestionStat questionStat);
	
	public Page<QuestionStat> getAll(Pageable pageable);

	public List<QuestionStat> getAll();

	public QuestionStat getById(QuestionStatPromeryKey id);

}
