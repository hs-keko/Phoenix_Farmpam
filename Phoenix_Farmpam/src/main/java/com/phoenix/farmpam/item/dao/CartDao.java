package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.CartDto;

public interface CartDao {
	// 장바구니 상품 불러오기
	public List<CartDto> getCartList(String users_email);
	// 장바구니에 상품 추가
	public void insertCart(CartDto cartDto);
}
