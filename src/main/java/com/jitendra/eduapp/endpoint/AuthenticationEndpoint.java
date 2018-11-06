package com.jitendra.eduapp.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.eduapp.dao.CommonAuthenticationDao;
import com.jitendra.eduapp.dto.AuthenticationDto;
import com.jitendra.eduapp.exception.AuthenticateException;
import com.jitendra.eduapp.password.PasswordUtils;
import com.jitendra.eduapp.service.AuthenticationService;
import com.jitendra.eduapp.tokengenerator.SecureTokenGenerator;

@RestController
@RequestMapping("/api/authentication/")
public class AuthenticationEndpoint {

	@Autowired
	private CommonAuthenticationDao commonAuthenticationDao;
	
	@Autowired
	private AuthenticationService authenticationService;

	@Value("${authenticate.salt}")
	private String salt;

	@PostMapping()
	public ResponseEntity<?> authenticate(@RequestParam(value = "username", required = true) String userName,
			@RequestParam(value = "password", required = true) String password) {
		try {
			AuthenticationDto authenticationDto = commonAuthenticationDao.getAuthenticate(userName,
					PasswordUtils.generateSecurePassword(password, salt));
			String accessToken = SecureTokenGenerator.getToken(authenticationDto.getEmail());
			 
			Boolean isTokenGenerate = authenticationService.updateAccessTokenAndLastLogin(accessToken,authenticationDto.getAccessToken());
			
			if(isTokenGenerate) {
				authenticationDto.setAccessToken(accessToken);
			}else {
				return new ResponseEntity<>("Something went wrong. Please try after sometime", HttpStatus.OK);
			}
			return new ResponseEntity<>(authenticationDto, HttpStatus.OK);
		} catch (AuthenticateException e) {
			return new ResponseEntity<>(e, HttpStatus.OK);
		}
	}

}
