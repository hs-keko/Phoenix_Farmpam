(function(t){function e(e){for(var a,o,s=e[0],l=e[1],c=e[2],u=0,d=[];u<s.length;u++)o=s[u],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&d.push(r[o][0]),r[o]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(t[a]=l[a]);p&&p(e);while(d.length)d.shift()();return i.push.apply(i,c||[]),n()}function n(){for(var t,e=0;e<i.length;e++){for(var n=i[e],a=!0,o=1;o<n.length;o++){var s=n[o];0!==r[s]&&(a=!1)}a&&(i.splice(e--,1),t=l(l.s=n[0]))}return t}var a={},o={app:0},r={app:0},i=[];function s(t){return l.p+"js/"+({about:"about"}[t]||t)+"."+{about:"7b918594","chunk-0b121d8c":"1206f073","chunk-1161a128":"c530e3b0","chunk-135d52d8":"42ed98e3","chunk-2d0a3361":"1a081592","chunk-5d2794ec":"6c37baad","chunk-70f57a9f":"cdeca8cb"}[t]+".js"}function l(e){if(a[e])return a[e].exports;var n=a[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,l),n.l=!0,n.exports}l.e=function(t){var e=[],n={about:1,"chunk-0b121d8c":1,"chunk-1161a128":1,"chunk-135d52d8":1,"chunk-5d2794ec":1,"chunk-70f57a9f":1};o[t]?e.push(o[t]):0!==o[t]&&n[t]&&e.push(o[t]=new Promise((function(e,n){for(var a="css/"+({about:"about"}[t]||t)+"."+{about:"0d5f4eb7","chunk-0b121d8c":"8e31d317","chunk-1161a128":"5abaf36b","chunk-135d52d8":"450b313a","chunk-2d0a3361":"31d6cfe0","chunk-5d2794ec":"0ef02ae6","chunk-70f57a9f":"fc79543e"}[t]+".css",r=l.p+a,i=document.getElementsByTagName("link"),s=0;s<i.length;s++){var c=i[s],u=c.getAttribute("data-href")||c.getAttribute("href");if("stylesheet"===c.rel&&(u===a||u===r))return e()}var d=document.getElementsByTagName("style");for(s=0;s<d.length;s++){c=d[s],u=c.getAttribute("data-href");if(u===a||u===r)return e()}var p=document.createElement("link");p.rel="stylesheet",p.type="text/css",p.onload=e,p.onerror=function(e){var a=e&&e.target&&e.target.src||r,i=new Error("Loading CSS chunk "+t+" failed.\n("+a+")");i.code="CSS_CHUNK_LOAD_FAILED",i.request=a,delete o[t],p.parentNode.removeChild(p),n(i)},p.href=r;var f=document.getElementsByTagName("head")[0];f.appendChild(p)})).then((function(){o[t]=0})));var a=r[t];if(0!==a)if(a)e.push(a[2]);else{var i=new Promise((function(e,n){a=r[t]=[e,n]}));e.push(a[2]=i);var c,u=document.createElement("script");u.charset="utf-8",u.timeout=120,l.nc&&u.setAttribute("nonce",l.nc),u.src=s(t);var d=new Error;c=function(e){u.onerror=u.onload=null,clearTimeout(p);var n=r[t];if(0!==n){if(n){var a=e&&("load"===e.type?"missing":e.type),o=e&&e.target&&e.target.src;d.message="Loading chunk "+t+" failed.\n("+a+": "+o+")",d.name="ChunkLoadError",d.type=a,d.request=o,n[1](d)}r[t]=void 0}};var p=setTimeout((function(){c({type:"timeout",target:u})}),12e4);u.onerror=u.onload=c,document.head.appendChild(u)}return Promise.all(e)},l.m=t,l.c=a,l.d=function(t,e,n){l.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},l.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},l.t=function(t,e){if(1&e&&(t=l(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(l.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)l.d(n,a,function(e){return t[e]}.bind(null,a));return n},l.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return l.d(e,"a",e),e},l.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},l.p="/farmpam/resources/",l.oe=function(t){throw console.error(t),t};var c=window["webpackJsonp"]=window["webpackJsonp"]||[],u=c.push.bind(c);c.push=e,c=c.slice();for(var d=0;d<c.length;d++)e(c[d]);var p=u;i.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";n("85ec")},"355e":function(t,e,n){},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"root"}},[n("header",[n("nav",[n("Nav")],1)]),n("main",[n("router-view")],1),n("footer",[n("h3",[t._v("footer")]),n("li",{staticClass:"nav-item"},[n("router-link",{staticClass:"nav-link",attrs:{to:"/about"}},[t._v("ABOUT")])],1),n("li",{staticClass:"nav-item"},[n("router-link",{staticClass:"nav-link",attrs:{to:"/contack"}},[t._v("CONTACK")])],1)])])},r=[],i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"nav navbar navbar-expand-lg navbar-light"},[a("div",{staticClass:"container-fluid"},[a("div",{staticClass:"logo"},[a("router-link",{staticClass:"navbar-brand",attrs:{to:"/"}},[a("img",{staticClass:"nav_logo",attrs:{src:n("9d64")}})])],1),t._m(0),a("div",{staticClass:"nav_list collapse navbar-collapse bg-white",attrs:{id:"navbarScroll"}},[a("ul",{staticClass:"navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll bg-white",staticStyle:{"--bs-scroll-height":"100px"}},[a("li",{staticClass:"nav-item"},[a("router-link",{staticClass:"nav-link",attrs:{to:"/sns"}},[t._v("Farmstargram")])],1),a("li",{staticClass:"nav-item"},[a("router-link",{staticClass:"nav-link",attrs:{to:"/shop"}},[t._v("SHOP")])],1),a("li",{staticClass:"nav-item dropdown"},[a("a",{staticClass:"nav-link dropdown-toggle",attrs:{href:"#",id:"navbarScrollingDropdown",role:"button","data-bs-toggle":"dropdown","aria-expanded":"false"}},[a("svg",{staticClass:"bi bi-person-circle",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"16",height:"16",fill:"currentColor",viewBox:"0 0 16 16"}},[a("path",{attrs:{d:"M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"}}),a("path",{attrs:{"fill-rule":"evenodd",d:"M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"}})])]),a("ul",{staticClass:"dropdown-menu",attrs:{"aria-labelledby":"navbarScrollingDropdown"}},[t.logintoken.isLogin?t._e():a("li",[a("router-link",{staticClass:"dropdown-item",attrs:{to:"/login"}},[t._v("로그인")])],1),t.logintoken.isLogin?t._e():a("li",[a("router-link",{staticClass:"dropdown-item",attrs:{to:"/signup"}},[t._v("회원가입")])],1),t.logintoken.isLogin?a("li",[a("router-link",{staticClass:"dropdown-item",attrs:{to:"/sns"}},[t._v("팜스타그램")])],1):t._e(),t.logintoken.isLogin?a("li",[a("router-link",{staticClass:"dropdown-item",attrs:{to:"/"}},[t._v("주문목록")])],1):t._e(),t.logintoken.isLogin?a("li",[a("router-link",{staticClass:"dropdown-item",attrs:{to:"/"}},[t._v("취소/반품")])],1):t._e(),t.logintoken.isLogin?a("li",[a("router-link",{staticClass:"dropdown-item",attrs:{to:"/"}},[t._v("찜리스트")])],1):t._e(),t._m(1),t.logintoken.isLogin?a("li",[a("button",{staticClass:"dropdown-item",on:{click:t.logout}},[t._v("로그아웃")])]):t._e()])])])])])])},s=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("button",{staticClass:"navbar-toggler",attrs:{type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarScroll","aria-controls":"navbarScroll","aria-expanded":"false","aria-label":"Toggle navigation"}},[n("span",{staticClass:"navbar-toggler-icon"})])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("li",[n("hr",{staticClass:"dropdown-divider"})])}],l=n("2f62"),c={name:"Nav",computed:Object(l["b"])(["logintoken"]),methods:{logout:function(){this.$store.commit("LOGOUT"),this.$router.push("/")}}},u=c,d=(n("d63f"),n("2877")),p=Object(d["a"])(u,i,s,!1,null,"17f5e803",null),f=p.exports,m={components:{Nav:f}};history.scrollRestoration="manual",window.addEventListener("wheel",(function(t){var e=document.querySelector("header");t.wheelDelta>=120&&(e.style.top="0"),t.wheelDelta<=-120&&(e.style.top="-54px")}),{passive:!1});var h=m,v=(n("034f"),Object(d["a"])(h,o,r,!1,null,null,null)),g=v.exports,b=(n("d3b7"),n("3ca3"),n("ddb0"),n("8c4f")),_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"home"},[n("section",{staticClass:"content01"},[t._m(0),n("div",{staticClass:"ctt01_imglab container"},[n("div",{staticClass:"ctt01_wrapper01"},[t._v("Farmpam")]),n("div",{staticClass:"ctt01_wrapper02 d-flex row justify-content-evenly"},[n("div",{staticClass:"mainintro col-md-5"},[n("p",{staticClass:"mb-3"},[t._v("농장 SNS 팜팜을 사용해 보세요!")]),n("p",[t._v("다양한 농장과 유기농 작물들을 살펴보세요!")]),n("p",[t._v(" 더보기 "),n("svg",{staticClass:"bi bi-arrow-down-circle",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"30",height:"30",fill:"currentColor",viewBox:"0 0 16 16"}},[n("path",{attrs:{"fill-rule":"evenodd",d:"M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"}})])])]),n("div",{staticClass:"toinst col-md-4"}),n("router-link",{staticClass:"\n            intlink\n            d-flex\n            col-md-2\n            justify-content-center\n            align-items-center\n          ",attrs:{to:"/shop"}},[n("span",[t._v("농장 SNS 보러가기 ->")])])],1)])]),t._m(1),t._m(2)])},C=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"home_img"},[a("img",{attrs:{src:n("79a4"),alt:""}})])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("section",{staticClass:"content02 container"},[a("div",{staticClass:"row ctt02wrap"},[a("div",{staticClass:"ctt02_imglab col-md-4"},[a("h3",{staticClass:"mb-3"},[t._v(" 팜팜은 농부와 고객님을 "),a("br"),t._v(" 연결시켜주는 플랫폼입니다. ")]),a("p",[t._v(" 농장 SNS를 통해 .... 주말농장과 같은 나만의 농장 찾기... your own plugin and interact with the others. You can add usefull, highly-demands front-end development tools and libraries as a plugin by using superplate CLI ")])]),a("div",{staticClass:"ctt02_img col-md-5"},[a("div",{staticClass:"ctt02_img_wrapper"},[a("img",{staticClass:"rounded",attrs:{src:n("df17"),alt:""}})])])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("section",{staticClass:"content03 container"},[a("div",{staticClass:"row ctt02wrap"},[a("div",{staticClass:"ctt02_img col-md-5"},[a("div",{staticClass:"ctt02_img_wrapper"},[a("img",{staticClass:"rounded",attrs:{src:n("df17"),alt:""}})])]),a("div",{staticClass:"ctt02_imglab col-md-4"},[a("h3",{staticClass:"mb-3"},[t._v("믿고 구매할 수 있어요!")]),a("p",[t._v(" 농장 SNS를 통해 .... 주말농장과 같은 나만의 농장 찾기... your own plugin and interact with the others. You can add usefull, highly-demands front-end development tools and libraries as a plugin by using superplate CLI ")])])])])}],k={name:"Home",components:{}},w=k,y=(n("93fa"),Object(d["a"])(w,_,C,!1,null,"4bb534d8",null)),S=y.exports;a["a"].use(b["a"]);var L=[{path:"/",name:"Home",component:S},{path:"/about",name:"About",component:function(){return n.e("about").then(n.bind(null,"84ba"))}},{path:"/contack",name:"Contack",component:function(){return n.e("chunk-2d0a3361").then(n.bind(null,"00e0"))}},{path:"/signup",name:"Signup",component:function(){return n.e("chunk-0b121d8c").then(n.bind(null,"c3f0"))}},{path:"/shop",name:"Shop",component:function(){return n.e("chunk-1161a128").then(n.bind(null,"de96"))}},{path:"/sns",name:"Social",component:function(){return n.e("chunk-70f57a9f").then(n.bind(null,"538c"))}},{path:"/products",name:"Products",component:function(){return n.e("chunk-135d52d8").then(n.bind(null,"7079"))}},{path:"/login",name:"Login",component:function(){return n.e("chunk-5d2794ec").then(n.bind(null,"578a"))}}],O=new b["a"]({mode:"history",base:"/farmpam/resources/",routes:L}),x=O,E=n("bc3a"),j=n.n(E);a["a"].use(l["a"]);var T=new l["a"].Store({state:{logintoken:{email:"",auth:"",isLogin:!1}},mutations:{LOGIN_SUCCESS:function(t,e){t.logintoken.email=e.email,t.logintoken.auth=e.chk,t.logintoken.isLogin=!0},LOGIN_FAILURE:function(t,e){},LOGOUT:function(t){t.logintoken.email="",t.logintoken.auth="",t.logintoken.isLogin=!1}},actions:{loginAction:function(t,e){var n=t.commit;j()({url:e.url,method:"POST",headers:{"Content-Type":"application/x-www-form-urlencoded"},data:e.formdata}).then((function(t){console.log(t.data);var e=t.data;return!("failed"in e)&&(n("LOGIN_SUCCESS",e),!0)})).catch((function(t){console.log(t)}))}},getters:{getToken:function(t){return t.logintoken}}});a["a"].config.productionTip=!1,a["a"].prototype.$http=j.a,j.a.defaults.baseURL="http://localhost:8888/farmpam",new a["a"]({store:T,router:x,render:function(t){return t(g)}}).$mount("#app")},"79a4":function(t,e,n){t.exports=n.p+"img/philippe-gauthier-orangeTree.c4b2b078.jpg"},"85ec":function(t,e,n){},"93fa":function(t,e,n){"use strict";n("355e")},"9d64":function(t,e,n){t.exports=n.p+"img/logo.1889e641.png"},d064:function(t,e,n){},d63f:function(t,e,n){"use strict";n("d064")},df17:function(t,e,n){t.exports=n.p+"img/farmer.fdf0746f.jpg"}});
//# sourceMappingURL=app.427d2707.js.map