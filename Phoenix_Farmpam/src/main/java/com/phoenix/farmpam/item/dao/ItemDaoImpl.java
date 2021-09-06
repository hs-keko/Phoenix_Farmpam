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
	public void update(ItemDto itemDto) {
		session.update("item.update", itemDto);
		
	}

	@Override
	public ItemDto getData(String farmer_email) {
		return session.selectOne("item.getData", farmer_email);
	}

	@Override
	public ItemDto getData2(int num) {
		return session.selectOne("item.getData2", num);
	}

	//상품 번호에 해당하는 상품의 가격을 리턴하는 메소드
	@Override
	public int getPrice(int item_idx) {
		return session.selectOne("item.getPrice", item_idx);
	}

	// 계좌 잔고 줄이기
	@Override
	public void minusMoney(ItemDto itemDto) {
		session.update("item.minusMoney", itemDto);
		
	}

	// 상품 재고 감소시키기
	@Override
	public void minusStock(ItemDto itemDto) {
		session.update("item.minusStock", itemDto);
	}
}
