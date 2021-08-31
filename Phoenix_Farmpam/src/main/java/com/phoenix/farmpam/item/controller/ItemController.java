package com.phoenix.farmpam.item.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping("/item/buy")
	public ModelAndView authBuy(HttpServletRequest request, 
			ModelAndView mView) {
		service.buy(request, mView);
	}
}
