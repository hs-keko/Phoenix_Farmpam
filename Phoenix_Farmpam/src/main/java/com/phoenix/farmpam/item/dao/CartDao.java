package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.CartDto;

public interface CartDao {
	// 장바구니 상품 개당가격 불러오기
	public int getCartData(int cart_idx);
	// 장바구니 구매수량 변경
	public boolean updateCart(CartDto cartDto);
	// 장바구니에서 상품 삭제
	public boolean deleteCart(int cart_idx);
	// 장바구니 주인 이메일 가져오기
	public String getCartEmail(int cart_idx);
	// 장바구니 상품 불러오기
	public List<CartDto> getCartList(String users_email);
	// 장바구니에 상품 추가
	public boolean insertCart(CartDto cartDto);
	// 장바구니에 이미있는 상품 검사
	public int checkCart(CartDto cartDto);
	// 장바구니의 상품갯수 가져오기
	public int getAmount(int cart_idx);
}
