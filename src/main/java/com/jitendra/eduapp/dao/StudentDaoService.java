package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Student;
import com.jitendra.eduapp.repository.StudentRepository;

@Service
public interface StudentDaoService  extends BaseDaoService<StudentRepository>  {
	
	
	public Student getStudentByEmailId(String email);

	public Student getStudentByNickname(String nickname);

}
