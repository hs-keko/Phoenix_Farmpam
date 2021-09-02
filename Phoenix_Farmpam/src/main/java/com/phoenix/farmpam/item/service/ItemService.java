package com.phoenix.farmpam.item.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface ItemService {

	public void getList(HttpSession session, ModelAndView mView);
}
