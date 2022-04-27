package com.org.espire.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.espire.spring.model.Employee;
import com.org.espire.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//Business logic
	//Injecting the dependencies 
	@Autowired
	EmployeeRepository empRepository;

	//add
	@Override
	public Employee addEmployee(Employee employee) {
		Employee empDetails = empRepository.save(employee);
		return empDetails;
	}

	//get
	@Override
	public Employee getEmployeeById(Integer id) {
		Employee empById = empRepository.findAllById(id);
		return empById;
	}

	//delete
	@Override
	public void deleteEmployeeById(Integer id) {
		empRepository.deleteById(id);

	}

	//update
	@Override
	public Employee updateEmployeeById(Integer id, Employee employee) {
		Employee empUpdate = empRepository.findAllById(id);
		if (employee.getId() == empUpdate.getId()) {
			updateEmployee(employee);
		}
		return empUpdate;
	}

	private Employee updateEmployee(Employee employeeDetails) {
		Employee empDetail = empRepository.save(employeeDetails);
		return empDetail;
	}
}
