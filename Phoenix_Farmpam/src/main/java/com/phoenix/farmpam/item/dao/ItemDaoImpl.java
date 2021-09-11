package com.phoenix.farmpam.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.item.dto.ItemCategoryTopDto;
import com.phoenix.farmpam.item.dto.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ItemDto> getListItem(ItemDto dto) {
		return session.selectList("item.getListItem", dto);
	}

	@Override
	public int getCount(ItemDto dto) {
		return session.selectOne("item.getCount", dto);
	}

	@Override
	public void insertItem(ItemDto dto) {
		session.insert("item.insertItem", dto);
		
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
	public ItemDto getData3(int num) {
		return session.selectOne("item.getData3", num);
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
	
	public List<ItemDto> getList(ItemDto itemDto) {
		return session.selectList("item.getList", itemDto);
	}

	@Override
	public void minusCount(int item_stock) {
		session.update("item.minusCount", item_stock);
		
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

	
	// vue 
	@Override
	public List<ItemCategoryTopDto> getCategory(int item_category_top_ref) {
		return session.selectList("item.getShopCategory", item_category_top_ref);
	}

	@Override
	public List<ItemDto> getMyList(ItemDto dto) {
		return session.selectList("item.getMyShopList",dto);
	}

	@Override
	public int getMyCount(ItemDto dto) {
		return session.selectOne("item.getMyShopCount",dto);
	}

	@Override
	public ItemDto getMyDetail(int item_idx) {
		return session.selectOne("item.getMyDetail",item_idx);
	}
	
	@Override
	public int getShopCategoryCount(ItemDto dto) {
		return session.selectOne("item.getShopCategoryCount",dto);
	}
	
	@Override
	public List<ItemDto> getShopCategoryList(ItemDto dto) {
		return session.selectList("item.getShopCategoryList",dto);
	}

	@Override
	public List<ItemDto> getCloseList(int item_stock) {
		return session.selectList("item.getCloseList", item_stock);
	}

	@Override
	public List<ItemDto> getVeganList(int item_category_top_idx) {
		return session.selectList("item.getHealthyList", item_category_top_idx);
	}

	@Override
	public List<ItemDto> getNewList(int item_idx) {
		return session.selectList("item.getNewList", item_idx);
	}
	
	
	
	
	
}