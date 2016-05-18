package com.atguigu.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.ssh.entities.Employee;
import com.atguigu.ssh.service.DepartmentService;
import com.atguigu.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware,
										ModelDriven<Employee>,Preparable {

	private static final long serialVersionUID = -6360419857373646063L;
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private Integer id;
	private InputStream inputStream;
	private Map<String, Object> request;
	private Employee model;
	private String lastName;
	
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
		
		return "ajax-success";
	}

	/**
	 * 添加一个新员工
	 * @return
	 */
	public String input(){
		request.put("departments", departmentService.findAll());
		return INPUT;
	}
	
	/**
	 * 保存一个员工信息 
	 * @return
	 */
	public String save(){
		model.setCreateTime(new Date());
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String validateLastName() throws UnsupportedEncodingException{
		if(employeeService.isLastNameValid(lastName)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax-success";
	}
	
	public void prepareSave(){
		model = new Employee();
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {}

	@Override
	public Employee getModel() {
		return model;
	}
}
