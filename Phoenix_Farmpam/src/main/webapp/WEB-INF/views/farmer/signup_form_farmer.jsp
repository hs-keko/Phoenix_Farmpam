<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/farmer/signup_form_farmer.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>회원 가입 폼 입니다.</h1>
	<form action="${pageContext.request.contextPath}/farmer/signup_farmer.do" method="post" id="myForm">
		<div>
			<label for="farmer_email">이메일</label>
			<input type="text" name="farmer_email" id="farmer_email"/>
			<div class="invalid-feedback">사용할 수 없는 닉네임입니다.</div>
		</div>
		<div class="form-group">
			<label for="farmer_pwd">비밀번호</label>
			<input type="password" name="farmer_pwd" id="farmer_pwd" placeholder="password" required>
			<small class="form-text text-muted">8글자~16글자 이내로 입력하세요.</small>
			<div class="invalid-feedback">비밀번호를 확인 하세요.</div>
		</div>
		<div class="form-group">
			<label for="farmer_pwd2">비밀번호 확인</label>
			<input type="password" name="farmer_pwd2" id="farmer_pwd2" placeholder="Confirm Password" required>
		</div>
		<div>
			<label for="farmer_name">이름</label>
			<input type="text" name="farmer_name" id="farmer_name" required/>
		</div>
		<div>
			<label for="farmer_addr">주소</label>
			<input type="text" name="farmer_addr" id="farmer_addr" required/>
			<button id="addr_search" class="btn btn-primary" type="button">검색하기</button>
		</div>
		<div>
			<label for="farmer_addr_detail">상세 주소</label>
			<input type="text" name="farmer_addr_detail" id="farmer_addr_detail" required/>
		</div>
		<div>
			<label for="farmer_phone">핸드폰 번호</label>
			<input type="text" name="farmer_phone" id="farmer_phone" placeholder="핸드폰번호 입력" maxlength="13" required/>
		</div>
		<br/>
		<button class="btn btn-primary" type="submit">가입</button>
	</form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	// 이메일, 비밀번호, 약관동의의 유효성 여부를 관리한 변수 만들고 초기값 대입
	let isEmailValid=false;

	//아이디를 입력했을때(input) 실행할 함수 등록 
	document.querySelector("#farmer_email").addEventListener("input", function(){
	//일단 is-valid,  is-invalid 클래스를 제거한다.
	document.querySelector("#farmer_email").classList.remove("is-valid");
	document.querySelector("#farmer_email").classList.remove("is-invalid");
	
	//1. 입력한 아이디 value 값 읽어오기  
	const inputEmail=this.value;
	
	//2. util 에 있는 함수를 이용해서 ajax 요청하기
	ajaxPromise("${pageContext.request.contextPath}/farmer/checkfarmeremail.do", "get", "inputFarmerEmail="+inputEmail)
	.then(function(response){
	  return response.json();
	})
	.then(function(data){
	  console.log(data);
	  //data 는 {isExist:true} or {isExist:false} 형태의 object 이다.
	  if(data.isExist){//만일 존재한다면
	     //사용할수 없는 아이디라는 피드백을 보이게 한다. 
	     isEmailValid=false;
	     // is-invalid 클래스를 추가한다. 
	     document.querySelector("#farmer_email").classList.add("is-invalid");
	  }else{
	     isEmailValid=true;
	     document.querySelector("#farmer_email").classList.add("is-valid");
	      }
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
	
    //비밀번호 일치여부 확인 
	document.querySelector("#myForm").addEventListener("submit", function(e){
		e.preventDefault();//폼 전송 막기 
		let farmer_pwd=document.querySelector("#farmer_pwd").value;
		let farmer_pwd2=document.querySelector("#farmer_pwd2").value;
		let farmer_email=document.querySelector("#farmer_email").value;
		let check = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
		let check2 =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			//새 비밀번호와 비밀번호 확인이 일치하지 않으면 폼 전송을 막는다.
			if(farmer_pwd != farmer_pwd2){
				alert("비밀번호가 일치하지 않습니다.");
				farmer_pwd.value="";
				farmer_pwd2.value="";
				return false;
			}else if(!check.test(farmer_pwd)) { 
				alert("비밀번호는 숫자, 영문, 특수문자를 포함하여 8글자 이상 16글자 이하로 작성해주세요.")
				farmer_pwd.value="";
				farmer_pwd2.value="";
				return false;
			}else if(!check2.test(farmer_email)){
				alert("이메일 형식에 맞게 작성해주세요.")
				farmer_email.value="";
				return false;
			}else if(isEmailValid != true){
				alert("존재하는 이메일입니다. 다시 확인해 주세요.")
				farmer_email.value="";
			}else{
				document.querySelector("#myForm").submit();
			}
	});

</script>
</body>
</html>





