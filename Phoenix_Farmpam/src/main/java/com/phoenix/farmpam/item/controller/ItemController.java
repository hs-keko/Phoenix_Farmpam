package com.phoenix.farmpam.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;
import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {

   @Autowired
   private ItemService service;
   
   //판매자 주문 현황 목록
   @RequestMapping("/item/private/sellorOrderManage")
   @ResponseBody
   public Map<String, Object> sellorOrdersManage(HttpServletRequest request){
	   Map<String, Object> map = new HashMap<String, Object>();
	   service.getSellorOrders(request, map);
	   return map;
   } 

   // vue MyShop 목록
   @RequestMapping("/vue/myshop/list")
   @ResponseBody
   public Map<String, Object> getAjaxMyShop(HttpServletRequest req){
	   System.out.println("excute getAjaxMyShop");
	   Map<String, Object> map = new HashMap<String, Object>();
	   service.vueGetMyShop(map, req);
	   return map;
   }
   
   // vue 아이템 상세
   @RequestMapping("/vue/item/detail")
   @ResponseBody
   public Map<String, Object> getAjaxDetail(HttpServletRequest req){
	   System.out.println("excute getAjaxDetail");
	   Map<String, Object> map = new HashMap<String, Object>();
	   service.vueGetInfo(map, req);
	   return map;
   }

   	// vue 목록 
	@RequestMapping("/vue/item/list")
	@ResponseBody
	public Map<String,Object> getAjaxList(HttpServletRequest req) {
		System.out.println("excute getAjaxList");
		Map<String, Object> map = new HashMap<String, Object>();
		service.vueGetMainList(map, req);
		return map;
	}
   
   	//장바구니 구매수량 변경
 	@RequestMapping(value = "/item/private/cartupdate", method = RequestMethod.POST)
 	@ResponseBody
 	public Map<String, Object> updateCart(HttpServletRequest request){
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.updateCart(request, map);
 		return map;
 	}
 	
 	//장바구니에서 상품 삭제
 	@RequestMapping(value = "/item/private/cartdelete", method = RequestMethod.POST)
 	@ResponseBody
 	public Map<String, Object> deleteCart(HttpServletRequest request){
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.deleteCart(request, map);
 		return map;
 	}
 	
 	//장바구니 목록
 	@RequestMapping("/item/private/cart")
 	@ResponseBody
 	public Map<String, Object> cartList(HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.getCartList(request, map);
 		return map;
 	}
 	
 	//장바구니 담기
 	@RequestMapping("/item/private/addcart")
 	@ResponseBody
 	public Map<String, Object> addCart(HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.insertCart(request, map);
 		return map;
 	}
 	
 	//목록
 	@RequestMapping("/item/private/list_admin")
 	@ResponseBody
 	public Map<String, Object> getList(HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.getList(request, map);
 		return map;
 	}
 	
 	//새글 저장 요청 처리 
 	@RequestMapping("/item/private/insert")
 	@ResponseBody
 	public Map<String, Object> insertItem(ItemDto dto, HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		System.out.println("아이템 저장 컨트롤러");
 		service.insertItem(dto, map, request);
 		return map;
 	}
 	
 	//ajax 사진 업로드 요청처리
 	@RequestMapping(value = "/item/private/ajax_image_upload",
 			method=RequestMethod.POST)
 	@ResponseBody
 	public Map<String, Object> ajaxImageUpload(HttpServletRequest request,
 					@RequestParam MultipartFile image){
 		return service.saveImage(request, image);
 	}
 	
 	//수정폼
 	@RequestMapping("/item/private/updateform")
 	@ResponseBody
 	public Map<String, Object> updateForm(HttpServletRequest request, HttpSession session) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.getInfo(request, session, map);
 		return map;
 	}

 	//수정반영 요청처리
 	@RequestMapping(value = "/item/private/update", method = RequestMethod.POST)
 	@ResponseBody
 	public Map<String, Object> UpdateItem(HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.updateItem(request, map);
 		return map;
 	}
 	
 	//삭제하기
 	@RequestMapping("/item/private/delete")
 	@ResponseBody
 	public Map<String, Object> delete(HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.deleteItem(request, map);
 		return map;
 	}
 	
 	// 구매 요청 처리
 	@RequestMapping(value = "/item/private/buy", method = RequestMethod.POST)
 	@ResponseBody
 	public Map<String, Object> authBuy(HttpServletRequest request) {
 		Map<String, Object> map=new HashMap<String, Object>();
 		service.buy(request, map);
 		return map;
 	}

    
    //ajax 요청에 대해 item 목록을 출력할 컨트롤러 메소드 
  	@RequestMapping("/api/item/list")
  	@ResponseBody 
  	public List<ItemDto> getList2(HttpServletRequest request){
  		
  		return service.getList2(request);
  	}
  	
  	//item 게시글의 item_idx 이 parameter get 방식으로 넘어온다.
 	//detail 페이지
 	@RequestMapping(value = "/item/detail", method = RequestMethod.GET)
 	public ModelAndView getDetail(ModelAndView mView, @RequestParam int item_idx) {
 		//item detail 페이지에 필요한 data를 item_idx 으로 가져와, ModelAndView 에 저장
 		service.getDetail(mView, item_idx);
 		mView.setViewName("item/detail");
 		
 		return mView;
 	}
 	
 	// vue Category_low 가져오기
 	@RequestMapping("/vue/categorylow")
 	@ResponseBody
 	public Map<String, Object> getCategory(HttpServletRequest req){
 		Map<String, Object> map = new HashMap<String, Object>();
 		service.vueGetCategory(map, req);
 		return map;
 	}
 }