package com.phoenix.farmpam.item.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

public interface ItemService {
	//해당 판매자에게 들어온 주문 얻어오기
	public void getSellorOrders(HttpServletRequest request, Map<String, Object> map);
	
	//장바구니 구매수량 변경
	public void updateCart(HttpServletRequest request, Map<String, Object> map);
	
	//장바구니에서 상품 삭제
	public void deleteCart(HttpServletRequest request, Map<String, Object> map);
	
	//장바구니 목록 불러오기
	public void getCartList(HttpServletRequest request, Map<String, Object> map);
	
	//장바구니 담기
	public void insertCart(HttpServletRequest request, Map<String, Object> map);		
	
	//아이템 목록 얻어오기
	public void getList(HttpServletRequest request, Map<String, Object> map);
	
	public void insertItem(ItemDto dto, Map<String, Object> map, HttpServletRequest request);
	
	public void getInfo(HttpServletRequest request, HttpSession session, Map<String, Object> map);
	
	public Map<String, Object> saveImage(HttpServletRequest request,
			MultipartFile mFile);
	
	public void updateItem(HttpServletRequest request, Map<String, Object> map);
	

	public void deleteItem(HttpServletRequest request, Map<String, Object> map);

	//상품 주문 페이지 요청
	public void buyForm(HttpServletRequest request, HttpSession session, Map<String, Object> map);

	//상품 주문 처리를 하는 메소드
	public void buy(HttpServletRequest request, Map<String, Object> map);
	
	// vue Shopmain 아이템리스트 가져오기
	public void vueGetMainList(Map<String, Object> map, HttpServletRequest req);

	// vue 아이템 정보 가져오기
	public void vueGetInfo(Map<String, Object> map, HttpServletRequest req);

	// vue MyShop 아이템리스트 가져오기
	public void vueGetMyShop(Map<String, Object> map, HttpServletRequest req);
	
	// 카테고리 최신 신선 상품 4개 가져오기 
	public void newList(Map<String, Object> map, HttpServletRequest request);
	
	// 카테고리 마감 임박 상품 4개 가져오기
	public void getCloseList(Map<String, Object> map, HttpServletRequest request);
	
	// 카테고리 건강을 위한 채식 상품 4개 가져오기
	public void getVeganList(Map<String, Object> map, HttpServletRequest request);

	// vue 아이템 카테고리 가져오기
	public void vueGetCategory(Map<String, Object> map, HttpServletRequest req);

}