package com.greatlearning.ems.service;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;


@Service
public class EmployeeService {
// data store 	private Set<Employee> employees = new HashSet<>();

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(Employee employee) {
		System.out.println("Saving the Employee to the set");
		Employee savedEmployee = this.employeeRepository.save(employee);
		return savedEmployee;
	}

	public Set<Employee> fetchAllEmployees() {
		return new HashSet<>(this.employeeRepository.findAll());

	}

	public Employee fetchEmployeeById(long employeeId) {
		return this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("invalid employee details passes"));
	}

	public void deleteById(long employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}

	public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
		// TODO Auto-generated method stub
		System.out.println("Passes in Employee is" + updatedEmployee);
		System.out.println("Passes in Employee id is" + employeeId);
		Employee employeeFromRepository = this.fetchEmployeeById(employeeId);
		employeeFromRepository.setFirstName(updatedEmployee.getFirstName());
		employeeFromRepository.setLastName(updatedEmployee.getLastName());
		employeeFromRepository.setEmail(updatedEmployee.getEmail());
		this.employeeRepository.save(employeeFromRepository);
		return employeeFromRepository;
	}

}