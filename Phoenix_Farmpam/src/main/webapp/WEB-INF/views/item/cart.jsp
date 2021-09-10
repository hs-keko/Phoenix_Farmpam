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
					<td>
						<form href="javascript:" class="update-link" method="post">
							<input type="hidden" name="cart_idx" value="${tmp.cart_idx }" />
							<input type="number" name="cart_amount" value="${tmp.cart_amount}" />
							<button type="submit" class="btn btn-danger">변경</button>
						</form>
					</td>
					<td>${tmp.cart_price }</td>
					<td>
						<a data-num="${tmp.cart_idx }" class="delete-link" href="javascript:">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  								<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  								<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
							</svg>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script>
	addUpdateListener(".update-link");
	addDeleteListener(".delete-link");
	
	// 장바구니 구매수량 변경
	function addUpdateListener(sel){
		// 구매수량 변경 폼의 참조값을 배열에 담아오기
		let updateLink=document.querySelectorAll(sel);
		for(let i=0; i<updateLinks.length; i++){
			updateLinks[i].addEventListener("submit",function(e){
				const cart_idx=this.getAttribute("cart_idx"); //장바구니 번호
				const cart_amount=this.getAttribute("cart_amount"); //주문수량
				const isUpdate=confirm("주문 수량을 변경하시겠습니까?");
				if(isUpdate){
					ajaxPromise("${pageContext.request.contextPath}/item/private/cartupdate.do",
							"post",
							"cart_idx="+cart_idx+"&cart_amount="+cart_amount)
					.then(function(response){
						return response.json();
					})
					.then(function(data){
						if(data.isSuccess){
							alert("주문 수량이 변경되었습니다.");
							location.reload();
						}
					});
				}
			});
		}
	}
	
	// 장바구니 삭제
	function addDeleteListener(sel){
		// 삭제 링크의 참조값을 배열에 담아오기
		let deleteLinks=document.querySelectorAll(sel);
		for(let i=0; i<deleteLinks.length; i++){
			deleteLinks[i].addEventListener("click",function(){
				//click 이벤트가 일어난 바로 그 요소의 data-num 속성의 value 값을 읽어온다.
				const cart_idx=this.getAttribute("data-num"); //장바구니 번호
				const isDelete=confirm("해당 상품을 장바구니에서 삭제하시겠습니까?");
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