package com.cognizant.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class is used to hold the values which will come as a response when we
 * will send the user login credentials from request body to the method login()
 * in {@link AuthController}. The response will be containing the userid and
 * token.
 * 
 * @version 1.8
 * @author Pod3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserToken {

	/**
	 * This field will contain the userid
	 */
	private String userid;

	/**
	 * This field will contain the jwt token
	 */
	private String authToken;
}
