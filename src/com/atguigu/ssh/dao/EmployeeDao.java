package com.atguigu.ssh.dao;

import java.util.List;

import com.atguigu.ssh.entities.Employee;


public class EmployeeDao extends BaseDao{
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
