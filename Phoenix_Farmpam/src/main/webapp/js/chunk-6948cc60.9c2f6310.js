(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6948cc60"],{2438:function(t,i,s){"use strict";s.r(i);var e=function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",{staticClass:"buylist container"},[s("div",{staticClass:"row"},[s("div",{staticClass:"section--buy"},[t._m(0),s("div",{staticClass:"buy--border"},[0==t.list.length?s("div",{staticClass:"d-flex justify-content-center align-items-center"},[t._v(" 주문 상품이 없어요 ! ")]):t._l(t.list,(function(i){return s("div",{key:i.item_idx,staticClass:"content--inner"},[s("div",{staticClass:"content--img"},[s("img",{attrs:{src:i.item_image}})]),s("div",{staticClass:"content--info"},[s("div",{staticClass:"content--info--text"},[s("div",{staticClass:"content--info--title"},[s("p",[t._v(t._s(i.item_title))])]),s("div",{staticClass:"content--info--buynum"},[s("p",[t._v("구매 수량 : "+t._s(i.item_num)+"개")])])])]),s("div",{staticClass:"content--price--text"},[s("div",{staticClass:"content--price"},[s("p",[t._v(t._s(i.orders_price)+" 원")])])])])}))],2)])])])},n=[function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",{staticClass:"buy--info"},[s("p",{staticClass:"buy--title"},[t._v("구매 상품")])])}],a=s("2f62"),c={name:"BuyList",data:function(){return{list:[]}},computed:Object(a["b"])(["logintoken"]),created:function(){this.logintoken.token||this.$router.push("/shop/shoppage"),this.getList()},methods:{getList:function(){var t=this;this.$http.get("/item/private/usersOrderManage.do",{params:{email:this.logintoken.email}}).then((function(i){console.log(i.data),t.list=i.data.usersOrdersList}))}}},o=c,l=(s("9726"),s("2877")),r=Object(l["a"])(o,e,n,!1,null,"4df5de62",null);i["default"]=r.exports},6248:function(t,i,s){},9726:function(t,i,s){"use strict";s("6248")}}]);
//# sourceMappingURL=chunk-6948cc60.9c2f6310.js.map