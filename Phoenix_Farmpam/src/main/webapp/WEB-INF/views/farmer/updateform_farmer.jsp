<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/farmer/updateform.jsp</title>
<style>
	/* 프로필 이미지를 작은 원형으로 만든다 */
	#profileImage{
		width: 50px;
		height: 50px;
		border: 1px solid #cecece;
		border-radius: 50%;
	}
	#imageForm{
		display: none;
	}
</style>
</head>
<body>
<div class="container">
	<h1>${email }님의 가입정보 수정</h1>
	<a id="profileLink" href="javascript:">
		<c:choose>
			<c:when test="${empty dto.farmer_profile }">
				<svg id="profileImage" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
				</svg>
			</c:when>
			<c:otherwise>
				<img id="profileImage" 
					src="${pageContext.request.contextPath}${dto.farmer_profile}" />
			</c:otherwise>
		</c:choose>
	</a>
	<form action="${pageContext.request.contextPath}/farmer/private/update_farmer.do" method="post">
		<input type="hidden" name="farmer_profile" 
			value="${ empty dto.farmer_profile ? 'empty' : dto.farmer_profile}"/>
		<div>
			<label for="farmer_email">아이디</label>
			<input type="text" id="farmer_email" value="${email }" disabled/>
		</div>
		<div>
			<label for="farmer_name">이름</label>
			<input type="text" name="farmer_name" id="farmer_name" value="${dto.farmer_name }"/>
		</div>
		<div>
			<label for="farmer_addr">주소</label>
			<input type="text" name="farmer_addr" id="farmer_addr" value="${dto.farmer_addr }"/>
			<button id="addr_search" class="btn btn-primary" type="button">검색하기</button>
		</div>
		<div>
			<label for="farmer_addr_detail">상세주소</label>
			<input type="text" name="farmer_addr_detail" id="farmer_addr_detail" value="${dto.farmer_addr_detail }"/>
		</div>
		<div>
			<label for="farmer_phone">핸드폰 번호</label>
			<input type="text" name="farmer_phone" id="farmer_phone" value="${dto.farmer_phone }" maxlength="13" />
		</div>

		<button type="submit">수정반영</button>
	</form>
	
	<form action="${pageContext.request.contextPath}/farmer/private/ajax_profile_upload_farmer.do" method="post" 
				id="imageForm" enctype="multipart/form-data">
		<input type="file" name="image" id="image" 
			accept=".jpg, .jpeg, .png, .JPG, .JPEG, .gif"/>
	</form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//프로필 이미지 링크를 클릭하면 
	document.querySelector("#profileLink").addEventListener("click", function(){
		// input type="file" 을 강제 클릭 시킨다. 
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
			let img=`<img id="profileImage" src="${pageContext.request.contextPath}\${data.imagePath}"/>`;
			document.querySelector("#profileLink").innerHTML=img;
			// input name="profile" 요소의 value 값으로 이미지 경로 넣어주기
			document.querySelector("input[name=farmer_profile]").value=data.imagePath;
		});
	});
	
	
	// 핸드폰 하이픈 넣기
	function autoHypenPhone(str){
	    str = str.replace(/[^0-9]/g, '');
	    var tmp = '';
	    if( str.length < 4){
	        return str;
	    }else if(str.length < 7){
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3);
	        return tmp;
	    }else if(str.length < 11){
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3, 3);
	        tmp += '-';
	        tmp += str.substr(6);
	        return tmp;
	    }else{              
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3, 4);
	        tmp += '-';
	        tmp += str.substr(7);
	        return tmp;
	    }
	    return str;
	}

	var farmer_phone = document.getElementById('farmer_phone');
	farmer_phone.onkeyup = function(event){
		event = event || window.event;
		var _val = this.value.trim();
		this.value = autoHypenPhone(_val) ;
	}
		
		
	// 주소 API 사용하기
	window.onload = function(){
    document.getElementById("addr_search").addEventListener("click", function(){ //주소입력칸을 클릭하면
    
    //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                let farmer_addr = document.getElementById("farmer_addr").value = data.address; // 주소 넣기
                document.querySelector("input[name=farmer_addr_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}
</script>
</body>
</html>