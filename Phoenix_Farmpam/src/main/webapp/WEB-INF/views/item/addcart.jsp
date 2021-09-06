<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/item/addcart.jsp</title>
</head>
<body>
	<script>
		alert("장바구니에 상품을 담았습니다.");
		location.href="${pageContext.request.contextPath}/item/private/cart.do";
	</script>
</body>
</html>