package com.cognizant.portal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.model.RepSchedule;
import com.cognizant.portal.service.MedicalRepFeignService;
import com.cognizant.portal.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is handling all the end points for medical representative related
 * details. This controller has mapping which will be used to redirect the user
 * to the create schedule page.
 * 
 * @version 1.8
 * @author Pod3
 */
@Slf4j
@RequestMapping("/user")
@Controller
public class MedicalRepresentativeController {

	/**
	 * Private field of type {@link MedicalRepFeignService}
	 */
	@Autowired
	private MedicalRepFeignService feignService;

	/**
	 * Will redirect to the giveRepScheduleDate.jsp page
	 * 
	 * @return giveRepScheduleDate.jsp
	 */
	@RequestMapping("/schedule")
	public String getRepSchedule() {
		log.info("Start");
		return "giveRepScheduleDate";
	}

	/**
	 * 
	 * Will redirect to the repScheduleList.jsp page to display the schedule. We are
	 * getting the token from session object because we will be needing it to call
	 * other services.
	 * 
	 * @param dateOfMeeting
	 * @param session
	 * @return {@link ModelAndView} object contains repScheduleList.jsp page and an
	 *         Object repScheduleList
	 * @throws Exception
	 */
	@RequestMapping("/createSchedule")
	public ModelAndView createSchedule(@RequestParam("dateOfMeeting") String dateOfMeeting, HttpSession session)
			throws Exception {
		log.debug("dateOfMeeting{}:", dateOfMeeting);
		ModelAndView modelAndView = new ModelAndView();
		String token = (String) session.getAttribute("token");
		log.debug("token{}:", token);
		ResponseEntity<?> response = feignService.getRepSchedule(token, DateUtil.convertToDate(dateOfMeeting));
		log.debug("response{}:", response);
		List<RepSchedule> repScheduleList = (List<RepSchedule>) response.getBody();
		log.debug("medicineStock{}:", repScheduleList);
		modelAndView.setViewName("repScheduleList");
		modelAndView.addObject("repScheduleList", repScheduleList);
		return modelAndView;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.info("Start");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

	}

}
