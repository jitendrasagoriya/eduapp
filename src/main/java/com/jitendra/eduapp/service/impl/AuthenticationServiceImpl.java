package com.jitendra.eduapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.AuthenticationDao;
import com.jitendra.eduapp.domin.Authentication;
import com.jitendra.eduapp.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationDao authenticationDao;

	@Override
	public Boolean checkAuthentication(String accessToken) {
		return authenticationDao.checkAuthentication(accessToken);
	}

	@Override
	public Authentication getAuthentication(String accessToken) {
		return authenticationDao.getAuthentication(accessToken);
	}

	@Override
	public Boolean updateLastLogin(Long id) {
		return authenticationDao.updateLastLogin(id);
	}

	@Override
	public Boolean updateAccessTokenAndLastLogin(String newAccessToken, String accessToken) {
		return authenticationDao.updateAccessTokenAndLastLogin(newAccessToken, accessToken);
	}

	@Override
	public Authentication save(Authentication authentication) {
		return authenticationDao.getRepository().save(authentication);
	}

	

	
}
