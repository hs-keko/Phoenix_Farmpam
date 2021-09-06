<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/pwd_updateform.jsp</title>
</head>
<body>
<div class="container">
	<h1>비밀 번호 수정 폼</h1>
	<form action="${pageContext.request.contextPath}/users/private/pwd_update.do" method="post" id="myForm">
		<div>
			<label for="users_pwd">기존 비밀 번호</label>
			<input type="password" name="users_pwd" id="users_pwd"/>
		</div>
		<div>
			<label for="users_newPwd">새 비밀번호</label>
			<input type="password" name="users_newPwd" id="users_newPwd"/>
		</div>
		<div>
			<label for="users_newPwd2">새 비밀번호 확인</label>
			<input type="password" id="users_newPwd2"/>
		</div>
		<button type="submit">수정하기</button>
		<button type="reset">리셋</button>
	</form>
</div>
<script>
	//폼에 submit 이벤트가 일어났을때 실행할 함수를 등록하고 
	document.querySelector("#myForm").addEventListener("submit", function(e){
		e.preventDefault();//폼 전송 막기 
		let pwd1=document.querySelector("#users_newPwd").value;
		let pwd2=document.querySelector("#users_newPwd2").value;
		let pwd3=document.querySelector("#users_pwd").value;
		//새 비밀번호와 비밀번호 확인이 일치하지 않으면 폼 전송을 막는다.
		    //비밀번호 일치여부 확인 
		let check = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
		//새 비밀번호와 비밀번호 확인이 일치하지 않으면 폼 전송을 막는다.
		if(pwd1 != pwd2){
			alert("비밀번호가 일치하는지 다시 한 번 확인해주세요!");
			return false;
		}else if(!check.test(pwd1)) { 
			alert("비밀번호는 숫자, 영문, 특수문자를 포함하여 8글자 이상 16글자 이하로 작성해주세요.")
			return false;
		}else if(pwd1 == pwd3){
			alert("기존의 비밀번호와 같습니다.");
			return false;
		}else{
			document.querySelector("#myForm").submit();
		}
	});
</script>
</body>
</html>