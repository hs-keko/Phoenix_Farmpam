package com.phoenix.farmpam.item.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

public interface ItemService {
	//장바구니 담기
	public ModelAndView insertCart(HttpServletRequest request, ModelAndView mView);
	//디테일
	public ModelAndView getDetail(HttpServletRequest request, ModelAndView mView);											
	//아이템 목록 얻어오기
	public void getList(HttpServletRequest request);
	public void insertItem(ItemDto dto);
	public void getInfo(HttpServletRequest request, HttpSession session);
	public Map<String, Object> saveImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateItem(HttpServletRequest request);
	public void deleteItem(int num, HttpServletRequest request);
	//상품 주문 처리를 하는 메소드
	public ModelAndView buy(OrdersDto ordersDto, ModelAndView mView);
}
