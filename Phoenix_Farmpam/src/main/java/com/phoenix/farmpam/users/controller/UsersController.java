package com.phoenix.farmpam.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.users.dto.UsersDto;
import com.phoenix.farmpam.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	//로그인 폼 요청처리
	@RequestMapping("/users/loginform")
	public String loginform() {
		return "users/loginform";
	}
	
	//로그인 요청처리
	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto,
			@RequestParam String url, HttpSession session) {
		mView.setViewName("users/login");
		return mView;
	}
	
	//회원가입 요청처리
	@RequestMapping(value="/users/signup", method = RequestMethod.POST)
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		service.addUser(dto);
		mView.setViewName("users/signup");
		return mView;	
	}
	
	// VUE axios test
	@RequestMapping(value="/users/vue/signup", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Apisignup(ModelAndView mView, UsersDto dto) {
		System.out.println(dto);
		service.addUser(dto);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("isSuccess",true);
		return map;
	}
	
	//before창 가입하기 전 분류하기
	@RequestMapping(value = "/users/signup_before", method = RequestMethod.GET)
	public String signupBefore() {
		return "users/signup_before";
	}
	
	//이메일 중복확인을 해서 json 문자열로 리턴해주는 메소드
	@RequestMapping("/users/checkusersemail")
	@ResponseBody
	public Map<String, Object> checkusersemail(@RequestParam String inputUsersEmail){
		//usersService가 리턴해주는 map을 리턴해서 json 문자열을 응답함
		return service.isExistEmail(inputUsersEmail);
	}
	
	//회원가입폼 요청처리
	@RequestMapping(value = "/users/signup_form", method = RequestMethod.GET)
	public String signupForm() {
		return "users/signup_form";
	}


	
}
