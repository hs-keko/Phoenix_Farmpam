<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/item/detail.jsp</title>
<link rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1> ${item_title } </h1>
	<p> 상품 번호 : ${item_idx } </p>
	<p> 판매자 이메일 : ${farmer_email } </p>
	<p> 가격 : 개당 ${item_price } 원 </p>
	<p> 재고 : ${item_stock } 개 </p>
	<p> 상세 설명 : ${item_content } </p>
	<br />
	
	<form action="${pageContext.request.contextPath}/item/private/addcart.do" method="post">
		<input type="hidden" name="item_idx" value="${item.idx }"></input>
		<p>담을 상품 갯수 : <input type="number" name="cart_amount" /> 개 </p>
		<button class="btn btn-primary"type="submit">장바구니에 담기</button>
	</form>
</div>
</body>
</html>