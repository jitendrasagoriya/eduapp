package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dto.AuthenticationDto;
import com.jitendra.eduapp.exception.AuthenticateException;

@Service
public interface CommonAuthenticationDao {
	
	public AuthenticationDto getAuthenticate(String userName, String password) throws AuthenticateException;

}
