 package com.luv2code.springboot.cruddemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepo;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
		private EmployeeRepo employeeRepo;
			
		public EmployeeServiceImpl( EmployeeRepo employeeRepo)
		{
				this.employeeRepo = employeeRepo;
		}
		
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getSingleEmployee(int id) {
			
		Optional<Employee> result = employeeRepo.findById(id);
		
		Employee emp = null;
		
		if(result.isPresent())
		{
			emp = result.get();
		}
		else
		{
			// we did'nt find the employee
			throw new RuntimeException("Did not find employee id " + id);
		}
		
		return emp;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepo.save(employee);

	}

	@Override
	public void delete(int id) {
		
		employeeRepo.deleteById(id);
	}

}
