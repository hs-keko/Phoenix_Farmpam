package com.phoenix.farmpam.item.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemService {
	//아이템 목록 얻어오기
	public void getList(HttpServletRequest request);
	public void updateItem(ItemDto dto);
	public void deleteItem(int num, HttpServletRequest request);
}
