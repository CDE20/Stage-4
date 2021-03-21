package com.cognizant.portal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * This interface communicates with medicine stock service to get the stock
 * information. It takes the url of the service to whom we wants to communicate
 * and the name attribute in annotation FeignClient must be the name we have
 * specified in the properties file of the service to whom we wants to
 * communicate.
 * 
 * @version 1.8
 * @author Pod3
 */
@FeignClient(url = "http://localhost:8081", name = "medicine-stock-service")
public interface StockFeignClient {

	/**
	 * Calling getMedicineByTreatingAilment method to get the medicine stock
	 * information based on provided treating ailment. This method will communicate
	 * with the medicine stock service to get the medicine stock information.
	 * 
	 * @param token
	 * @param treatingAilment
	 * @return medicines in string array for a particular treating ailment
	 */
	@PostMapping("/api/medicine-stock/byTreatingAilment/{treatingAilment}")
	public String[] getMedicineByTreatingAilment(@RequestHeader("Authorization") String token,
			@PathVariable("treatingAilment") String treatingAilment);

	/**
	 * Calling getMedicineStockInformation method to get the medicine stock
	 * information. This method will communicate with the medicine stock service to
	 * get the medicine stock information.
	 * 
	 * @param token
	 */
	@GetMapping("/api/medicine-stock/medicine-stock-information")
	public ResponseEntity<?> getMedicineStockInformation(@RequestHeader(name = "Authorization") String token);
}
