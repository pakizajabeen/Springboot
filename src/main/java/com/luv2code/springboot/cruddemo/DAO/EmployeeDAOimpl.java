package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	// Constructor Injection
	@Autowired
	public EmployeeDAOimpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
		
	}

	@Override
	public Employee getSingleEmployee(int id) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery("delete from Employee where id =:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
	}

}
