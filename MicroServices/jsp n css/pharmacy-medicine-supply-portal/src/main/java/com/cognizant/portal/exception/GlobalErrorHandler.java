package com.cognizant.portal.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * This class handles all the exceptions. Whenever an exception occurs anywhere
 * then first it will be checked whether there is {@link GlobalErrorHandler}
 * declared or not. This has an annotation RestControllerAdvice so it works for
 * all controllers and classes.
 * 
 * @version 1.8
 * @author Pod3
 * @see ResponseEntityExceptionHandler
 */
@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {
	/**
	 * This method will handle all type of exceptions unless no specific method is
	 * written to handle that exception and return the jsp page tokenExpired
	 * 
	 * @param Exception object
	 * @return {@link ModelAndView} object
	 * 
	 */

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllErrors(Exception ex) {
		log.info("Start");
		ModelAndView modelAndView = new ModelAndView("tokenExpired");
		return modelAndView;
	}

	/**
	 * This method will handles {@link MedicineNotFoundException} exception,
	 * whenever there is no medicine present in the stock which is being provided
	 * then from this method it will get handled.
	 * 
	 * @param MedicineNotFoundException object
	 * @return {@link ModelAndView} object contains medicineNotFound.jsp page
	 * 
	 * @see CustomErrorResponse
	 * @see MedicineNotFoundException
	 */
	@ExceptionHandler(MedicineNotFoundException.class)
	public ModelAndView handleAllMedicineStockErrors(MedicineNotFoundException ex) {
		log.info("Start");
		ModelAndView modelAndView = new ModelAndView("medicineNotFound");
		return modelAndView;
	}

}
