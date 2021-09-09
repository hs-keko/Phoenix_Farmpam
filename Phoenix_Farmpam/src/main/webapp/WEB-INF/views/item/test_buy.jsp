<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buy test page</title>
</head>
<body>
	<div>
		<form action="buy.do" method="post">
			<input type="text" name="item_idx" placeholder="상품 번호 입력" />
			<input type="text" name="orders_item_total" placeholder="구매할 상품 갯수"/>
			<input type="text" name="orders_addr" placeholder="배송 주소" />
			<button type="submit">구입하기</button>
		</form>
	</div>
</body>
</html>