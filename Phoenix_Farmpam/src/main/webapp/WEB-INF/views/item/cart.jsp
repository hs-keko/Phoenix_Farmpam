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
					<td><a data-num="${tmp.cart_idx }" class="delete-link" href="javascript:">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script>
	addDeleteListener(".delete-link");
	
	function addDeleteListener(sel){
		// 삭제 링크의 참조값을 배열에 담아오기
		let deleteLinks=document.querySelectorAll(sel);
		for(let i=0; i<deleteLinks.length; i++){
			deleteLinks[i].addEventListener("click",function(){
				//click 이벤트가 일어난 바로 그 요소의 data-num 속성의 value 값을 읽어온다.
				const cart_idx=this.getAttribute("data-num"); //장바구니 번호
				const isDelete=confirm("해당 상품을 장바구니에서 삭제하시겠습니까?")
				if(isDelete){
					// gura_util.js 에 있는 함수들 이용해서 ajax 요청
					ajaxPromise("${pageContext.request.contextPath}/item/private/cartdelete.do", 
							"post", 
							"cart_idx="+cart_idx)
					.then(function(response){
						return response.json();
					})
					.then(function(data){
						//만일 삭제 성공이면
						if(data.isSuccess){
							//알림을 띄워준다
							alert("상품이 삭제되었습니다");
							//페이지 리로드
							location.reload();
						}
					});
				}
			});
		}
	}
</script>
</body>
</html>