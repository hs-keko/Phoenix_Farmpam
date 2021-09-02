package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemDto;

public class ItemDaoImpl implements ItemDao {

	@Override
	public ItemDto getData(String farmer_email) {
		return session.selectOne("item.getData", farmer_email);
	}



}
