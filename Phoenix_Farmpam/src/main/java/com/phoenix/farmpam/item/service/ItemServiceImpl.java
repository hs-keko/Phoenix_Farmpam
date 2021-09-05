package com.phoenix.farmpam.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.farmpam.item.dao.ItemDao;
import com.phoenix.farmpam.item.dto.ItemDto;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao dao;

	@Override
	public void saveContent(ItemDto dto) {
		dao.insert(dto);
		
	}
}
