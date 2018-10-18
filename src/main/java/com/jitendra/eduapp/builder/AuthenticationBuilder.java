package com.jitendra.eduapp.builder;

import java.sql.Timestamp;

import com.jitendra.eduapp.domin.Authentication;
import com.jitendra.eduapp.dto.StudentDto;
import com.jitendra.eduapp.password.PasswordUtils;
import com.jitendra.eduapp.tokengenerator.SecureTokenGenerator;

/**
 * @author jitendra sagoriya
 *
 */
public class AuthenticationBuilder {
	
	private Authentication authentication;

	/**
	 * @param authentication
	 */
	public AuthenticationBuilder() {
		this.authentication = new Authentication();
	}
	
	public AuthenticationBuilder( StudentDto studentDto , String salt) {
		this.authentication = new Authentication();
		authentication.setAccessToken(SecureTokenGenerator.getToken(studentDto.getEmail()));
		authentication.setLastLogin(new Timestamp(System.currentTimeMillis()));
		authentication.setPassword( PasswordUtils.generateSecurePassword(studentDto.getPassword(), salt) );
		authentication.setTokenTimeout((long) (30 * 60000));
		authentication.setUserName(studentDto.getEmail());
	}

	public Authentication build() {
		return this.authentication;
	}
}
