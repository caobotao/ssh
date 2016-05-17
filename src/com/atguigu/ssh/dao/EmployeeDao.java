package com.atguigu.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atguigu.ssh.entities.Employee;


public class EmployeeDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void delete(Integer id){
		String hql = "DELETE FROM Employee e where e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findAll(){
		String hql = "FROM Employee e left outer join fetch e.department";
		return getSession().createQuery(hql).list();
	}
}
