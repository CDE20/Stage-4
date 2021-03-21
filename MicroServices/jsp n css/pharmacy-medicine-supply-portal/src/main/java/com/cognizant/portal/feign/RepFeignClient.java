package com.cognizant.portal.feign;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This interface communicates with medical representative schedule service to
 * get the repSchedule. It takes the url of the service to whom we wants to
 * communicate and the name attribute in annotation FeignClient must be the name
 * we have specified in the properties file of the service to whom we wants to
 * communicate.
 * 
 * @version 1.8
 * @author Pod3
 */
@FeignClient(url = "http://localhost:8082", name = "medical-representative-schedule")
public interface RepFeignClient {

	/**
	 * Calling getRepSchedule method to get the schedule. This method will
	 * communicate with the medical representative schedule service to get the
	 * schedule.
	 * 
	 * @param token
	 * @param dateOfMeeting
	 * @return repSchedule list
	 */
	@GetMapping("/api/medical-representative-schedule/rep-schedule")
	public ResponseEntity<?> getRepSchedule(@RequestHeader(name = "Authorization") String token,
			@DateTimeFormat(pattern = "MM-dd-yyyy") @RequestParam("dateOfMeeting") Date dateOfMeeting);

}
