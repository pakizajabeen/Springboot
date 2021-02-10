package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.Service.EmployeeService;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController (EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getSingleEmployee(@PathVariable int employeeId)
	{
		Employee emp= employeeService.getSingleEmployee(employeeId);
		
		if (emp == null)
		{
			throw new RuntimeException("Employee id not found: " + employeeId);
		}
		return emp;
	}

		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee employee)
		{
			employee.setId(0);
			employeeService.save(employee);
			return employee;
		}
		
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee employee)
		{
			employeeService.save(employee);
			return employee;
		}
		
		@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId)
		{
			Employee emp = employeeService.getSingleEmployee(employeeId);
			
			if (emp == null)
			{
				throw new RuntimeException("Employee id not found - " + employeeId);
			}
			
			employeeService.delete(employeeId);
			return "SUCCESSS ... " + "\n " +  employeeId;
		}
}
