package com.jitendra.eduapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.SubjectDaoService;
import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.repository.SubjectRepository;
/**
 * @author jitendra sagoriya
 *
 */

@Service
public class SubjectDaoServiceImpl implements SubjectDaoService {
	
	@Autowired
	private SubjectRepository subjectRepository;


	@Override
	public SubjectRepository getRepository() {
		return subjectRepository;
	}


	@Override
	public void batchStore(List<Subject> subjects) {
		subjectRepository.saveAll(subjects);
	}

}
