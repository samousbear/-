<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script>
	$(document).ready(function(){
		for(var i=1980;i<=2019;i++){
			var optionObj = $("<option></option>");
			optionObj.val(i);
			optionObj.html(i);
			$("#year").append(optionObj);
		}
		for(var i=1;i<=12;i++){
			var optionObj = $("<option></option>");
			optionObj.val(i);
			optionObj.html(i);
			$("#month").append(optionObj);
		}
		$("#year").change(function(){
			var yearVal = $("#year").val();
			var monthVal = $("#month").val();
			var d = new Date(yearVal,monthVal,0);
			dateNum = d.getDate();
			showDate();
		});
		$("#month").change(function(){
			var yearVal = $("#year").val();
			var monthVal = $("#month").val();
			var d = new Date(yearVal,monthVal,0);
			dateNum = d.getDate();
			showDate();
		});
		var dateNum = 31;
		showDate();
		function showDate(){
			$("#date").empty();
			for(var i=1;i<=dateNum;i++){
				var optionObj = $("<option></option>");
				optionObj.val(i);
				optionObj.html(i);
				$("#date").append(optionObj);
			}
		}
		$("#empno").blur(function(){
			checkEmpno();
		});
		
		function checkEmpno(){
			var empnoVal = $("#empno").val();
			var zz = /^\d{4}$/;
			var flag = false;
			var message = "<font color='red'>no</font>";
			if(zz.test(empnoVal)){
				flag = true;
				message = "<font color='green'>ok</font>";
			}
			$("#empno").next().html(message);
			return flag;
		}
		function checkAll(){
			return checkEmpno();
		}
		$("form").submit(function(){
			return checkAll();
		});
	});
</script>
</head>
<body>
	<form action="EmpServlet.do?method=addEmp" method="post">
		<table width="600" border="1" align="center">
			<caption>员工添加</caption>
			<tr>
				<th>员工编号</th>
				<td><input type="text" name="empno" id="empno" /><span></span></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input type="text" name="ename" /></td>
			</tr>
			<tr>
				<th>职位</th>
				<td><input type="text" name="job" /></td>
			</tr>
			<tr>
				<th>上级</th>
				<td>
					<select name="mgr">
						<c:forEach var="emp" items="${emps }">
							<option value="${emp.empno }">${emp.ename }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>雇佣日期</th>
				<td>
					<select name="year" id="year">
					</select>年
					<select name="month" id="month">
					</select>月
					<select name="date" id="date">
					</select>日
				</td>
			</tr>
			<tr>
				<th>工资</th>
				<td><input type="text" name="sal" /></td>
			</tr>
			<tr>
				<th>奖金</th>
				<td><input type="text" name="comm" /></td>
			</tr>
			<tr>
				<th>部门</th>
				<td>
					<select name="deptno">
						<c:forEach var="dept" items="${depts }">
							<option value="${dept.deptno }">${dept.dname }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="添加员工" />
					<input type="reset" value="重置" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>