<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/item/insertform.jsp</title>
<link rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<style>
	/* 사진 */
	#itemImage{
		width: 200px;
		height: 200px;
		border: 1px solid #cecece;
	}
	#imageForm{
		display: none;
	}
</style>	
</head>
<body>
<div class="container">
	<h1>새로운 상품 등록하기</h1>
		<a id="imageLink" href="javascript:">
		<c:choose>
			<c:when test="${empty dto.item_image }">
				<svg id="itemImage" xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
				  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
				</svg>
			</c:when>
			<c:otherwise>
				<img id="itemImage" 
					src="${pageContext.request.contextPath}${dto.item_image}"/>
			</c:otherwise>
		</c:choose>
	</a>
	<form action="${pageContext.request.contextPath}/item/insert.do" method="post">
		<input type="hidden" name="item_image" 
			value="${ empty dto.item_image ? 'empty' : dto.item_image}"/>
		<div>
			<label for="item_title">상품명</label>
			<input type="text" name="item_title" id="item_title"/>
		</div>
		<div>
			<label for="item_content">설명</label>
			<input type="text" name="item_content" id="item_content"/>
		</div>
		<div>
			<label for="item_price">가격</label>
			<input type="number" name="item_price" id="item_price"/>
		</div>
		<div>
			<label for="item_stock">재고</label>
			<input type="number" name="item_stock" id="item_stock"/>
		</div>
		<button type="submit">업로드</button>
	</form>
	
		<form action="${pageContext.request.contextPath}/item/private/ajax_image_upload.do" method="post" 
				id="imageForm" enctype="multipart/form-data">
		<input type="file" name="image" id="image" 
			accept=".jpg, .jpeg, .png, .JPG, .JPEG, .gif"/>
	</form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script>
	//프로필 이미지 링크를 클릭하면 
	document.querySelector("#imageLink").addEventListener("click", function(){
		// input type="image" 을 강제 클릭 시킨다. 
		document.querySelector("#image").click();
	});
	//이미지를 선택했을때 실행할 함수 등록 
	document.querySelector("#image").addEventListener("change", function(){
		
		let form=document.querySelector("#imageForm");
		
		// gura_util.js 에 정의된 함수를 호출하면서 ajax 전송할 폼의 참조값을 전달하면 된다. 
		ajaxFormPromise(form)
		.then(function(response){
			return response.json();
		})
		.then(function(data){
			// data 는 {imagePath:"/upload/xxx.jpg"} 형식의 object 이다.
			console.log(data);
			let img=`<img id="itmeImage" src="${pageContext.request.contextPath}\${data.imagePath}"/>`;
			document.querySelector("#imageLink").innerHTML=img;
			// input name="profile" 요소의 value 값으로 이미지 경로 넣어주기
			document.querySelector("input[name=item_image]").value=data.imagePath;
		});
	});
</script>
</body>
</html>