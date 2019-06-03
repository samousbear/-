<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="1" align="center">
		<caption>员工管理</caption>
		<tr>
			<th>序号</th>
			<th>员工姓名</th>
			<th>职位</th>
			<th>上级</th>
			<th>入职日期</th>
			<th>工资</th>
			<th>奖金</th>
			<th>部门</th>
			<th>转部门</th>
			<th>删除</th>
		</tr>
		<c:forEach var="emp" items="${emps }" varStatus="i">
			<tr>
				<th>${(pb.pageNum-1)*pb.pageRow+i.index+1 }</th>
				<th>${emp.ename }</th>
				<th>${emp.job }</th>
				
				<c:forEach var="emp2" items="${pb.list }">
					<c:if test="${emp.mgr==emp2.empno }">
						<th>${emp2.ename }</th>
					</c:if>
				</c:forEach>
				<c:if test="${emp.mgr==''}">
					<th>is Boss</th>
				</c:if>
				<th>${emp.hiredate }</th>
				<th>${emp.sal }</th>
				<th>${emp.comm }</th>
				<c:forEach var="dept" items="${depts }">
					<c:if test="${emp.deptno==dept.deptno }">
						<th>${dept.dname }</th>
					</c:if>
				</c:forEach>
				<th><a href="EmpServlet.do?method=turnDept&empno=${emp.empno }">转部门</a></th>
				<th><a href="EmpServlet.do?method=delEmp&empno=${emp.empno }">删除</a></th>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="9">
				<a href="EmpServlet.do?pageNum=1">首页</a>
				<a href="EmpServlet.do?pageNum=${pb.pageNum==1?1:pb.pageNum-1 }">上一页</a>
				<a href="EmpServlet.do?pageNum=${pb.pageNum==pb.countPage?pb.countPage:pb.pageNum+1 }">下一页</a>
				<a href="EmpServlet.do?pageNum=${pb.countPage }">末页</a>
			</th>
		</tr>
	</table>
	<a href="EmpServlet.do?method=findAll2">添加员工</a>
</body>
</html>