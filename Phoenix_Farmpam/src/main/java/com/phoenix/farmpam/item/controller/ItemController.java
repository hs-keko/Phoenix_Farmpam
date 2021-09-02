package com.phoenix.farmpam.item.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.OrdersDto;
import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	
	// 물품 구매 테스트 페이지 요청
	@RequestMapping("/item/test_buy")
	public String testDetailForm() {
		return "item/test_buy";
	}
	
	// 구매 요청 처리
	@RequestMapping(value = "/item/buy", method = RequestMethod.POST)
	public ModelAndView authBuy(HttpServletRequest request, 
								@ModelAttribute OrdersDto ordersDto,
								ModelAndView mView) 
	{
		service.buy(request, ordersDto, mView);
		mView.setViewName("item/buy");
		return mView;
	}
}
