<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script>
	
</script>
</head>
<body>
	<form action="DeptServlet.do?method=add" method="post">
		<table width="600" border="1" align="center">
			<caption>部门添加</caption>
			<tr>
				<th>部门编号</th>
				<td><input type="text" name="deptno" id="deptno" /><span></span></td>
			</tr>
			<tr>
				<th>部门名称</th>
				<td><input type="text" name="dname" /></td>
			</tr>
			<tr>
				<th>所在城市</th>
				<td><input type="text" name="loc" /></td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="添加部门" />
					<input type="reset" value="重置" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>