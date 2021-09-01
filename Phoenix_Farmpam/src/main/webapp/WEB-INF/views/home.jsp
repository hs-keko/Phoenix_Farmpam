<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${empty sessionScope.email}">
			<a href="${pageContext.request.contextPath}/users/loginform.do">유저 로그인</a>
			<a href="${pageContext.request.contextPath}/farmer/loginform_farmer.do">농장주 로그인</a>
			<a href="${pageContext.request.contextPath}/users/signup_before.do">회원가입</a>
		</c:when>
		<c:otherwise>		
				<a href="${pageContext.request.contextPath}/users/private/info.do">${sessionScope.email }</a> 유저 로그인중...
				<a href="${pageContext.request.contextPath}/farmer/private/info_farmer.do">${sessionScope.email }</a> 농장주 로그인중...  
				<a href="${pageContext.request.contextPath}/board/list.do">카페글 목록 보기</a>
				<a href="${pageContext.request.contextPath}/users/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>	
<h1>
	공지사항
</h1>
<h2>${notice }</h2>
</body>

</html>









