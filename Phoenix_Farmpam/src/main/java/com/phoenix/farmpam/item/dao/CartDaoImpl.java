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

	@Override
	public List<CartDto> getCartList(String users_email) {
		return session.selectList("cart.getCartList", users_email);
	}

}
