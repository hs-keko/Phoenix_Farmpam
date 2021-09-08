package com.phoenix.farmpam.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.item.dto.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ItemDto> getList(ItemDto itemDto) {
		return session.selectList("item.getList", itemDto);
	}

	@Override
	public void minusCount(int item_stock) {
		session.update("item.minusCount", item_stock);
		
	}

	@Override
	public int getPrice(int item_price) {
		return session.selectOne("item.getPrice", item_price);
	}

	@Override
	public int getCount(ItemDto itemDto) {
		return session.selectOne("item.getCount", itemDto);
	}

	@Override
	public void insert(ItemDto itemDto) {
		session.insert("item.insert", itemDto);
		
	}

	@Override
	public ItemDto getData(ItemDto itemDto) {
		return session.selectOne("item.getData", itemDto);
	}

	@Override
	public ItemDto getData2(int item_idx) {
		return session.selectOne("item.getData2", item_idx);
	}

	@Override
	public void delete(int item_idx) {
		session.delete("item.delete", item_idx);
		
	}

	@Override
	public void update(ItemDto itemDto) {
		session.update("item.update", itemDto);
		
	}
	
}

