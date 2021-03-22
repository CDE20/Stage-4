package com.cognizant.portal.service;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.portal.feign.RepFeignClient;
import com.cognizant.portal.model.UserToken;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provides service to communicate with medical representative
 * schedule service via {@link RepFeignClient}.
 * 

 * 
 * @see RepFeignClient
 * @see HttpHeaders
 */
@Slf4j
@Service
public class MedicalRepFeignService {
	
	/**
	 * private field of type {@link RepFeignClient}
	 * 
	 * @see RepFeignClient
	 */
	@Autowired
	private RepFeignClient repFeignClient;

	/**
	 * Based on the provided dateOfMeeting we will call {@link RepFeignClient}
	 * method getRepSchedule to get the schedule.
	 * 
	 * @param usercredentials
	 * @return {@link UserToken} object
	 */
	public ResponseEntity<?> getRepSchedule(String token, String scheduleStartDate) {
		log.debug("token {}:", token);
		ResponseEntity<?> response = repFeignClient.getRepSchedule(getTokenWithHeader(token), scheduleStartDate);
		log.debug("response {}", response);
		return response;
	}

	/**
	 * This method is used to set the header which we will send to other services
	 * for fetching the data.
	 * 
	 * @param token
	 * @return token
	 */
	public String getTokenWithHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);
		log.debug("headers{}:", headers);
		
		String first = headers.getFirst("Authorization");
		log.debug("first {}:", first);
		
		return first;
	}

}
