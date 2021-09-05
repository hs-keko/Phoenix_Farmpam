<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/info.jsp</title>
<style>
	/* 프로필 이미지를 작은 원형으로 만든다 */
	#profileImage{
		width: 50px;
		height: 50px;
		border: 1px solid #cecece;
		border-radius: 50%;
	}
</style>
</head>
<body>
<div class="container">
	<h1> ${email }님의 정보</h1>
	<table>
		<tr>
			<td>
			<c:choose>
				<c:when test="${empty dto.users_profile }">
					<svg id="itemImage" xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
					  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
					</svg>
				</c:when>
				<c:otherwise>
					<img id="profileImage" 
						src="${pageContext.request.contextPath}${dto.users_profile}"/>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${email }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><a href="${pageContext.request.contextPath}/users/private/pwd_updateform.do">수정하기</a></td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.users_name }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.users_addr }</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>${dto.users_addr_detail }</td>
		</tr>
		<tr>
			<th>핸드폰 번호</th>
			<td>${dto.users_phone }</td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td>${dto.users_regdate }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/users/private/updateform.do">개인정보 수정</a>
	<a href="javascript:deleteConfirm()">탈퇴</a>
</div>
<script>
	function deleteConfirm(){
		const isDelete=confirm("${email} 님 탈퇴 하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath}/users/private/delete.do";
		}
	}
</script>
</body>
</html>