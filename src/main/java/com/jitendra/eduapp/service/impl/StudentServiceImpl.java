package com.jitendra.eduapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.StudentDaoService;
import com.jitendra.eduapp.domin.Student;
import com.jitendra.eduapp.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDaoService service;

	@Override
	public Page<Student> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<Student> getAll() {
		return  service.getRepository().findAll();
	}

	@Override
	public Student getById(Long id) {
		try {
			return service.getRepository().findById(id).get();
		}catch (Exception e) {
			return null;
		}
	} 

	@Override
	public Student save(Student student) {
		return service.getRepository().save(student);
	}

	@Override
	public Boolean delete(Long id) {
		try {
			service.getRepository().deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			return Boolean.FALSE;
		}

	}
 

	@Override
	public Boolean checkEmail(String email) {
		if(getStudentByEmailId(email)!=null)
			return Boolean.TRUE;
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkNickname(String nickname) {
		if(getStudentByNickname(nickname)!=null)
			return Boolean.TRUE;
		return Boolean.TRUE;
	}

	@Override
	public Student getStudentByEmailId(String email) {
		return service.getStudentByEmailId(email);
	}

	@Override
	public Student getStudentByNickname(String nickname) {
		return service.getStudentByNickname(nickname);
	}

}
