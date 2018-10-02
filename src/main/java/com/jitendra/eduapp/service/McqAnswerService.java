package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.McqAnswer;

@Service
public interface McqAnswerService {
	
	public Page<McqAnswer> getAll(Pageable pageable);
	
	public McqAnswer getByQuestion(Long id );

	public List<McqAnswer> getAll();

	public McqAnswer getById(Long id);

	public McqAnswer getByName(String id);

	public McqAnswer save(McqAnswer mcqAnswer);

	public Boolean delete(Long id);

	public McqAnswer update(McqAnswer mcqAnswer);

}
