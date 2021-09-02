<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/item/list_farmer.jsp</title>
</head>
<body>
<h2> ${sessionScope.email }님의 상품 목록 확인하기 </h2>
	<button>등록하기</button>
	<br/>
	<table border="1">
		<tr>
			<th>상품 번호</th>
			<th>상품 이미지</th>
			<th>상품명</th>
			<th>상품설명</th>
			<th>상품가격</th>
			<th>상품재고</th>
			<th>수정<th>
			<th>삭제<th>
		</tr>
		<c:forEach var="tmp" items="${list }">
		<tr>
			<td>
				${tmp.item_idx }
			</td>
			<td>
				${tmp.item_image }
			</td>
			<td>
				${tmp.item_title }
			</td>
			<td>
				${tmp.item_content }
			</td>
			<td>
				<!-- fmt:formatNumber은 숫자 포맷 변경 ###,###,### -->
				<fmt:formatNumber value="${row.item_price }" parttern="###,###,###"/>
			</td>
			<td>
				${tmp.item_stock }
			</td>
			<td>
				수정
			</td>
			<td>
				삭제
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>