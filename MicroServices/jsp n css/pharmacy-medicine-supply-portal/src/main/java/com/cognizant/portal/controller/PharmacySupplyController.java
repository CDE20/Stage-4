package com.cognizant.portal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.exception.MedicineNotFoundException;
import com.cognizant.portal.feign.SupplyFeignClient;
import com.cognizant.portal.model.MedicineDemand;
import com.cognizant.portal.model.MedicineSupply;
import com.cognizant.portal.service.SupplyFeignService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is handling all the end points for medicine supply and medicine
 * demand related details.
 * 
 * @version 1.8
 * @author Pod3
 * @see SupplyFeignService
 * @see ModelAndView
 * @see MedicineSupply
 * @see MedicineDemand
 */
@Slf4j
@RequestMapping("/user")
@Controller
public class PharmacySupplyController {
	
	/**
	 * Private field of type {@link SupplyFeignService}
	 * 
	 * @see SupplyFeignService
	 */
	@Autowired
	private SupplyFeignService feignService;
	
	/**
	 * Private field of type {@link SupplyFeignClient}
	 * 
	 * @see SupplyFeignClient
	 */
	@Autowired
	private SupplyFeignClient supplyFeignClient;

	List<MedicineSupply> medicineSupplyList = new ArrayList<>();

	/**
	 * Will redirect to the medicineSupplyList.jsp page to display the medicine
	 * supply details. We are getting the token from session object because we will
	 * be needing it to call other services.
	 * 
	 * @param medicineDemand
	 * @param session
	 * @return {@link ModelAndView} object contains medicineSupplyList.jsp page
	 * @throws Exception
	 */
	@RequestMapping("/getMedicineSupply")
	public ModelAndView getMedicineSupply(@ModelAttribute("medicineDemand") MedicineDemand medicineDemand,
			HttpSession session) throws Exception {

		log.info("Start");

		ModelAndView modelAndView = new ModelAndView();
		String token = (String) session.getAttribute("token");
		List<MedicineDemand> medicineDemandList = new ArrayList<>();
		medicineDemandList.add(medicineDemand);
		log.debug("medicineDemand{} :", medicineDemand);

		ResponseEntity<?> response = feignService.getPharmacySupply(token, medicineDemandList);
		if (response.getBody() instanceof String) {
			throw new MedicineNotFoundException("Medicine not found");
		}
		log.debug("response{}:", response);

		medicineSupplyList = (List<MedicineSupply>) response.getBody();
		log.debug("medicineSupplyList{}:", medicineSupplyList);

//		System.out.println(medicineSupplyList);

		modelAndView.setViewName("medicineSupplyList");
		modelAndView.addObject("medicineSupplyList", medicineSupplyList);

		return modelAndView;
	}

	/**
	 * Will redirect to the medicineSupplyList.jsp page to display the medicine
	 * supply details. We are getting the token from session object because we will
	 * be needing it to call other services.
	 * 
	 * @param session
	 * @return {@link ModelAndView} object contains medicineSupplyList.jsp page
	 */
	@RequestMapping("/showMedicineSupply")
	public ModelAndView showMedicineSupply(HttpSession session) {
		String token = (String) session.getAttribute("token");
		List<MedicineSupply> medicineSupply = (List<MedicineSupply>) feignService.getMedicineSupply(token).getBody();
		ModelAndView mv = new ModelAndView("medicineSupplyList");
		mv.addObject("medicineSupplyList", medicineSupply);
		return mv;
	}

	/**
	 * Will redirect to the medicineDemand.jsp page
	 * 
	 * @param medicineDemand
	 * @return
	 */
	@RequestMapping("/medicineDemand")
	public String getMedicineDemandPage(@ModelAttribute("medicineDemand") MedicineDemand medicineDemand) {
		log.info("Start");
		return "medicineDemand";
	}

	/**
	 * Will redirect to the showMedicineDemand.jsp page to display the medicine
	 * demand details. We are getting the token from session object because we will
	 * be needing it to call other services.
	 * 
	 * @param medicineDemand
	 * @param session
	 * @return {@link ModelAndView} object contains showMedicineDemand.jsp page
	 */
	@RequestMapping("/showMedicineDemand")
	public ModelAndView getMedicineDemandList(@ModelAttribute("medicineDemand") MedicineDemand medicineDemand,
			HttpSession session) {
		log.info("Start");
		String token = (String) session.getAttribute("token");
		List<MedicineDemand> medicineDemandList = (List<MedicineDemand>) feignService.getMedicineDemand(token)
				.getBody();
		ModelAndView mv = new ModelAndView("showMedicineDemand");
		mv.addObject("medicineDemandList", medicineDemandList);
		log.debug("medicineDemandList{}:", medicineDemandList);
		return mv;
	}

}
