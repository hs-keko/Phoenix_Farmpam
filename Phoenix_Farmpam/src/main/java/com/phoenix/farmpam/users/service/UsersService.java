package com.phoenix.farmpam.users.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.users.dto.UsersDto;

public interface UsersService {
	
	public Map<String, Object> isExistEmail(String inputUsersEmail);
	public void addUser(UsersDto dto);
	//아이디(이메일)와 비번이 일치하는 session에 setattribute해서 아이디(이메일) 정보 담아야함!
	public void loginProcess(UsersDto dto, HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mView);
	//chk박스 선택에 따라 session에 setatrribute해서 chk 정보 담기
	public void checkbox(UsersDto dto, HttpSession session);
	public void updateUsersPwd(HttpSession session, UsersDto dto, ModelAndView mView);
	public Map<String, Object> saveProfileImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateUser(UsersDto dto, HttpSession session);
	public void deleteUser(HttpSession session, ModelAndView mView);
	
	// vue test
	public boolean loginpro(UsersDto dto, HttpSession session);
	
}
