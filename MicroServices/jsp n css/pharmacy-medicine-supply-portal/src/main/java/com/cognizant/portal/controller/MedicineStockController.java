package com.cognizant.portal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.model.MedicineStock;
import com.cognizant.portal.service.StockFeignService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is handling all the end points for medicine stock related details.
 * This controller has mapping which will be used to redirect the user to the
 * medicineStockList page
 * 
 * @version 1.8
 * @author Pod3
 * @see StockFeignService
 * @see ModelAndView
 * @see MedicineStock
 */
@RequestMapping("/user")
@Slf4j
@Controller
public class MedicineStockController {
	/**
	 * Private field of type {@link StockFeignService}
	 * 
	 * @see StockFeignService
	 */
	@Autowired
	private StockFeignService feignService;

	/**
	 * Will redirect to the medicineStockList.jsp page to display the medicine stock
	 * details. We are getting the token from session object because we will be
	 * needing it to call other services.
	 * 
	 * @param session
	 * @return {@link ModelAndView} object contains medicineStockList.jsp page
	 * @throws Exception
	 */
	@RequestMapping("/medicineStock")
	public ModelAndView getMedicineStockDetails(HttpSession session) throws Exception {
		log.info("Start---------inside getMedicineStockDetails");
		String token = (String) session.getAttribute("token");
		log.info("Calling StockFeignClient");
		ResponseEntity<?> response = feignService.getMedicineStockInformation(token);
		log.debug("response{}:", response);
		List<MedicineStock> medicineStockList = (List<MedicineStock>) response.getBody();
		log.debug("medicineStock{}:", medicineStockList);
		ModelAndView modelAndView = new ModelAndView("medicineStockList");
		modelAndView.addObject("medicineStockList", medicineStockList);
		return modelAndView;
	}

}
