package com.phoenix.farmpam.item.service;

import com.phoenix.farmpam.item.dto.ItemDto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface ItemService {
	//아이템 목록 얻어오기
	public List<ItemDto> getList(HttpServletRequest request);
	public List<ItemDto> getList2(HttpServletRequest request);
	public void insertItem(ItemDto itemDto);
	// 글 수정을 위해 글 정보 가져오기
	public void getInfo(HttpServletRequest request, HttpSession session);
	public Map<String, Object> saveImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateItem(ItemDto itemDto);
	public void deleteItem(int num, HttpServletRequest request);
	public void getDetail(ModelAndView mView, int item_idx);
	//상품목록 추가 응답
	public List<ItemDto> moreItemList(HttpServletRequest request);
	
}
