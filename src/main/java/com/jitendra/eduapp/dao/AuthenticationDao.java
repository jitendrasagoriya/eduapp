package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Authentication;
import com.jitendra.eduapp.repository.AuthenticationRepository;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface AuthenticationDao {
	
	public AuthenticationRepository getRepository();

	public Boolean checkAuthentication(String accessToken);
	
	public Authentication getAuthentication(String accessToken);

	public Boolean updateLastLogin(Long id);
	
	public Boolean updateAccessTokenAndLastLogin(String newAccessToken,String accessToken);
}
