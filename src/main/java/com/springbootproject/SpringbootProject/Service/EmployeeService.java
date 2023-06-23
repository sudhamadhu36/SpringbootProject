package com.springbootproject.SpringbootProject.Service;

import java.util.List;

import com.springproject.springbootproject.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long id);
	public Employee updateEmployee(long id,Employee employee);
	void deleteEmployee(long id);
}
