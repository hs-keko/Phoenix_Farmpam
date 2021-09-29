package com.phoenix.farmpam.farmer.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.farmer.dto.FollowDto;

public interface FarmerService {
	
	public Map<String, Object> isExistEmail(String inputFarmerEmail);
	public void addUser(FarmerDto dto);
	//아이디(이메일)와 비번이 일치하는 session에 setattribute해서 아이디(이메일) 정보 담아야함!
	public void loginProcess(FarmerDto dto, HttpSession session);
	public void getInfo(HttpServletRequest request, Map<String, Object> map);
	//chk박스 선택에 따라 session에 setatrribute해서 chk 정보 담기
	public void checkbox(FarmerDto dto, HttpSession session);
	public void updateFarmerPwd(FarmerDto dto, HttpServletRequest request, Map<String, Object> map);
	public Map<String, Object> saveProfileImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateUser(FarmerDto dto, HttpServletRequest request, Map<String, Object> map);
	public void deleteUser(HttpServletRequest request, Map<String, Object> map);
	// 팔로우 추가
	public FarmerDto followInsert(FollowDto followDto);
	// 팔로우 해제
	public FarmerDto followDelete(FollowDto followDto);
	
	// vue 처리
	public boolean vuelogin(FarmerDto dto, HttpSession session);
	
}