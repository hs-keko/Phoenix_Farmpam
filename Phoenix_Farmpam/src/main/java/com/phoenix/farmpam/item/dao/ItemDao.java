<<<<<<< HEAD
package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemDao {
	//상품 목록
	public List<ItemDto> getList(ItemDto dto);
	//인자로 전달하는 이메일에 해당하는 정보를 리턴하는 메소드
	public ItemDto getData(String farmer_email); // 이름 중복
	//인자로 전달하는 번호에 해당하는 정보를 리턴하는 메소드
	public ItemDto getData2(int item_idx);
	//글의 갯수
	public int getCount(ItemDto dto);
	//글 추가
	public void insert(ItemDto dto);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(ItemDto itemDto);
	// 상품의 가격을 리턴해주는 메소드
	public int getPrice(int item_idx);
	// 계좌 잔고 줄이기
	public void minusMoney(ItemDto itemDto);
	// 상품 재고 감소시키기
	public void minusStock(ItemDto itemDto);


	//상품 재고를 감소 시키는 메소드
	public void minusCount(int item_stock);


	//키워드를 활용한 글정보 얻어오기
	public ItemDto getData(ItemDto itemDto); // 이름 중복


}

