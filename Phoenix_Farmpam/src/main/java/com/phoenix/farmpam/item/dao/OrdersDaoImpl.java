package com.phoenix.farmpam.item.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.item.dto.OrdersDto;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SqlSession session;
	
	//주문 정보를 추가하는 메소드
	@Override
	public void addOrders(OrdersDto ordersDto) {
		session.insert("item.addOrders", ordersDto);
	}

}
