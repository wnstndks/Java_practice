<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 로그인</title>
<title>쇼핑몰</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript">
window.onload=function(){
	document.querySelector("#btnLogin").onclick=funcLogin;
	document.querySelector("#btnHome").onclick=funcHome;
}

function funcLogin(){
	//alert("a");
	if(loginForm.id.value===""){
		alert("id를 입력하시오");
		loginForm.id.focus();
		return;
	}
	if(loginForm.passwd.value===""){
		alert("passwd를 입력하시오");
		loginForm.passwd.focus();
		return;
	}
	loginForm.submit();
}

function funcHome(){
	//alert("b");
	location.href="../guest/guest_index.jsp";
}
</script>
</head>
<body>
<form action="Loginproc.jsp" name="loginForm" method="post">
<table style="width: 300">
	<tr>
		<td colspan="2" style="text-align: center;">*사용자 로그인*</td>
	</tr>
	<tr>
		<td>i d:</td>
		<td><input type="text" name="id"/> </td>
	</tr>
	<tr>
		<td>pwd:</td>
		<td><input type="text" name="passwd"/> </td>
	</tr>	
	<tr>
		<td colspan="2" style="text-align: center;">
			<input type="button" value="로그인" id="btnLogin">
			<input type="button" value="홈페이지" id="btnHome">
		</td>
	</tr>
</table>
</form>
</body>
</html>