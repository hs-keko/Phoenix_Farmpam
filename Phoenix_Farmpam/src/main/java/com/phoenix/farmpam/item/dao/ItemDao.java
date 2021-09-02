package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemDao {
	//상품 목록
	public List<ItemDto> getList(ItemDto dto);
	//글의 갯수
	public int getCount(ItemDto dto);
	//글 추가
	public void insert(ItemDto dto);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(ItemDto dto);
}
