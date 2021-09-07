<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/item/cart.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>${sessionScope.email} 님의 장바구니 목록입니다.</h1>
	<div class="row">
		<table border="1">
			<tr>
				<th>장바구니 번호</th>
				<th>상품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<td>${tmp.cart_idx }</td>
					<td><a href="${pageContext.request.contextPath}/item/detail.do?item_idx=${tmp.item_idx}">${tmp.item_title }</a></td>
					<td><input type="number" name="cart_amount" value="${tmp.cart_amount}" /></td>
					<td>${tmp.cart_price }</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>