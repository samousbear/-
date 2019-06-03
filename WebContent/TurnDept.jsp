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
	<form action="EmpServlet.do?method=turnDeptDo" method="post">
		员工姓名:${emp.ename }<br>
		<input type="hidden" name="empno" value="${emp.empno }" />
		<select name="deptno">
			<c:set var="dn"></c:set>
			<c:forEach var="dept" items="${depts }">
				<c:if test="${dept.deptno!=emp.deptno }">
					<option value="${dept.deptno }">${dept.dname }</option>
				</c:if>
				<c:if test="${dept.deptno==emp.deptno }">
					<c:set var="dn" value="${dept.dname }"></c:set>
				</c:if>
			</c:forEach>
		</select>
		当前部门:${dn }<br>
		<button>转部门</button>
	</form>
</body>
</html>