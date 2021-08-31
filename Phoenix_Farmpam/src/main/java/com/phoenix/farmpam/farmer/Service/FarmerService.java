package com.phoenix.farmpam.farmer.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.users.dto.UsersDto;

public interface FarmerService {
	
	public Map<String, Object> isExistEmail(String inputFarmerEmail);
	public void addUser(FarmerDto dto);
	//아이디(이메일)와 비번이 일치하는 session에 setattribute해서 아이디(이메일) 정보 담아야함!
	public void loginProcess(FarmerDto dto, HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mView);
	//chk박스 선택에 따라 session에 setatrribute해서 chk 정보 담기
	public void checkbox(FarmerDto dto, HttpSession session);
	public void updateFarmerPwd(HttpSession session, FarmerDto dto, ModelAndView mView);
	public Map<String, Object> saveProfileImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateUser(FarmerDto dto, HttpSession session);
}
