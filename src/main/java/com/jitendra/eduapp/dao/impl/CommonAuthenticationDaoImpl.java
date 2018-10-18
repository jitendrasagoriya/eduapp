package com.jitendra.eduapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.CommonAuthenticationDao;
import com.jitendra.eduapp.domin.Authentication;
import com.jitendra.eduapp.domin.Student;
import com.jitendra.eduapp.dto.AuthenticationDto;
import com.jitendra.eduapp.exception.AuthenticateException;
import com.jitendra.eduapp.repository.AuthenticationRepository;
import com.jitendra.eduapp.repository.StudentRepository;


@Service
public class CommonAuthenticationDaoImpl implements CommonAuthenticationDao {
	
	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	@Autowired
	private StudentRepository  studentRepository;

	@Override
	public AuthenticationDto getAuthenticate(String userName, String password) throws AuthenticateException {
		
		Authentication authentication = authenticationRepository.getAuthenticationByUserNameAndPassword(userName, password);
		if (authentication == null) {
			throw new AuthenticateException();
		}
		
		Student student = studentRepository.findById(authentication.getstudentId()).get();
		AuthenticationDto authenticationDto = new AuthenticationDto(student.getName(), authentication.getAccessToken(),
				authentication.getTokenTimeout(),student.getEmail());

		return authenticationDto;		 
	}
}
