package com.atguigu.ssh.service;


import java.util.List;

import com.atguigu.ssh.dao.EmployeeDao;
import com.atguigu.ssh.entities.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public boolean isLastNameValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
}
