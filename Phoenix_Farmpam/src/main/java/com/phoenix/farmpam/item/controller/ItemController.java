package com.phoenix.farmpam.item.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService service;
	
	@RequestMapping("/itme/private/sale")
	public ModelAndView sale(HttpSession session, ModelAndView mView) {
		mView.setViewName("item/sale");
		return mView;
	}
}
