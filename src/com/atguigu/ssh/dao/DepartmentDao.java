package com.atguigu.ssh.dao;

import java.util.List;

import com.atguigu.ssh.entities.Department;


public class DepartmentDao extends BaseDao{
	@SuppressWarnings("unchecked")
	public List<Department> findAll(){
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}
}
