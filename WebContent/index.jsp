<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>

</head>
<body>
	<div id="out">
		<div id="title">XXX集团员工管理系统</div>
		<div id="main">
			<div id="left">
				<a href="EmpServlet.do" target="main">员工管理</a>
				<a href="DeptServlet.do" target="main">部门管理</a>
			</div>
			<div id="right">
				<iframe name="main" width="800" height="500" src="EmpServlet.do"></iframe>
			</div>
		</div>
	</div>
</body>
</html>