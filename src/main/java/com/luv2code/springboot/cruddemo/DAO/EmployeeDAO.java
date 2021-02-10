package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee getSingleEmployee(int id);

	public void save (Employee employee);
	
	public void delete(int id);
}
