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
	<script type="text/javascript" src="<%=path %>/scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
 		$(function(){
			$(":input[name=lastName]").change(function(){
				 var val = $(this).val();
				 val = $.trim(val);
				 var $this = $(this);
				 if(val != ""){
					var url = "emp-validateLastName";
					$this.nextAll("font").remove();
					var args = {"lastName":val,"time":new Date()};
					$.post(url,args,function(data){
						if(data == "1"){//lastName可用
							$this.after("<font color='green'>lastName可用</font>");
						}else if(data = "0"){//lastName不可用
							$this.after("<font color='red'>lastName不可用</font>");
						}else{// 服务器错误
							alert("服务器错误!");
						}
					});
				}else{
					alert("lastName不能为空！");
					$(this).val("");
					$this.focus();
				} 
			});
		});
	</script>
  </head>
  
  <body>
  	<h4>Input New Employee</h4>
  	<s:form action="emp-save" method="post">
	  	<s:if test="id != null">
	  		<s:textfield name="lastName" label="LastName" disabled="true"></s:textfield>
	  		<s:hidden name="id"></s:hidden>
	  		<s:hidden name="lastName"></s:hidden>
	  		<s:hidden name="createTime"></s:hidden>
	  	</s:if>
	  	<s:else>
	  		<s:textfield name="lastName" label="LastName"></s:textfield>
	  	</s:else>
  		<s:textfield name="email" label="Email"></s:textfield>
  		<s:textfield name="birth" label="Birth"></s:textfield>
  		<s:select list="#request.departments" listKey="id" 
  		listValue="departmentName" name="department.id" label="Department"></s:select>
  		<s:submit></s:submit>
  	</s:form>
  </body>
</html>
