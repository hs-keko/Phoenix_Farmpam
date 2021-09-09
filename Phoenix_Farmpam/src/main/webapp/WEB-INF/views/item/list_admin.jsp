<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/item/list_admin.jsp</title>
<style>
	.page-ui a{
		text-decoration: none;
		color: #000;
	}
	
	.page-ui a:hover{
		text-decoration: underline;
	}
	
	.page-ui a.active{
		color: red;
		font-weight: bold;
		text-decoration: underline;
	}
	.page-ui ul{
		list-style-type: none;
		padding: 0;
	}
	
	.page-ui ul > li{
		float: left;
		padding: 5px;
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty email }">
			<p>
				<a href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
				<a href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<strong>${email }</strong> 님 로그인중...
				<a href="${pageContext.request.contextPath}/users/logout.do">로그아웃</a>
			</p>
		</c:otherwise>
	</c:choose>
<h2> ${sessionScope.email }님의 상품 목록 확인하기 </h2>
	<br/>
	<form action="list_admin.do" method="get"> 
		<select name="condition" id="condition">
			<option value="item_title" ${condition eq 'item_title' ? 'selected' : '' }>제목</option>
		</select>
		<input type="text" id="keyword" name="keyword" placeholder="상품검색" value="${keyword }"/>
		<button type="submit">검색</button>
	    <button><a href="${pageContext.request.contextPath}/item/private/insertform.do">추가하기</a></button>
	</form>	
	<br />
	<div class="row">

		<table border="1">
			<thead>
				<tr>
					<th>상품 번호</th>
					<th>이미지</th>
					<th>상품명</th>
					<th>설명</th>
					<th>가격</th>
					<th>재고</th>
					<th>판매자</th>
					<th>수정<th>
					<th>삭제<th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.item_idx }</td>
				<td>${tmp.item_image }</td>
				<td>${tmp.item_title }</td>
				<td>${tmp.item_content }</td>
				<td>${tmp.item_price }</td>
				<td>${tmp.item_stock }</td>
				<td>${tmp.farmer_email }</td>
				<td><a href="${pageContext.request.contextPath}/item/private/updateform.do?item_idx=${tmp.item_idx }">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/item/private/delete.do?item_idx=${tmp.item_idx }">삭제</a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
			<div class="page-ui clearfix">
			<ul>
				<c:if test="${startPageNum ne 1 }">
					<li>
						<a href="list_admin.do?pageNum=${startPageNum-1 }&condition=${condition }&keyword=${encodedK }">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<li>
						<c:choose>
							<c:when test="${pageNum eq i }">
								<a class="active" href="list_admin.do?pageNum=${i }&condition=${condition }&keyword=${encodedK }">${i }</a>
							</c:when>
							<c:otherwise>
								<a href="list_admin.do?pageNum=${i }&condition=${condition }&keyword=${encodedK }">${i }</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:forEach>
				<c:if test="${endPageNum lt totalPageCount }">
					<li>
						<a href="list_admin.do?pageNum=${endPageNum+1 }&condition=${condition }&keyword=${encodedK }">Next</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>