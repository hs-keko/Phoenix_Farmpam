package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.users.dto.UsersDto;

public interface ItemDao {
	//상품 목록
	public List<ItemDto> getList(ItemDto dto);
	//인자로 전달하는 이메일에 해당하는 정보를 리턴하는 메소드
	public ItemDto getData(String farmer_email);
	//인자로 전달하는 번호에 해당하는 정보를 리턴하는 메소드
	public ItemDto getData2(int num);
	//글의 갯수
	public int getCount(ItemDto dto);
	//글 추가
	public void insert(ItemDto dto);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(ItemDto dto);
}
