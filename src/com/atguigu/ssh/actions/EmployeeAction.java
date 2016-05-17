package com.atguigu.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = -6360419857373646063L;
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String list(){
		request.put("employees", employeeService.findAll());
		return "list";
	}

	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
