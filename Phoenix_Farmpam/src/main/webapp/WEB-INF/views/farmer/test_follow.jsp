<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/farmer/test_follow.jsp</title>
</head>
<body>
	<h1> 팔로우 기능 테스트 페이지 </h1>
	<div>
		<h3>팔로우 추가</h3>
		<form action="${pageContext.request.contextPath}/farmer/saveFollow.do" method="post">
			<input type="text" name="farmer_email" placeholder="팔로우 할 농장주 이메일" />
			<button type="submit">팔로우</button>
		</form>
	</div>
	<div>
		<h3>팔로우 해제</h3>
		<form action="${pageContext.request.contextPath}/farmer/removeFollow.do" method="post">
			<input type="text" name="farmer_email" placeholder="팔로우 해제할 농장주 이메일" />
			<button type="submit">팔로우 해제</button>
		</form>
	</div>
</body>
</html>