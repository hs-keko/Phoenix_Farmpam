(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1e910798"],{"578a":function(t,a,s){"use strict";s.r(a);var e=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"LoginForm"},[e("section",{staticClass:"section section--login"},[e("div",{staticClass:"inner"},[t._m(0),e("div",{staticClass:"inner-border"},[e("div",{staticClass:"inner-form"},[e("img",{staticClass:"logo",attrs:{src:s("9d64"),alt:""}}),t._m(1),e("div",{staticClass:"tab-content",attrs:{id:"myTabContent"}},[e("div",{staticClass:"tab-pane fade show active",attrs:{id:"home",role:"tabpanel","aria-labelledby":"home-tab"}},[e("form",{ref:"loginform",staticClass:"login--form row g-3",attrs:{method:"POST",action:"/users/vue/login.do"},on:{submit:function(a){return a.preventDefault(),t.onLogin(0)}}},[e("div",{staticClass:"col-12 input__text"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],staticClass:"form-control",attrs:{type:"text",id:"users_email",name:"users_email",placeholder:"이메일"},domProps:{value:t.email},on:{input:function(a){a.target.composing||(t.email=a.target.value)}}})]),e("div",{staticClass:"col-12 input__text"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],staticClass:"form-control",attrs:{type:"password",id:"users_pwd",name:"users_pwd",placeholder:"비밀번호"},domProps:{value:t.password},on:{input:function(a){a.target.composing||(t.password=a.target.value)}}})]),e("span",{directives:[{name:"show",rawName:"v-show",value:t.isLogin,expression:"isLogin"}],staticClass:"badge bg-primary"},[t._v("로그인 정보가 틀려요 !")]),t._m(2),t._m(3),e("a",{staticClass:"google-login mb-3",attrs:{href:"#"}},[t._v("구글 계정으로 로그인")])])]),e("div",{staticClass:"tab-pane fade",attrs:{id:"profile",role:"tabpanel","aria-labelledby":"profile-tab"}},[e("form",{ref:"f_loginform",staticClass:"login--form row g-3",attrs:{method:"post",action:"/farmer/vue/login.do"},on:{submit:function(a){return a.preventDefault(),t.onLogin(1)}}},[e("div",{staticClass:"col-12 input__text"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],staticClass:"form-control",attrs:{type:"text",id:"farmer_email",name:"farmer_email",placeholder:"이메일"},domProps:{value:t.email},on:{input:function(a){a.target.composing||(t.email=a.target.value)}}})]),e("div",{staticClass:"col-12 input__text"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],staticClass:"form-control",attrs:{type:"password",id:"farmer_pwd",name:"farmer_pwd",placeholder:"비밀번호"},domProps:{value:t.password},on:{input:function(a){a.target.composing||(t.password=a.target.value)}}})]),e("span",{directives:[{name:"show",rawName:"v-show",value:t.isLogin,expression:"isLogin"}],staticClass:"badge bg-primary"},[t._v("로그인 정보가 틀려요 !")]),t._m(4),t._m(5),e("a",{staticClass:"google-login mb-3",attrs:{href:"#"}},[t._v("구글 계정으로 로그인")])])])]),e("div",{staticClass:"signup-link"},[e("p",{staticClass:"mb-2"},[t._v("계정이 없으신가요?")]),e("router-link",{attrs:{to:"/signup"}},[t._v("가입하기")])],1)])])])])])},i=[function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"login-image"},[e("img",{staticClass:"img-fluid",attrs:{src:s("f382"),alt:""}})])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("ul",{staticClass:"nav nav-tabs justify-content-center mb-4",attrs:{id:"myTab",role:"tablist"}},[s("li",{staticClass:"nav-item",attrs:{role:"presentation"}},[s("button",{staticClass:"nav-link active",attrs:{id:"home-tab","data-bs-toggle":"tab","data-bs-target":"#home",type:"button",role:"tab","aria-controls":"home","aria-selected":"true"}},[t._v(" 일반회원 ")])]),s("li",{staticClass:"nav-item",attrs:{role:"presentation"}},[s("button",{staticClass:"nav-link",attrs:{id:"profile-tab","data-bs-toggle":"tab","data-bs-target":"#profile",type:"button",role:"tab","aria-controls":"profile","aria-selected":"false"}},[t._v(" 농부회원 ")])])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"col-12"},[s("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[t._v(" 로그인 ")])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"line"},[s("p",{staticClass:"or"},[t._v("또는")])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"col-12"},[s("button",{staticClass:"btn btn-primary",attrs:{type:"submit"}},[t._v(" 로그인 ")])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"line"},[s("p",{staticClass:"or"},[t._v("또는")])])}],o={name:"Login",components:{},data:function(){return{email:"",password:"",isLogin:!1}},methods:{onLogin:function(t){var a=this,s=new FormData(this.$refs.loginform);t>0&&(s=new FormData(this.$refs.f_loginform)),this.$store.dispatch("loginAction",{form:s,num:t}).then((function(t){console.log("로그인 요청 결과 : "+t),t?(alert("로그인 성공"),a.$router.push({path:"/"})):a.isLogin=!0}))}}},r=o,n=(s("c80b"),s("2877")),l=Object(n["a"])(r,e,i,!1,null,"004c58b7",null);a["default"]=l.exports},c80b:function(t,a,s){"use strict";s("ed3a")},ed3a:function(t,a,s){},f382:function(t,a,s){t.exports=s.p+"img/farm4.077600fc.jpg"}}]);
//# sourceMappingURL=chunk-1e910798.9d58141c.js.map