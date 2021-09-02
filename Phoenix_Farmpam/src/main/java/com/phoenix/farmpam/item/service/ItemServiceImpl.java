package com.phoenix.farmpam.item.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dao.ItemDao;
import com.phoenix.farmpam.item.dao.OrdersDao;
import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void buy(HttpServletRequest request,
					OrdersDto ordersDto,
					ModelAndView mView) 
	{
		
		//구입자의 이메일
		String users_email=(String)request.getSession().getAttribute("email");
		//1. 파라미터로 전달되는 구입할 상품 번호
		int item_idx=ordersDto.getItem_idx();
		//2. 파라미터로 전달되는 구입할 상품의 수량
		int orders_item_total=ordersDto.getOrders_item_total();
		//3. 파라미터로 전달되는 배송지 주소
		String orders_addr=ordersDto.getOrders_addr();
		//4. 상품의 개당 가격을 얻어온다.
		int item_price=itemDao.getPrice(item_idx);
		//5. (구입 수량*상품의 가격) 만큼 계좌 잔액을 줄인다.
		ItemDto itemDto=new ItemDto();
		itemDto.setUsers_email(users_email);
		int orders_price = item_price * orders_item_total;
		itemDto.setItem_price(orders_price);
		itemDao.minusMoney(itemDto);
		//6. 재고의 갯수를 구입한 수량만큼 줄인다.
		itemDto.setOrders_item_total(orders_item_total);
		itemDao.minusStock(itemDto);
		//7. 주문 테이블에 정보를 추가 한다.
		ordersDto.setItem_price(item_price);
		ordersDto.setOrders_price(orders_price);
		ordersDto.setUsers_email(users_email);
		ordersDao.addOrders(ordersDto);
	}
}
