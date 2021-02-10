package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Query query = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> emp = query.getResultList();
		
		return emp;
	}

	@Override
	public Employee getSingleEmployee(int id) {
		
		Employee emp = entityManager.find(Employee.class, id);
		
		return emp;
		
	}

	@Override
	public void save(Employee employee) {
		
		Employee dbemp = entityManager.merge(employee);
		
		employee.setId(dbemp.getId());

	}

	@Override
	public void delete(int id) {
	
		Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
		
		query.setParameter("employeeId" , id);
		
		query.executeUpdate();

	}

}
