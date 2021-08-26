package com.phoenix.farmpam.farmer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.farmer.Service.FarmerService;
import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.users.service.UsersService;

@Controller
public class FarmerController {
	
	@Autowired
	private FarmerService service;
	
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
