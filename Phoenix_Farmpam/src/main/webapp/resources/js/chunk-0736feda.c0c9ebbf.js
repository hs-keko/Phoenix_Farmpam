(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0736feda"],{"3d37":function(t,s,e){"use strict";e("61f0")},"61f0":function(t,s,e){},c3f0:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"signup"},[a("div",{staticClass:"section section--signup"},[a("div",{staticClass:"inner"},[a("div",{staticClass:"inner-border"},[a("div",{staticClass:"inner--signup"},[a("img",{staticClass:"logo",attrs:{src:e("cf05"),alt:""}}),a("p",{staticClass:"signup__title"},[t._v(" 원하는 농장과 농작물들을 보려면 가입하세요 ")]),a("a",{staticClass:"btn btn-primary mb-3",attrs:{href:"#"}},[t._v("구글계정으로 로그인")]),t._m(0),a("div",{staticClass:"container"},[a("h1",[t._v("회원 가입 폼 입니다.")]),a("form",{ref:"signupForm",staticClass:"d-flex flex-column align-items-baseline",attrs:{action:"http://localhost:8888/farmpam/users/vue/signup.do",method:"post",id:"myForm"},on:{submit:function(s){return s.preventDefault(),t.onSubmit.apply(null,arguments)}}},[a("div",[a("label",{attrs:{for:"users_email"}},[t._v("이메일")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.inputEmail,expression:"inputEmail"}],class:{"is-invalid":!t.isEmailValid,"is-valid":t.isEmailValid},attrs:{type:"text",name:"users_email",id:"users_email"},domProps:{value:t.inputEmail},on:{input:function(s){s.target.composing||(t.inputEmail=s.target.value)}}}),a("div",{staticClass:"invalid-feedback"},[t._v(" 사용할 수 없는 닉네임입니다. ")])]),a("div",{staticClass:"form-group"},[a("label",{attrs:{for:"users_pwd"}},[t._v("비밀번호")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.users_pwd,expression:"users_pwd"}],attrs:{type:"password",name:"users_pwd",id:"users_pwd",placeholder:"password",required:""},domProps:{value:t.users_pwd},on:{input:function(s){s.target.composing||(t.users_pwd=s.target.value)}}}),a("small",{staticClass:"form-text text-muted"},[t._v("5글자~10글자 이내로 입력하세요.")]),a("div",{staticClass:"invalid-feedback"},[t._v("비밀번호를 확인 하세요.")])]),a("div",{staticClass:"form-group"},[a("label",{attrs:{for:"users_pwd2"}},[t._v("비밀번호 확인")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.users_pwd2,expression:"users_pwd2"}],attrs:{type:"password",name:"users_pwd2",id:"users_pwd2",placeholder:"Confirm Password",required:""},domProps:{value:t.users_pwd2},on:{input:function(s){s.target.composing||(t.users_pwd2=s.target.value)}}})]),t._m(1),a("div",[a("label",{attrs:{for:"users_addr"}},[t._v("주소")]),a("input",{attrs:{type:"text",name:"users_addr",id:"users_addr",required:""}}),a("button",{staticClass:"btn btn-primary",attrs:{id:"addr_search",type:"button"},on:{click:t.mapBtn}},[t._v(" 검색하기 ")])]),t._m(2),t._m(3),a("br"),a("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[t._v("가입")])])])])])])])])},i=[function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"line"},[e("p",{staticClass:"or"},[t._v("또는")])])},function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("label",{attrs:{for:"users_name"}},[t._v("이름")]),e("input",{attrs:{type:"text",name:"users_name",id:"users_name",required:""}})])},function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("label",{attrs:{for:"users_addr_detail"}},[t._v("상세 주소")]),e("input",{attrs:{type:"text",name:"users_addr_detail",id:"users_addr_detail",required:""}})])},function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("label",{attrs:{for:"users_phone"}},[t._v("핸드폰 번호")]),e("input",{attrs:{type:"text",name:"users_phone",id:"users_phone",placeholder:"핸드폰번호 입력",maxlength:"13",required:""}})])}],r=e("a18c"),n={name:"Signup",data:function(){return{isEmailValid:!1,inputEmail:"",users_pwd:"",users_pwd2:""}},computed:{},watch:{inputEmail:function(t){var s=this;this.$http.get("http://localhost:8888/farmpam/users/checkusersemail.do?inputUsersEmail="+t).then((function(t){t.data.isExist?s.isEmailValid=!1:s.isEmailValid=!0}))}},methods:{mapBtn:function(){new window.daum.Postcode({oncomplete:function(t){document.getElementById("users_addr").value=t.address;document.querySelector("input[name=users_addr_detail]").focus()}}).open()},onSubmit:function(){var t=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/,s=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;if(this.users_pwd!=this.users_pwd2)return alert("비밀번호가 일치하지 않습니다."),!1;if(!t.test(this.users_pwd))return alert("비밀번호는 숫자, 영문, 특수문자를 포함하여 8글자 이상 16글자 이하로 작성해주세요."),!1;if(!s.test(this.inputEmail))return alert("이메일 형식에 맞게 작성해주세요."),!1;if(1!=this.isEmailValid)alert("존재하는 이메일입니다. 다시 확인해 주세요.");else{var e=new FormData(this.$refs.signupForm);console.log("axiostest"),this.$http.post("http://localhost:8888/farmpam/users/signup.do",e).then((function(t){console.log(t),alert("회원가입 성공!"),r["a"].push({name:"Home"})}))}}}},u=n,l=(e("3d37"),e("2877")),d=Object(l["a"])(u,a,i,!1,null,"1e79d5e5",null);s["default"]=d.exports}}]);
//# sourceMappingURL=chunk-0736feda.c0c9ebbf.js.map