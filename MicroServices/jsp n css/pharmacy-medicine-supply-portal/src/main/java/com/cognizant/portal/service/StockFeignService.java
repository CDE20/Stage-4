package com.cognizant.portal.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.portal.feign.StockFeignClient;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provides service to communicate with medicine stock service via
 * {@link StockFeignClient}.
 * 
 * @version 1.8
 * @author Pod3
 * @see StockFeignClient
 * @see HttpHeaders
 */
@Slf4j
@Service
public class StockFeignService {
	/**
	 * private field of type {@link StockFeignClient}
	 * 
	 * @see StockFeignClient
	 * 
	 */
	@Autowired
	private StockFeignClient stockFeignClient;

	/**
	 * We are calling {@link StockFeignClient} method getMedicineStockInformation to
	 * get the medicine stock information.
	 * 
	 * @param token
	 * @return list of medicine stock
	 */
	public ResponseEntity<?> getMedicineStockInformation(String token) {
		log.info("Start");
		log.debug("token{}:", token);
		ResponseEntity<?> response = stockFeignClient.getMedicineStockInformation(getTokenWithHeader(token));
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
		return headers.getFirst("Authorization");
	}

}
