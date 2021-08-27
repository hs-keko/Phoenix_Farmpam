package com.phoenix.farmpam.users.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
	
	//ID라는 키값으로 저장된 값 삭제 (로그아웃 기능)
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		//세션에서 users_email이라는 키값으로 저장된 값 삭제
		session.removeAttribute("email");
		return "users/logout";
	}
	
	//로그인 폼 요청 처리
	@RequestMapping("/users/loginform")
	public String loginform() {
		
		return "users/loginform";
	}
	
	//로그인 요청 처리
	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto,
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
