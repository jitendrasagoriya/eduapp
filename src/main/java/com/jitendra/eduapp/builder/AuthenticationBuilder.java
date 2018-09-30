package com.jitendra.eduapp.builder;

import com.jitendra.eduapp.domin.Authentication;

public class AuthenticationBuilder {
	
	private Authentication authentication;

	/**
	 * @param authentication
	 */
	public AuthenticationBuilder() {
		this.authentication = new Authentication();
	}
	
	/*public AuthenticationBuilder( FlatmateDto flatmateDto , String salt) {
		this.authentication = new Authentication();
		authentication.setAccessToken(SecureTokenGenerator.getToken(flatmateDto.getEmail()));
		authentication.setLastLogin(new Timestamp(System.currentTimeMillis()));
		authentication.setPassword( PasswordUtils.generateSecurePassword(flatmateDto.getPassword(), salt) );
		authentication.setTokenTimeout((long) (30 * 60000));
		authentication.setUserName(flatmateDto.getEmail());
	}
*/
	public Authentication build() {
		return this.authentication;
	}
}
