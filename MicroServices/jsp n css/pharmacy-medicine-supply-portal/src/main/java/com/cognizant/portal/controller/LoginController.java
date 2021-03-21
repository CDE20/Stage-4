package com.cognizant.portal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.feign.AuthFeignClient;
import com.cognizant.portal.feign.StockFeignClient;
import com.cognizant.portal.model.UserLoginCredential;
import com.cognizant.portal.model.UserToken;
import com.cognizant.portal.service.AuthFeignService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is handling all the end points for login. This controller has
 * mappings which will be used to redirect the user to the login and home page.
 * 
 * @version 1.8
 * @author Pod3
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class LoginController {

	/**
	 * Used to call the method present in {@link AuthFeignClient} interface
	 */
	@Autowired
	private AuthFeignClient authFeignClient;

	/**
	 * Used to call the method present in {@link StockFeignClient} interface
	 */
	@Autowired
	private StockFeignClient stockFeignClient;

	/**
	 * Used to call the method present in {@link AuthFeignService} class
	 */
	@Autowired
	private AuthFeignService feignService;

	/**
	 * This method will redirect to the login page and we are sending model
	 * attribute {@link UserLoginCredential} which will be used to bind the jsp page
	 * fields to this model attribute.
	 * 
	 * @param usercredentials
	 * @param bindingresult
	 * @return login.jsp page
	 */
	@GetMapping("/login")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredential usercredentials,
			BindingResult bindingresult) {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginMessage", "Please Login");
		return modelAndView;
	}

	/**
	 * This method will return the homepage if the user login credentials are
	 * correct otherwise redirect to the login page only by displaying message as
	 * bad credentials which we are binding in the {@link ModelAndView} type object
	 * 
	 * @param usercredentials
	 * @param bindingresult
	 * @param session
	 * @return homepage.jsp
	 */
	@PostMapping("/homepage")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredential usercredentials,
			BindingResult bindingresult, HttpSession session) {

		log.debug("username{}: ", usercredentials.getUserid());
		ResponseEntity<?> response = null;

		try {
			response = feignService.getToken(usercredentials);
		} catch (Exception e) {
			log.error("Invalid credentials");
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("loginMessage", "bad credentials");
			return modelAndView;
		}

		log.debug("Response{}: ", response);
		log.info("Getting body from response entity");

		UserToken userToken = (UserToken) response.getBody();

		log.debug("token{}:", userToken.getAuthToken());
		log.debug("userToken{}: ", userToken);

		session.setAttribute("token", userToken.getAuthToken());

		log.debug("session{}:", session.toString());

		ModelAndView modelAndView = new ModelAndView("homepage");
		return modelAndView;

	}

	/**
	 * Will redirect to the logout page
	 * 
	 * @return logout.jsp
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("token", null);
		return "logout";
	}

}
