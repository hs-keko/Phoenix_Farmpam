package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.OrdersDto;

public interface OrdersDao {
	// 유저의 주문 리스트 얻어오기
	public List<OrdersDto> getUsersOrdersList(String users_email);
	// 해당 판매자에게 들어온 주문 리스트 얻어오기
	public List<OrdersDto> getSellorOrdersList(String farmer_email);
	// 주문 정보를 추가하는 메소드
	public boolean addOrders(OrdersDto ordersDto);
}
