package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.QuestionStatDaoService;
import com.jitendra.eduapp.domin.QuestionStat;
import com.jitendra.eduapp.domin.key.QuestionStatPromeryKey;
import com.jitendra.eduapp.service.QuestionStatService;

@Service
public class QuestionStatServiceImpl implements QuestionStatService {
	
	@Autowired
	private QuestionStatDaoService service;


	@Override
	public QuestionStat save(QuestionStat questionStat) {
		return service.getRepository().save(questionStat);
	}

	@Override
	public Boolean delete(QuestionStatPromeryKey id) {
		try {
			 service.getRepository().deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public QuestionStat update(QuestionStat questionStat) {
		return service.getRepository().save(questionStat);
	}

	@Override
	public Page<QuestionStat> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<QuestionStat> getAll() {
		return service.getRepository().findAll();
	}

	@Override
	public QuestionStat getById(QuestionStatPromeryKey id) {
		return service.getRepository().getOne(id);
	}

}
