package com.phoenix.farmpam.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.item.dto.CartDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SqlSession session;
	
	//주문 정보를 추가하는 메소드
	@Override
	public boolean addOrders(OrdersDto ordersDto) {
		session.insert("item.addOrders", ordersDto);
		return true;
	}
	
	// 해당 판매자에게 들어온 주문 리스트 얻어오기
	@Override
	public List<OrdersDto> getSellorOrdersList(String farmer_email) {
		return session.selectList("item.getSellorOrdersList", farmer_email);
	}

}
