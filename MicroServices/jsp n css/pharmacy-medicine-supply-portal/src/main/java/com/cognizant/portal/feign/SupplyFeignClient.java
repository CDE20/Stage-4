package com.cognizant.portal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.portal.model.MedicineDemand;

/**
 * This interface communicates with pharmacy medicine supply service to get the
 * medicine supply and medicine demand information. It takes the url of the
 * service to whom we wants to communicate and the name attribute in annotation
 * FeignClient must be the name we have specified in the properties file of the
 * service to whom we wants to communicate.
 * 
 * @version 1.8
 * @author Pod3
 *
 * @see MedicineDemand
 */
@FeignClient(url = "http://localhost:8083", name = "pharmacy-medicine-supply")
public interface SupplyFeignClient {

	/**
	 * Calling getPharmacySupply method to get the medicine supply information based
	 * on provided medicine demand list. This method will communicate with the
	 * medicine supply service to get information.
	 * 
	 * @param token
	 * @param medicineDemandList
	 * @return list of Medicine Supply
	 */
	@RequestMapping("/api/pharmacy-medicine-supply/pharmacy-supply")
	public ResponseEntity<?> getPharmacySupply(@RequestHeader(name = "Authorization") String token,
			@RequestBody List<MedicineDemand> medicineDemandList);

	/**
	 * Calling getPharmacySupply method to get the medicine supply information. This
	 * method will communicate with the medicine supply service to get information.
	 * 
	 * @param token
	 * @return list of medicine supply
	 */
	@RequestMapping("/api/pharmacy-medicine-supply/getMedicineSupply")
	public ResponseEntity<?> getMedicineSupply(@RequestHeader(name = "Authorization") String token);

	/**
	 * 
	 * Calling getMedicineDemand method to get the medicine demand information. This
	 * method will communicate with the medicine stock service to get the medicine
	 * demand information.
	 * 
	 * @param token
	 * @return list of medicine demand
	 */
	@RequestMapping("/api/pharmacy-medicine-supply/getMedicineDemand")
	public ResponseEntity<?> getMedicineDemand(@RequestHeader(name = "Authorization") String token);

}
