package com.phoenix.farmpam.item.service;

import com.phoenix.farmpam.item.dto.ItemDto;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface ItemService {
	public void getSaleInfo(HttpSession session, ModelAndView mView);
	public void saveContent(ItemDto dto);
}
