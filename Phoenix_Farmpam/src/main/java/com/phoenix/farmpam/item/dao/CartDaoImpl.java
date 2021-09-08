package com.phoenix.farmpam.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.item.dto.CartDto;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SqlSession session;

	// 장바구니에 상품 추가
	@Override
	public void insertCart(CartDto cartDto) {
		session.insert("cart.insertCart", cartDto);
	}

	// 장바구니 상품 불러오기
	@Override
	public List<CartDto> getCartList(String users_email) {
		return session.selectList("cart.getCartList", users_email);
	}
	
	// 장바구니 주인 이메일주소 가져오기
	@Override
	public String getCartEmail(int cart_idx) {
		return session.selectOne("cart.getCartEmail", cart_idx);
	}
	
	// 장바구니에서 상품 삭제
	@Override
	public void deleteCart(int cart_idx) {
		session.delete("cart.deleteCart", cart_idx);
	}

}
