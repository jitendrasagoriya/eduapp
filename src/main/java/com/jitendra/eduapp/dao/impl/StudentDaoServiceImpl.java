package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.StudentDaoService;
import com.jitendra.eduapp.domin.Student;
import com.jitendra.eduapp.repository.StudentRepository;

@Service
public class StudentDaoServiceImpl implements StudentDaoService {

	@Autowired
	private StudentRepository repository;

	@Override
	public StudentRepository getRepository() {
		return repository;
	}

	@Override
	public Student getStudentByEmailId(String email) {
		return repository.getByEmail(email);
	}

	@Override
	public Student getStudentByNickname(String nickname) {
		return repository.getByNickName(nickname);
	}

	 
 

}
