package com.springbootproject.SpringbootProject.Service;


/*import java.io.IOException;
import java.util.Date;*/
import java.util.List;

//import org.springframework.web.multipart.MultipartFile;


import com.springproject.springbootproject.model.Employee;

public interface EmployeeService {
	
	//createEmployee(Long id,String empName, String sex, Date dob, String salary, String department,MultipartFile file) throws IOException;
	
	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long id);
	public Employee updateEmployee(long id,Employee employee);
	void deleteEmployee(long id);
}
