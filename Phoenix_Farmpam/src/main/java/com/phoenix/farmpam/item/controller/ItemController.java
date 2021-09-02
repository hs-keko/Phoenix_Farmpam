package com.phoenix.farmpam.item.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService service;
	
	@RequestMapping("/item/private/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		return "/item/list";
	}
}
