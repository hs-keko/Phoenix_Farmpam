package com.phoenix.farmpam;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	@RequestMapping("/index")
	public String test() {
		return "index.html";
	}
}
