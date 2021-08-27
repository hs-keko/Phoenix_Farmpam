<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/signup_before.jsp</title>
</head>
<body>
	<h1>팜팜에 오신 것을 환영합니다!</h1>
	<h2>팜팜 회원 유형을 선택해주세요!</h2>
		<a href="${pageContext.request.contextPath}/users/signup_form.do">일반 유저로 가입하기</a>
		<a href="${pageContext.request.contextPath}/farmer/signup_form_farmer.do">농장주로 가입하기</a>
  <script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script>
	// util 함수 이용해서 ajax 요청
	ajaxPromise("${pageContext.request.contextPath}/users/checkusersemail.do", "get", "inputUsersEmail="+inputUsersEmail)
		.then(function(response){
			return response.json();
		})
</script>
</body>
</html>