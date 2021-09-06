package com.phoenix.farmpam.item.dao;

import com.phoenix.farmpam.item.dto.CartDto;

public interface CartDao {
	// 장바구니에 상품 추가
	public void insertCart(CartDto cartDto);
}
