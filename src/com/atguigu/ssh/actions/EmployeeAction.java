package com.atguigu.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.ssh.service.DepartmentService;
import com.atguigu.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = -6360419857373646063L;
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private Integer id;
	private InputStream inputStream;
	
	/**
	 * 列出所有员工信息
	 * @return
	 */
	public String list() {
		request.put("employees", employeeService.findAll());
		return "list";
	}

	/**
	 * 删除单个员工信息
	 * @return
	 */
	public String delete() {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return "delete";
	}

	/**
	 * 添加一个新员工
	 * @return
	 */
	public String input(){
		request.put("departments", departmentService.findAll());
		return INPUT;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
