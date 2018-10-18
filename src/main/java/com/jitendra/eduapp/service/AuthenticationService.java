package com.jitendra.eduapp.service;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Authentication;


@Service
public interface AuthenticationService {

	public Authentication save(Authentication authentication);

	public Boolean checkAuthentication(String accessToken);

	public Authentication getAuthentication(String accessToken);

	public Boolean updateLastLogin(Long id);

	public Boolean updateAccessTokenAndLastLogin(String newAccessToken, String accessToken);

}
