<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup.jsp</title>
</head>
<body>
<div id="container">
	<p>
		<strong>${param.users_email }</strong> 회원님, 가입을 진심으로 환영합니다!
		<a href="${pageContext.request.contextPath }/users/loginform.do">로그인 하러 바로가기</a>
	</p>
</div>
</body>
</html>