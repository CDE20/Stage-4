package com.cognizant.portal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portal.model.UserLoginCredential;
import com.cognizant.portal.model.UserToken;

/**
 * This interface communicates with authorization service to verify the token.
 * It takes the url of the service to whom we wants to communicate and the name
 * attribute in annotation FeignClient must be the name we have specified in the
 * properties file of the service to whom we wants to communicate.
 * 
 * @version 1.8
 * @author Pod3
 * @see UserLoginCredential
 */
@FeignClient(url = "http://localhost:8084", name = "authorization-service")
public interface AuthFeignClient {

	/**
	 * This method will verify whether user login credentials are correct or not
	 * 
	 * @param usercredentials
	 * @return An object of type {@link UserToken} which has fields userid and
	 *         authToken
	 * 
	 * @see UserToken
	 * @see UserLoginCredential
	 */
	@PostMapping(path = "/api/auth/login")
	public ResponseEntity<UserToken> login(@RequestBody UserLoginCredential usercredentials);

	/**
	 * This method will verify token whether it is valid or not. It is expired or
	 * not.
	 * 
	 * @param token
	 * @return boolean
	 * 
	 * @see AuthResponse//
	 */
	@GetMapping(path = "/api/auth/validate")
	public boolean verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
