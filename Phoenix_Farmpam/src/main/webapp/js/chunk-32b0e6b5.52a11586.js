(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-32b0e6b5"],{4763:function(t,s,i){"use strict";i.r(s);var e=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"more_root container"},[t._m(0),e("div",{staticClass:"list_goods row justify-content-center"},[e("div",{staticClass:"row"},[0==t.list.length?e("ul",{staticClass:"list row row-cols-2 row-cols-sm-2 row-cols-md-3 justify-content-center mt-5 mb-5"},[e("span",{staticClass:"text-muted text-center"},[t._v(" 상품이 없어요 ! ")])]):e("ul",{staticClass:"list row row-cols-2 row-cols-sm-2 row-cols-md-3"},t._l(t.list,(function(s,a){return e("li",{key:a,staticClass:"list-group-item "},[e("div",{staticClass:"item"},[e("div",{staticClass:"row thumb"},[e("router-link",{staticClass:"itemLink",attrs:{to:{name:"GoodsDetail",params:{pagename:"shoppage",itemId:s.item_idx}}}},["empty"!=s.item_image?e("img",{staticClass:"items_iamge",attrs:{src:s.item_image,alt:""}}):e("img",{staticClass:"items_iamge",attrs:{src:i("b601"),alt:""}})]),"chk_farmer"!=t.logintoken.chk?e("div",{staticClass:"group_btn",on:{click:function(i){return t.insertCart(s.item_idx)}}}):t._e()],1),e("div",{staticClass:"row info"},[e("router-link",{staticClass:"row",attrs:{to:""}},[e("span",{staticClass:"title"},[t._v(t._s(s.item_title))]),e("span",{staticClass:"cost"},[t._v(t._s(s.item_price)+" 원")]),e("span",{staticClass:"content"},[t._v(t._s(s.item_content))])])],1)])])})),0)])])])},a=[function(){var t=this,s=t.$createElement,i=t._self._c||s;return i("div",{staticClass:"row"},[i("div",{staticClass:"col"},[t._v("정렬버튼")])])}],o=i("2f62"),n={name:"MoreCategory",data:function(){return{list:[],category:"",buyInfo:{item_idx:0,cart_amount:0}}},computed:Object(o["b"])(["logintoken"]),watch:{"$route.params.category":function(t){this.category=t,console.log(this.category),this.getList()}},created:function(){this.category=this.$route.params.category,this.getList()},methods:{insertCart:function(t){console.log(t),console.log(this.logintoken.email),this.logintoken.token?this.$http.get("/item/private/addcart.do",{params:{item_idx:t,email:this.logintoken.email,cart_amount:this.buyInfo.cart_amount}}).then((function(t){console.log(t.data),t.data.isSuccess?alert("장바구니 추가완료!"):t.data.exists?alert("이미 장바구니에 있는 상품입니다."):alert("추가 실패!")})):alert("로그인해야 장바구니에 담을 수 있어요")},getList:function(){var t=this;this.$http.get("/vue/shopmain/list.do",{params:{category:this.category}}).then((function(s){console.log(s.data),t.list=s.data.list}))}}},c=n,r=(i("dde1"),i("2877")),l=Object(r["a"])(c,e,a,!1,null,"70b6a9f0",null);s["default"]=l.exports},"80c5":function(t,s,i){},b601:function(t,s,i){t.exports=i.p+"img/xbox.b49dedb7.png"},dde1:function(t,s,i){"use strict";i("80c5")}}]);
//# sourceMappingURL=chunk-32b0e6b5.52a11586.js.map