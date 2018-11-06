package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Student;
@Service
public interface StudentService {

	public Page<Student> getAll(Pageable pageable);

	public List<Student> getAll();

	public Student getById(Long id);

	public Student save(Student student);

	public Boolean delete(Long id);
	
	public Student getStudentByEmailId(String email);

	public Student getStudentByNickname(String nickname);
	
	public Boolean checkEmail(String email);
	
	public Boolean checkNickname(String nickname);

}
