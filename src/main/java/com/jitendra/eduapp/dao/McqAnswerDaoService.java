package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.McqAnswer;
import com.jitendra.eduapp.repository.McqAnswerRepository;


@Service
public interface McqAnswerDaoService extends BaseDaoService<McqAnswerRepository> {

	public McqAnswer getByQuestion(Long id);
}
