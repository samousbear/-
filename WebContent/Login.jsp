<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loadImage() {
		document.getElementById("img1").src="Image.do?time="+new Date().getTime();
	}
</script>
</head>
<body>
	<form action="Login.do" method="post">
	用户名:<input type="text" name="uname" /><br>
	验证码:<input type="text" name="yzm" /><img  src="Image.do" id="img1" onclick="loadImage()"><br>
	<button>登陆</button><br>
	</form>
</body>
</html>