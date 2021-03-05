package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {

	private static List<Department> DEPARTMENT_LIST = new ArrayList<>();
	
	public DepartmentDao() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = applicationContext.getBean("departments", ArrayList.class);
	}
	
	public List<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
	
}
