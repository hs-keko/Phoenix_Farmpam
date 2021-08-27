<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/farmer/loginform_farmer.jsp</title>
</head>
<body>
<div class="container">
	<h1> 일반유저 로그인 </h1>
	<form action="${pageContext.request.contextPath}/farmer/login_farmer.do" method="post">
		<c:choose>
			<c:when test="${ empty param.url }">
				<input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="url" value="${param.url }"/>
			</c:otherwise>
		</c:choose>
		<div>
			<label for="farmer_email">아이디</label>
			<input type="text" name="farmer_email" id="farmer_email"/>
		</div>
		<div>
			<label for="farmer_pwd">비밀번호</label>
			<input type="password" name="farmer_pwd" id="farmer_pwd"/>
		</div>
		<button type="submit">로그인</button>
	</form>
	<br/>
</div>
</body>
</html>