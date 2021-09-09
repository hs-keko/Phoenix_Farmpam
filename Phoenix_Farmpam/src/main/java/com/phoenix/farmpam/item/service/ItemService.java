package com.phoenix.farmpam.item.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

	// ######  method name 다르게 할것. 반환값과 인자값이 달라서 동작은 하지만, 가독성이 너무 떨어져요... #######

public interface ItemService {
	//장바구니 담기
	public ModelAndView insertCart(HttpServletRequest request, ModelAndView mView);
	//디테일
	public ModelAndView getDetail(HttpServletRequest request, ModelAndView mView); // 이름중복								
	//아이템 목록 얻어오기
	public void getList(HttpServletRequest request); // 이름중복
	public void insertItem(ItemDto dto); // 중복
	public void getInfo(HttpServletRequest request, HttpSession session); // 중복
	public Map<String, Object> saveImage(HttpServletRequest request,
			MultipartFile mFile); // 중복
	// public void updateItem(HttpServletRequest request); // 이름중복
	public void deleteItem(int num, HttpServletRequest request); // 중복
	//상품 주문 처리를 하는 메소드
	public ModelAndView buy(OrdersDto ordersDto, ModelAndView mView);
	
	//아이템 목록 얻어오기
	// public List<ItemDto> getList(HttpServletRequest request); // 이름중복
	public List<ItemDto> getList2(HttpServletRequest request);
	// public void insertItem(ItemDto itemDto); 중복 

	// 글 수정을 위해 글 정보 가져오기
	// public void getInfo(HttpServletRequest request, HttpSession session); 중복
	// public Map<String, Object> saveImage(HttpServletRequest request,
	// 		MultipartFile mFile); 중복

	public void updateItem(ItemDto itemDto); // 이름중복
	// public void deleteItem(int num, HttpServletRequest request); // 중복
	public void getDetail(ModelAndView mView, int item_idx); // 이름중복
	//상품목록 추가 응답
	public List<ItemDto> moreItemList(HttpServletRequest request);

	
	// vue Shopmain 아이템리스트 가져오기
	public void vueGetMainList(Map<String, Object> map, HttpServletRequest req);
	// vue 아이템 정보 가져오기
	public void vueGetInfo(Map<String, Object> map, HttpServletRequest req);
	// vue MyShop 아이템리스트 가져오기
	public void vueGetMyShop(Map<String, Object> map, HttpServletRequest req);
	
	
}
