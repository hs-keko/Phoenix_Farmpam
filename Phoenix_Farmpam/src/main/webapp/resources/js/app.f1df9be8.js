(function(t){function e(e){for(var n,r,i=e[0],l=e[1],c=e[2],u=0,d=[];u<i.length;u++)r=i[u],Object.prototype.hasOwnProperty.call(o,r)&&o[r]&&d.push(o[r][0]),o[r]=0;for(n in l)Object.prototype.hasOwnProperty.call(l,n)&&(t[n]=l[n]);p&&p(e);while(d.length)d.shift()();return s.push.apply(s,c||[]),a()}function a(){for(var t,e=0;e<s.length;e++){for(var a=s[e],n=!0,r=1;r<a.length;r++){var i=a[r];0!==o[i]&&(n=!1)}n&&(s.splice(e--,1),t=l(l.s=a[0]))}return t}var n={},r={app:0},o={app:0},s=[];function i(t){return l.p+"js/"+({about:"about"}[t]||t)+"."+{about:"32ce89f7","chunk-0736feda":"c0c9ebbf","chunk-2d0a3361":"60cbaf9d","chunk-8ee9af44":"9470c22f"}[t]+".js"}function l(e){if(n[e])return n[e].exports;var a=n[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,l),a.l=!0,a.exports}l.e=function(t){var e=[],a={about:1,"chunk-0736feda":1,"chunk-8ee9af44":1};r[t]?e.push(r[t]):0!==r[t]&&a[t]&&e.push(r[t]=new Promise((function(e,a){for(var n="css/"+({about:"about"}[t]||t)+"."+{about:"0d5f4eb7","chunk-0736feda":"7997c16c","chunk-2d0a3361":"31d6cfe0","chunk-8ee9af44":"ed73b222"}[t]+".css",o=l.p+n,s=document.getElementsByTagName("link"),i=0;i<s.length;i++){var c=s[i],u=c.getAttribute("data-href")||c.getAttribute("href");if("stylesheet"===c.rel&&(u===n||u===o))return e()}var d=document.getElementsByTagName("style");for(i=0;i<d.length;i++){c=d[i],u=c.getAttribute("data-href");if(u===n||u===o)return e()}var p=document.createElement("link");p.rel="stylesheet",p.type="text/css",p.onload=e,p.onerror=function(e){var n=e&&e.target&&e.target.src||o,s=new Error("Loading CSS chunk "+t+" failed.\n("+n+")");s.code="CSS_CHUNK_LOAD_FAILED",s.request=n,delete r[t],p.parentNode.removeChild(p),a(s)},p.href=o;var f=document.getElementsByTagName("head")[0];f.appendChild(p)})).then((function(){r[t]=0})));var n=o[t];if(0!==n)if(n)e.push(n[2]);else{var s=new Promise((function(e,a){n=o[t]=[e,a]}));e.push(n[2]=s);var c,u=document.createElement("script");u.charset="utf-8",u.timeout=120,l.nc&&u.setAttribute("nonce",l.nc),u.src=i(t);var d=new Error;c=function(e){u.onerror=u.onload=null,clearTimeout(p);var a=o[t];if(0!==a){if(a){var n=e&&("load"===e.type?"missing":e.type),r=e&&e.target&&e.target.src;d.message="Loading chunk "+t+" failed.\n("+n+": "+r+")",d.name="ChunkLoadError",d.type=n,d.request=r,a[1](d)}o[t]=void 0}};var p=setTimeout((function(){c({type:"timeout",target:u})}),12e4);u.onerror=u.onload=c,document.head.appendChild(u)}return Promise.all(e)},l.m=t,l.c=n,l.d=function(t,e,a){l.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},l.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},l.t=function(t,e){if(1&e&&(t=l(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(l.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)l.d(a,n,function(e){return t[e]}.bind(null,n));return a},l.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return l.d(e,"a",e),e},l.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},l.p="/farmpam/resources/",l.oe=function(t){throw console.error(t),t};var c=window["webpackJsonp"]=window["webpackJsonp"]||[],u=c.push.bind(c);c.push=e,c=c.slice();for(var d=0;d<c.length;d++)e(c[d]);var p=u;s.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"034f":function(t,e,a){"use strict";a("85ec")},"1ba9":function(t,e,a){"use strict";a("683a")},"3f6b":function(t,e,a){},"56d7":function(t,e,a){"use strict";a.r(e);a("e260"),a("e6cf"),a("cca6"),a("a79d");var n=a("2b0e"),r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"root"}},[a("header",[a("nav",[a("Nav")],1)]),a("main",[a("router-view")],1),t._m(0)])},o=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("footer",[a("h3",[t._v("footer")])])}],s=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"nav navbar navbar-expand-lg navbar-light"},[n("div",{staticClass:"container-fluid"},[n("div",{staticClass:"logo"},[n("router-link",{staticClass:"navbar-brand",attrs:{to:"/"}},[n("img",{staticClass:"nav_logo",attrs:{src:a("cf05")}})])],1),t._m(0),n("div",{staticClass:"nav_list collapse navbar-collapse bg-white",attrs:{id:"navbarScroll"}},[n("ul",{staticClass:"navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll bg-white",staticStyle:{"--bs-scroll-height":"100px"}},[n("li",{staticClass:"nav-item"},[n("router-link",{staticClass:"nav-link",attrs:{to:"/about"}},[t._v("ABOUT")])],1),n("li",{staticClass:"nav-item"},[n("router-link",{staticClass:"nav-link",attrs:{to:"/contack"}},[t._v("CONTACK")])],1),n("li",{staticClass:"nav-item dropdown"},[n("a",{staticClass:"nav-link dropdown-toggle",attrs:{href:"#",id:"navbarScrollingDropdown",role:"button","data-bs-toggle":"dropdown","aria-expanded":"false"}},[n("svg",{staticClass:"bi bi-person-circle",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"16",height:"16",fill:"currentColor",viewBox:"0 0 16 16"}},[n("path",{attrs:{d:"M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"}}),n("path",{attrs:{"fill-rule":"evenodd",d:"M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"}})])]),n("ul",{staticClass:"dropdown-menu",attrs:{"aria-labelledby":"navbarScrollingDropdown"}},[n("li",[n("router-link",{staticClass:"dropdown-item",attrs:{to:"/login"}},[t._v("로그인")])],1),n("li",[n("router-link",{staticClass:"dropdown-item",attrs:{to:"/signup"}},[t._v("회원가입")])],1)])])])])])])},i=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("button",{staticClass:"navbar-toggler",attrs:{type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarScroll","aria-controls":"navbarScroll","aria-expanded":"false","aria-label":"Toggle navigation"}},[a("span",{staticClass:"navbar-toggler-icon"})])}],l={},c=l,u=(a("1ba9"),a("2877")),d=Object(u["a"])(c,s,i,!1,null,"530021a5",null),p=d.exports,f={components:{Nav:p}};history.scrollRestoration="manual",window.addEventListener("wheel",(function(t){var e=document.querySelector("header");t.wheelDelta>=120&&(e.style.top="0"),t.wheelDelta<=-120&&(e.style.top="-54px")}),{passive:!1});var v=f,m=(a("034f"),Object(u["a"])(v,r,o,!1,null,null,null)),h=m.exports,b=a("a18c"),g=a("bc3a"),w=a.n(g);n["a"].prototype.$http=w.a,n["a"].config.productionTip=!1,new n["a"]({router:b["a"],render:function(t){return t(h)}}).$mount("#app")},"683a":function(t,e,a){},"79a4":function(t,e,a){t.exports=a.p+"img/philippe-gauthier-orangeTree.c4b2b078.jpg"},"7bc9":function(t,e,a){"use strict";a("3f6b")},"85ec":function(t,e,a){},a18c:function(t,e,a){"use strict";a("d3b7"),a("3ca3"),a("ddb0");var n=a("2b0e"),r=a("8c4f"),o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"home"},[a("section",{staticClass:"content01"},[t._m(0),a("div",{staticClass:"ctt01_imglab container"},[a("div",{staticClass:"ctt01_wrapper01"},[t._v("Farmpam")]),a("div",{staticClass:"ctt01_wrapper02 d-flex row justify-content-evenly"},[a("div",{staticClass:"mainintro col-md-5"},[a("p",{staticClass:"mb-3"},[t._v("농장 SNS 팜팜을 사용해 보세요!")]),a("p",[t._v("다양한 농장과 유기농 작물들을 살펴보세요!")]),a("p",[t._v(" 더보기 "),a("svg",{staticClass:"bi bi-arrow-down-circle",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"30",height:"30",fill:"currentColor",viewBox:"0 0 16 16"}},[a("path",{attrs:{"fill-rule":"evenodd",d:"M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"}})])])]),a("div",{staticClass:"toinst col-md-4"}),a("router-link",{staticClass:"\n            intlink\n            d-flex\n            col-md-2\n            justify-content-center\n            align-items-center\n          ",attrs:{to:"/shop"}},[a("span",[t._v("농장 SNS 보러가기 ->")])])],1)])]),t._m(1),t._m(2)])},s=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"home_img"},[n("img",{attrs:{src:a("79a4"),alt:""}})])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"content02 container"},[n("div",{staticClass:"row ctt02wrap"},[n("div",{staticClass:"ctt02_imglab col-md-4"},[n("h3",{staticClass:"mb-3"},[t._v(" 팜팜은 농부와 고객님을 "),n("br"),t._v(" 연결시켜주는 플랫폼입니다. ")]),n("p",[t._v(" 농장 SNS를 통해 .... 주말농장과 같은 나만의 농장 찾기... your own plugin and interact with the others. You can add usefull, highly-demands front-end development tools and libraries as a plugin by using superplate CLI ")])]),n("div",{staticClass:"ctt02_img col-md-5"},[n("div",{staticClass:"ctt02_img_wrapper"},[n("img",{staticClass:"rounded",attrs:{src:a("df17"),alt:""}})])])])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"content03 container"},[n("div",{staticClass:"row ctt02wrap"},[n("div",{staticClass:"ctt02_img col-md-5"},[n("div",{staticClass:"ctt02_img_wrapper"},[n("img",{staticClass:"rounded",attrs:{src:a("df17"),alt:""}})])]),n("div",{staticClass:"ctt02_imglab col-md-4"},[n("h3",{staticClass:"mb-3"},[t._v("믿고 구매할 수 있어요!")]),n("p",[t._v(" 농장 SNS를 통해 .... 주말농장과 같은 나만의 농장 찾기... your own plugin and interact with the others. You can add usefull, highly-demands front-end development tools and libraries as a plugin by using superplate CLI ")])])])])}],i={name:"Home",components:{}},l=i,c=(a("7bc9"),a("2877")),u=Object(c["a"])(l,o,s,!1,null,"37d9969e",null),d=u.exports;n["a"].use(r["a"]);var p=[{path:"/",name:"Home",component:d},{path:"/about",name:"About",component:function(){return a.e("about").then(a.bind(null,"84ba"))}},{path:"/contack",name:"Contack",component:function(){return a.e("chunk-2d0a3361").then(a.bind(null,"00e0"))}},{path:"/signup",name:"Signup",component:function(){return a.e("chunk-0736feda").then(a.bind(null,"c3f0"))}},{path:"/login",name:"Login",component:function(){return a.e("chunk-8ee9af44").then(a.bind(null,"578a"))}}],f=new r["a"]({mode:"history",base:"/farmpam/resources/",routes:p});e["a"]=f},cf05:function(t,e,a){t.exports=a.p+"img/logo.1889e641.png"},df17:function(t,e,a){t.exports=a.p+"img/farmer.fdf0746f.jpg"}});
//# sourceMappingURL=app.f1df9be8.js.map