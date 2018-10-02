package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.McqAnswerDaoService;
import com.jitendra.eduapp.domin.McqAnswer;
import com.jitendra.eduapp.service.McqAnswerService;

@Service
public class McqAnswerServiceImpl implements McqAnswerService {
	
	@Autowired
	private McqAnswerDaoService daoService;

	@Override
	public Page<McqAnswer> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public McqAnswer getByQuestion(Long id ) {
		return daoService.getByQuestion(id);
	}

	@Override
	public List<McqAnswer> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public McqAnswer getById(Long id) {
		return daoService.getRepository().getOne(id);
	}

	@Override
	public McqAnswer getByName(String id) {
		return null;
	}

	@Override
	public McqAnswer save(McqAnswer mcqAnswer) {
		return daoService.getRepository().save(mcqAnswer);
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

	@Override
	public McqAnswer update(McqAnswer mcqAnswer) {
		// TODO Auto-generated method stub
		return null;
	}

}
