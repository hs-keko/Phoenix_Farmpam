<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/item/update.jsp</title>
</head>
<body>
	<script>
		alert("${email} 님 글을 수정 했습니다.");
		location.href="${pageContext.request.contextPath}/item/list.do";
	</script>
</body>
</html>