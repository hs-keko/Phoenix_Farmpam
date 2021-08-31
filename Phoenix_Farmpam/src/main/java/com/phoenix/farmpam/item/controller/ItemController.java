package com.phoenix.farmpam.item.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	// 구매 요청 처리
	@RequestMapping("/item/buy")
	public ModelAndView authBuy(HttpServletRequest request, 
			ModelAndView mView) {
		service.buy(request, mView);
		mView.setViewName("item/buy");
		return mView;
	}
}
