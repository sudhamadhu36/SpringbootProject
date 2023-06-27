package com.springbootproject.SpringbootProject.Service.Impl;



/*import java.io.IOException;
import java.util.Date;*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.springbootproject.SpringbootProject.Exception.ResourceNotFoundException;
import com.springbootproject.SpringbootProject.Service.EmployeeService;
import com.springproject.springbootproject.model.Employee;
import com.springproject.springbootproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	//{Long id,String empName, String sex, Date dob, String salary,String department, MultipartFile file)throws IOException
	public Employee createEmployee(Employee employee){
		//byte[] photoBytes=file.getBytes();
		//Employee employee=employeeRepository.findById(id).orElseThrow(()->
		//new ResourceNotFoundException("Employee","Id",id));
		//employee.setPhoto(photoBytes);
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		
		/*Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee","Id",id);
		}*/
		
		return employeeRepository.findById(id).orElseThrow(()->
						new ResourceNotFoundException("Employee","Id",id));
	}


	@Override
	public Employee updateEmployee(long id, Employee employee){
		// we need to check whether employee with given id is existing in database or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setSex(employee.getSex());
		existingEmployee.setDob(employee.getDob());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setDepartment(employee.getDepartment());
		//existingEmployee.setPhoto(employee.getPhoto());
		
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		//check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(()->
						new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}

	
}
