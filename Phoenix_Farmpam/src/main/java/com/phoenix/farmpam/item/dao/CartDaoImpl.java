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
	public boolean insertCart(CartDto cartDto) {
		session.insert("cart.insertCart", cartDto);
		return true;
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
	public boolean deleteCart(int cart_idx) {
		session.delete("cart.deleteCart", cart_idx);
		return true;
	}
	
	// 장바구니에 해당 아이템이 이미있는지 장바구니idx를 가져온다.
	@Override
	public int checkCart(CartDto cartDto) {
		if(session.selectOne("cart.checkCart", cartDto) != null) {
			int result = session.selectOne("cart.checkCart", cartDto);
			System.out.println(result);
			return result;
		}else {
			return 0;
		}
	}
	
	// 장바구니에 이미있는 상품의 갯수를 가져온다.
	@Override
	public int getAmount(int cart_idx) {
		return session.selectOne("cart.getAmount", cart_idx);
	}

	@Override
	public boolean updateCart(CartDto cartDto) {
		session.update("cart.updateCart", cartDto);
		return true;
	}

	@Override
	public int getCartData(int cart_idx) {
		return session.selectOne("cart.getCartData", cart_idx);
	}

}
