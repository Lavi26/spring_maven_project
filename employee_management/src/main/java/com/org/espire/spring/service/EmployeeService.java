package com.org.espire.spring.service;


import com.org.espire.spring.model.Employee;

public interface EmployeeService {

	// add
	Employee addEmployee(Employee employee);

	// get
	Employee getEmployeeById(Integer id);

	// Delete
	void deleteEmployeeById(Integer id);

	// Update
	Employee updateEmployeeById(Integer id, Employee employee);


}
