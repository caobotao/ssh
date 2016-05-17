<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp-input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h4>Input New Employee</h4>
  	<s:form action="emp-save" method="post">
  		<s:textfield name="lastName" label="LastName"></s:textfield>
  		<s:textfield name="email" label="Email"></s:textfield>
  		<s:textfield name="birth" label="Birth"></s:textfield>
  		<s:select list="#request.departments" listKey="id" 
  		listValue="departmentName" name="department.id" label="Department"></s:select>
  		<s:submit></s:submit>
  	</s:form>
  </body>
</html>
