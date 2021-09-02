package com.phoenix.farmpam.item.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.OrdersDto;

public interface ItemService {
	//상품 주문 처리를 하는 메소드
	public ModelAndView buy(OrdersDto ordersDto, ModelAndView mView);
}
