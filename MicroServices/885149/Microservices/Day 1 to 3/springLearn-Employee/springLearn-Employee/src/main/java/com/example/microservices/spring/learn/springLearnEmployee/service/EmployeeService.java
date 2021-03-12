package com.example.microservices.spring.learn.springLearnEmployee.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservices.spring.learn.springLearnEmployee.model.Employee;
@Service
public class EmployeeService {
	private static List<Employee> empList= new ArrayList<>();
	
	static {
		Employee e1 = new Employee();
		e1.setId(101);
		e1.setPermanent(true);
		e1.setName("Suresh");
		e1.setSalary(50000);
		e1.setDateOfBirth(new Date());
		empList.add(e1);
		Employee e2 = new Employee();
		e2.setId(102);
		e2.setPermanent(true);
		e2.setName("Naresh");
		e2.setSalary(30000);
		e2.setDateOfBirth(new Date());
		empList.add(e2);
	}
	
	public List<Employee> getAllEmployee(){
		return empList;
	}
	
	

}
