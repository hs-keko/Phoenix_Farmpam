package com.phoenix.farmpam.users.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.users.dto.UsersDto;

public interface UsersService {
	
	public Map<String, Object> isExistEmail(String inputUsersEmail);
	public void addUser(UsersDto dto);
	//아이디(이메일)와 비번이 일치하는 session에 setattribute해서 아이디(이메일) 정보 담아야함!
	public void loginProcess(UsersDto dto, HttpSession session);
}
