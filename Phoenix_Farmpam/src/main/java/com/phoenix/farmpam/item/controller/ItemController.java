package com.phoenix.farmpam.item.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	//상품 전체 목록
	@RequestMapping("/item/admin/private/list")
	public ModelAndView list(HttpSession session, ModelAndView mView) {
		
		mView.setViewName("item/admin/list");
		return mView;
	}	
}
