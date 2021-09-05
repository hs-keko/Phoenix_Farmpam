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
	public List<ItemDto> getList(ItemDto dto) {
		return session.selectList("item.getList", dto);
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
	public int getCount(ItemDto dto) {
		return session.selectOne("item.getCount", dto);
	}

	@Override
	public void insert(ItemDto dto) {
		session.insert("item.insert", dto);
		
	}

	@Override
	public ItemDto getData(int item_idx) {
		return session.selectOne("item.getData", item_idx);
	}

	@Override
	public ItemDto getData2(ItemDto dto) {
		return session.selectOne("item.getData2", dto);
	}

	@Override
	public void delete(int item_idx) {
		session.delete("item.delete", item_idx);
		
	}

	@Override
	public void update(ItemDto dto) {
		session.update("item.update", dto);
		
	}
	
}

