package com.phoenix.farmpam.item.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ItemService {
	//상품 주문 처리를 하는 메소드
	public void buy(HttpServletRequest request, 
			ModelAndView mView);
}
