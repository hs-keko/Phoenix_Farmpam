<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/info_farmer.jsp</title>
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
	<h1>${email }님의 정보</h1>
	<table>
		<tr>
			<td>
			<c:choose>
				<c:when test="${empty dto.farmer_profile }">
					<svg id="profileImage" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
				</c:when>
				<c:otherwise>
					<img id="profileImage" 
						src="${pageContext.request.contextPath}${dto.farmer_profile}"/>
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
			<td><a href="${pageContext.request.contextPath}/farmer/private/pwd_updateform_farmer.do">수정하기</a></td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.farmer_name }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.farmer_addr }</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>${dto.farmer_addr_detail }</td>
		</tr>
		<tr>
			<th>핸드폰 번호</th>
			<td>${dto.farmer_phone }</td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td>${dto.farmer_regdate }</td>
		</tr>
		<tr>
			<th>농장 소개글</th>
			<td>${dto.farmer_intro }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/farmer/private/updateform_farmer.do">개인정보 수정</a>
	<a href="javascript:deleteConfirm()">탈퇴</a>
</div>
<script>
	function deleteConfirm(){
		const isDelete=confirm("${email} 님 탈퇴 하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath}/farmer/private/delete_farmer.do";
		}
	}
</script>
</body>
</html>