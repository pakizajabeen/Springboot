 package com.luv2code.springboot.cruddemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
		private EmployeeDAO employeeDAO;
			
		public EmployeeServiceImpl( @Qualifier ("employeeDAOJpaImpl") EmployeeDAO employeeDAO)
		{
				this.employeeDAO=employeeDAO;
		}
		
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee getSingleEmployee(int id) {
			
		return employeeDAO.getSingleEmployee(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		employeeDAO.save(employee);

	}

	@Override
	@Transactional
	public void delete(int id) {
		
		employeeDAO.delete(id);
	}

}
