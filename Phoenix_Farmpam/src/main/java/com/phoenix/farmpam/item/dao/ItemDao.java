package com.phoenix.farmpam.item.dao;

import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemDao {
	// 상품의 가격을 리턴해주는 메소드
	public int getPrice(int item_idx);
	// 계좌 잔고 줄이기
	public void minusMoney(ItemDto itemDto);
	// 상품 재고 감소시키기
	public void minusStock(ItemDto itemDto);
}
