package com.phoenix.farmpam.farmer.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.farmer.Service.FarmerService;
import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.users.dto.UsersDto;
import com.phoenix.farmpam.users.service.UsersService;

@Controller
public class FarmerController {
	
	@Autowired
	private FarmerService service;
	
	//로그아웃 요청 처리
	@RequestMapping("/farmer/logout")
	public String logout(HttpSession session) {
		//세션에서 users_email 키값으로 저장된 값을 삭제
		session.removeAttribute("farmer_email");
		return "farmer/logout";
	}
	
	//로그인 폼 요청 처리
	@RequestMapping("/farmer/loginform_farmer")
	public String loginform() {
		
		return "farmer/loginform_farmer";
	}
	
	//로그인 요청 처리
	@RequestMapping("/farmer/login_farmer")
	public ModelAndView login(ModelAndView mView, FarmerDto dto,
			@RequestParam String url, HttpSession session) {
		/*
		 *  서비스에서 비즈니스 로직을 처리할때 필요로  하는 객체를 컨트롤러에서 직접 전달을 해 주어야 한다.
		 *  주로, HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView
		 *  등등의 객체 이다. 
		 */
		service.loginProcess(dto, session);
		
		String encodedUrl=URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		
		mView.setViewName("farmer/login_farmer");
		return mView;
	}
	
	//회원가입 요청처리
	@RequestMapping(value="/farmer/signup_farmer", method=RequestMethod.POST)
	public ModelAndView signup(ModelAndView mView, FarmerDto dto) {
		service.addUser(dto);
		mView.setViewName("farmer/signup_farmer");
		return mView;
	}
	
	//이메일 중복확인 하고 json 문자열 리턴
	@RequestMapping("/farmer/checkfarmeremail")
	@ResponseBody
	public Map<String, Object> checkfarmeremail(@RequestParam String inputFarmerEmail){
		return service.isExistEmail(inputFarmerEmail);
	}

	//회원가입폼 요청처리
	@RequestMapping(value = "/farmer/signup_form_farmer", method = RequestMethod.GET)
	public String signupForm() {
		return "farmer/signup_form_farmer";
	}
}
