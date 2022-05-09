package com.org.espire.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.espire.spring.model.Employee;
import com.org.espire.spring.service.EmployeeService;
import com.org.espire.spring.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value="/api/employee/")
public class EmployeeController {
	
	//Injecting the dependencies of employee implementation
	@Autowired
	EmployeeService employeeServiceImpl;

	// add
	@PostMapping("/addEmployeeDetails")
	Employee addEmployeeDetails(@RequestBody Employee employee) {
		return employeeServiceImpl.addEmployee(employee);
	}

	// get
	@GetMapping("/getEmployeeById/{id}")
	Employee getEmployeeDetailsById(@PathVariable("id") Integer id) {
		Employee empId = employeeServiceImpl.getEmployeeById(id);
		return empId;
	}

	// delete
	@DeleteMapping("/deleteEmployeeById/{id}")
	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		employeeServiceImpl.deleteEmployeeById(id);
	}

	// update
	@PutMapping("/updateEmployeeDetails/{id}")
	Employee updateEmployeeDetails(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		Employee empUpdate = employeeServiceImpl.updateEmployeeById(id, employee);
		return empUpdate;
	}
}
