package com.cognizant.truyum.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.truyum.dao.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{ 
	
	@ExceptionHandler(MenuItemNotFoundException.class)
	public final ResponseEntity<Object> handleItemNotFoundException(MenuItemNotFoundException ex,WebRequest request){
		ExceptionResponse response = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
