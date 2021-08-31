package com.phoenix.farmpam.item.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		
		//구입자의 이메일
		String users_email=(String)request.getSession().getAttribute("email");
		//1. 파라미터로 전달되는 구입할 상품 번호
		int item_idx=Integer.parseInt(request.getParameter("item_idx"));
		//2. 파라미터로 전달되는 구입할 상품의 수량
		int orders_item_total;
		//3. 상품의 개당 가격을 얻어온다.
		int item_price=itemDao.getPrice(item_idx);
		//4. (구입 수량*상품의 가격) 만큼 계좌 잔액을 줄인다.
		
	}

	
}
