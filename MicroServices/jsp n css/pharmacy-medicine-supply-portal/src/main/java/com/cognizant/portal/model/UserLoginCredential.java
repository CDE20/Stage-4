package com.cognizant.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class is used to hold the login credentials which will be sent by the
 * user in the request body for getting the token
 * 
 * @version 1.8
 * @author Pod3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLoginCredential {
	/**
	 * The userid will be unique and it will hold the value which user will send
	 * from the request body for getting the token
	 */
	private String userid;
	/**
	 * This field represents the password and it will hold the value which user will
	 * send from the request body for getting the token
	 */
	private String password;
}
