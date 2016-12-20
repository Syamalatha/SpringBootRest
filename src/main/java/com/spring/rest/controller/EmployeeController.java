package com.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.bean.Employee;
	
@RestController
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	List<Employee> employeeList = createEmployeeList();
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> getEmployeeList()
	{
		log.info("inside getEmployeeList()");
		return employeeList;
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Employee getCountryById(@PathVariable int id)
	{
		for (Employee employee: employeeList) {
			if(employee.getId()==id)
				return employee;
		}
		
		return null;
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST, headers="Accept=application/json")
	public void createEmployeeRecord(@RequestBody Employee employee) {
		log.info("inside createEmployeeRecord()");
		employeeList.add(employee);

	}


	public List<Employee> createEmployeeList()
	{		
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(101,"David", "William","test@gmail.com", "123-453-6543"));
		employeeList.add(new Employee(102,"Susan", "Micheal","test2@gmail.com", "533-493-6001"));
		employeeList.add(new Employee(103,"Latha", "Test","test3@gmail.com", "254-831-3245"));

		return employeeList;
	}
}
