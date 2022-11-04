package com.greatlearning.ems.controller;


import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {


	private final EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public Set<Employee> fetchAllEmployee() {
		return this.employeeService.fetchAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") long employeeId) {
		return this.employeeService.fetchEmployeeById(employeeId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.addEmployee(employee);
	}
	

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") long id ,@RequestBody Employee employee) {
		return this.employeeService.updateEmployee(id, employee) ; 
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") long empployeeId) {
		this.employeeService.deleteById(empployeeId);
	}

	
}
