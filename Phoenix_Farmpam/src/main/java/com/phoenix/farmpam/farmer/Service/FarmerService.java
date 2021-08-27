package com.phoenix.farmpam.farmer.Service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.phoenix.farmpam.farmer.dto.FarmerDto;

public interface FarmerService {
	
	public Map<String, Object> isExistEmail(String inputFarmerEmail);
	public void addUser(FarmerDto dto);
	//아이디(이메일)와 비번이 일치하는 session에 setattribute해서 아이디(이메일) 정보 담아야함!
	public void loginProcess(FarmerDto dto, HttpSession session);
}
