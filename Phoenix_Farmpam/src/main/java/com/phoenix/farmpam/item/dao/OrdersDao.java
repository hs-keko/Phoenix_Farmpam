package com.phoenix.farmpam.item.dao;

import com.phoenix.farmpam.item.dto.OrdersDto;

public interface OrdersDao {
	// 주문 정보를 추가하는 메소드
	public void addOrders(OrdersDto ordersDto);
}
