package com.phoenix.farmpam.item.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemService {
	//아이템 목록 얻어오기
	public void getList(HttpServletRequest request);
	public void insertItem(ItemDto dto);
	public void getInfo(HttpServletRequest request, HttpSession session);
	public Map<String, Object> saveImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateItem(ItemDto dto);
	public void deleteItem(int num, HttpServletRequest request);
}
