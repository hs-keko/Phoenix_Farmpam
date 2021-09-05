package com.phoenix.farmpam.item.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService service;
	
	@RequestMapping("/item/insertform")
	public ModelAndView InsertForm(HttpServletRequest request) {
		
		return new ModelAndView("item/insertform");
	}
	
	@RequestMapping("/item/insert")
	public ModelAndView Insert(ItemDto dto) {
		
		service.saveContent(dto);
		
		return new ModelAndView("item/insert");
	}
	
	@RequestMapping("/item/private/sale")
	public ModelAndView sale(HttpSession session, ModelAndView mView) {
		mView.setViewName("item/sale");
		return mView;
	}
}
