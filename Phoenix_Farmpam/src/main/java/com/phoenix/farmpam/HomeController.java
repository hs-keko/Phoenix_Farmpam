package com.phoenix.farmpam;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	/*
	 *  "/home.do" 요청이 왔을때 이 메소드로 요청으로 처리하기 
	 *  
	 *  .do 는 생략 가능 
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		String notice="우리조 화이팅! ٩(๑•̀o•́๑)و";
		//공지 사항을 request 에 담기
		request.setAttribute("notice", notice);
		//view 페이지 (jsp페이지) 로 forward 이동해서 응답 
		return "home";
	}
	
	
	
}
