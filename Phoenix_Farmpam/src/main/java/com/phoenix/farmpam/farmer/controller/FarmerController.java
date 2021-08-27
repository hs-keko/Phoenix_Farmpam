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
import com.phoenix.farmpam.farmer.dto.FollowDto;
import com.phoenix.farmpam.users.dto.UsersDto;
import com.phoenix.farmpam.users.service.UsersService;

@Controller
public class FarmerController {
	
	@Autowired
	private FarmerService service;

	// 농장주 팔로우하기 테스트 페이지 요청
	@RequestMapping(value = "/farmer/test_follow")
	public String testFollow() {
		
		return "farmer/test_follow";
	}
	
	
	// 농장주 된 상태에서 클릭시 팔로우 해제
	@ResponseBody
	@RequestMapping(value = "/farmer/removeFollow")
	public FarmerDto removeFollow(@RequestParam String farmer_email, HttpSession session) {
			
		FollowDto followDto = new FollowDto();
		// 팔로우할 농장주의 이메일 셋팅
		followDto.setFarmer_email(farmer_email);
		// 팔로우 누른 유저의 이메일을 세션에서 얻어내기
		String users_email=(String)session.getAttribute("email");
		// FollowDto 객체에 유저 이메일 담기
		followDto.setUsers_email(users_email);
		// +1된 팔로우 수를 담아오기 위함
		return service.followDelete(followDto);
	}
	
	// 농장주 팔로우 안된 상태에서 클릭시 팔로우 추가
	@ResponseBody
	@RequestMapping(value = "/farmer/saveFollow")
	public FarmerDto saveFollow(@RequestParam String farmer_email, HttpSession session) {
		
		FollowDto followDto = new FollowDto();
		// 팔로우할 농장주의 이메일 셋팅
		followDto.setFarmer_email(farmer_email);
		// 팔로우 누른 유저의 이메일을 세션에서 얻어내기
		String users_email=(String)session.getAttribute("email");
		// FollowDto 객체에 유저 이메일 담기
		followDto.setUsers_email(users_email);
		// +1된 팔로우 수를 담아오기 위함
		return service.followInsert(followDto);
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
