package com.phoenix.farmpam.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.phoenix.farmpam.item.dto.ItemDto;

public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<ItemDto> getList(ItemDto dto) {
		return session.selectList("item.getList", dto);
	}

	@Override
	public int getCount(ItemDto dto) {
		return session.selectOne("item.getCount", dto);
	}

	@Override
	public void insert(ItemDto dto) {
		session.insert("item.insert", dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("item.delete", num);
		
	}

	@Override
	public void update(ItemDto dto) {
		session.update("item.update", dto);
		
	}


}
