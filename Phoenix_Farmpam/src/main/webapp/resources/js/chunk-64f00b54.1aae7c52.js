(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-64f00b54"],{"578a":function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"LoginForm"},[a("section",{staticClass:"section section--login"},[a("div",{staticClass:"inner"},[t._m(0),a("div",{staticClass:"inner-border"},[a("div",{staticClass:"inner-form"},[a("img",{staticClass:"logo",attrs:{src:e("9d64"),alt:""}}),a("form",{ref:"loginform",staticClass:"login--form row g-3",attrs:{method:"post",action:"/users/vue/login.do"},on:{submit:function(s){return s.preventDefault(),t.onLogin.apply(null,arguments)}}},[a("div",{staticClass:"col-12 input__text"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],staticClass:"form-control",attrs:{type:"text",id:"users_email",name:"users_email",placeholder:"이메일"},domProps:{value:t.email},on:{input:function(s){s.target.composing||(t.email=s.target.value)}}})]),a("div",{staticClass:"col-12 input__text"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],staticClass:"form-control",attrs:{type:"password",id:"users_pwd",name:"users_pwd",placeholder:"비밀번호"},domProps:{value:t.password},on:{input:function(s){s.target.composing||(t.password=s.target.value)}}})]),a("span",{directives:[{name:"show",rawName:"v-show",value:t.isLogin,expression:"isLogin"}],staticClass:"badge bg-primary"},[t._v("로그인 정보가 틀려요 !")]),t._m(1),t._m(2),a("router-link",{attrs:{to:"/farmerlogin"}},[t._v("농부로 로그인 하기")]),a("a",{staticClass:"google-login mb-3",attrs:{href:"#"}},[t._v("구글 계정으로 로그인")])],1),t._m(3)])])])])])},i=[function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"login-image"},[a("img",{staticClass:"img-fluid",attrs:{src:e("f382"),alt:""}})])},function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"col-12"},[e("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[t._v("로그인")])])},function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"line"},[e("p",{staticClass:"or"},[t._v("또는")])])},function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"signup-link"},[e("p",{staticClass:"mb-2"},[t._v("계정이 없으신가요?")]),e("a",{attrs:{href:"#"}},[t._v("가입하기")])])}],n={name:"Login",components:{},data:function(){return{email:"",password:"",isLogin:!1}},methods:{onLogin:function(){var t=new FormData(this.$refs.loginform);console.log(t.get("users_email"));var s=this.$store.dispatch("loginAction",{form:t,num:0});s?(alert("로그인 성공"),this.$router.push({path:"/"})):this.isLogin=!0}}},o=n,r=(e("7e09"),e("2877")),l=Object(r["a"])(o,a,i,!1,null,"b6a12e1e",null);s["default"]=l.exports},"5cf5":function(t,s,e){},"7e09":function(t,s,e){"use strict";e("5cf5")},f382:function(t,s,e){t.exports=e.p+"img/farm4.077600fc.jpg"}}]);
//# sourceMappingURL=chunk-64f00b54.1aae7c52.js.map