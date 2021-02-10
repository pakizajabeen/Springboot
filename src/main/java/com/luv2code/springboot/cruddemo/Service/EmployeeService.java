package com.luv2code.springboot.cruddemo.Service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee getSingleEmployee(int id);

	public void save (Employee employee);
	
	public void delete(int id);

}
