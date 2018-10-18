package com.jitendra.eduapp.builder;

import java.sql.Timestamp;

import com.jitendra.eduapp.domin.Student;
import com.jitendra.eduapp.dto.StudentDto;

public class StudentBuilder {
	
	private Student student;

	/**
	 * @param flatMate
	 */
	public StudentBuilder() {
		this.student = new Student();
	}
	
	public StudentBuilder(StudentDto studentDto) {
		this.student = new Student();
		this.student.setEmail(studentDto.getEmail());
		this.student.setName(studentDto.getName());
		this.student.setNickName(studentDto.getNickName());
		this.student.setPhoneNumber(studentDto.getPhoneNumber());
		this.student.setJoingDate(new Timestamp(System.currentTimeMillis()));
	}

	public Student build() {
		return this.student;	
	}
}
