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
	<form action="DeptServlet.do?method=editDept" method="post">
		<table width="600" border="1" align="center">
			<caption>部门修改</caption>
			<input type="hidden" name="deptno" id="deptno" value="${dept.deptno }" />
			
			<tr>
				<th>部门名称</th>
				<td><input type="text" name="dname" value="${dept.dname }" /></td>
			</tr>
			<tr>
				<th>所在城市</th>
				<td><input type="text" name="loc" value="${dept.loc }" /></td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="编辑部门" />
					<input type="reset" value="重置" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>