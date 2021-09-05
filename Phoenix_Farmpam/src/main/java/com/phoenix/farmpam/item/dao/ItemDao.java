package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemDao {
	//상품 목록을 리턴해주는 메소드
	public List<ItemDto> getList(ItemDto dto);
	//상품 재고를 감소 시키는 메소드
	public void minusCount(int item_stock);
	//상품의 가격을 리턴해주는 메소드
	public int getPrice(int item_price);
	//글의 갯수
	public int getCount(ItemDto dto);
	//글 추가
	public void insert(ItemDto dto);
	//글정보 얻어오기
	public ItemDto getData2(int item_idx);
	//키워드를 활용한 글정보 얻어오기
	public ItemDto getData(ItemDto dto);
	//글 삭제
	public void delete(int item_idx);
	//글 수정
	public void update(ItemDto dto);
	
}

