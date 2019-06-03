<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function back(){
		location.href="DeptServlet.do?method=findAllByPage";
	}
	function flash(){
		location.href="excelList.do";
	}
</script>
</head>
<body>
	<table align="center" border="1" width="400">
		<tr>
		<th>导出文件</th>
		</tr>
		<c:forEach var="file" items="${files }" varStatus="i">
		<tr align="center">
			<td><a href="DownLoad.do?fileName=${file.name }">${file.name}</a></td>
			</tr>
		</c:forEach>
		<tr>
		<td align="center">
		<button type="button" onclick="back()">返回</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="flash()">刷新</button>
		</td>
		</tr>
	
	</table>
</body>
</html>