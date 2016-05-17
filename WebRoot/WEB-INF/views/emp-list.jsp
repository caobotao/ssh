<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp-list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".delete").click(function(){
				var lastName = $(this).next(":hidden").val();
				var flag = confirm("确定要"+lastName+"删除吗？");
				if(flag){
					var $tr = $(this).parent().parent();
					var url = this.href;
					var args = {"time":new Date()};
					$.post(url,args,function(data){
						if(data == "1"){
							//删除成功	
							alert("删除成功！");
							$tr.remove();
						} else{
							//删除失败
							alert("删除失败！");
						}
					});
				} 
				return false;
			});
		})
	</script>
  </head>
  
  <body>
  	<H4>Employee List Page</H4>
  	<s:if test="#request.employees == null || #request.employees.size() == 0">
  		没有任何员工信息
  	</s:if>
  	<s:else>
  		<table border="1" cellpadding="10" cellspacing="0">
  			<tr>
  				<td>ID</td>
  				<td>LASTNAME</td>
  				<td>EMAIL</td>
  				<td>BIRTH</td>
  				<td>CREATETIME</td>
  				<td>DEPARTMENT</td>
  				<td>DELETE</td>
  			</tr>
	  		<s:iterator value="#request.employees" >
	  			<tr>
	  				<td>${id }</td>
	  				<td>${lastName }</td>
	  				<td>${email }</td>
	  				<td>${birth }</td>
	  				<td>${createTime }</td>
	  				<td>${department.departmentName }</td>
	  				<td>
	  					<a class="delete" href="emp-delete?id=${id }">删除</a>
	  					<input type="hidden" value="${lastName }"/>
	  				</td>
	  				
	  			</tr>
	  		</s:iterator>
  		</table>
  		
  	</s:else>
  </body>
</html>
