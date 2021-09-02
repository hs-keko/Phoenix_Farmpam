package com.phoenix.farmpam.item.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.users.dao.UsersDao;
import com.phoenix.farmpam.users.dto.UsersDto;

public class ItemServiceImpl implements ItemService {

	@Override
	public void getList(HttpSession session, ModelAndView mView) {
		// 로그인된 이메일을 읽어온다.
		String farmer_email=(String)session.getAttribute("email");
		// DB에서 회원 정보를 얻어와서
		ItemDto dto = dao.getData(farmer_email);
		// ModelAndView 객체에 담아준다.
		mView.addObject("dto", dto);
	}

}
