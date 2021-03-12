package com.example.microservices.spring.learn.springLearnEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.spring.learn.springLearnEmployee.model.Employee;
import com.example.microservices.spring.learn.springLearnEmployee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees/all")
	public List<Employee> getAll(){
		return service.getAllEmployee();
	}

}
