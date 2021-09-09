package com.phoenix.farmpam.users.controller;

import java.util.HashMap;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.users.dto.UsersDto;
import com.phoenix.farmpam.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	//회원 탈퇴 요청
	@RequestMapping("/users/private/delete")
	public ModelAndView delete(HttpSession session, ModelAndView mView) {
		
		service.deleteUser(session, mView);
		
		mView.setViewName("users/delete");
		return mView;
	}
	
	//개인정보 수정반영 요청처리 메소드
	@RequestMapping(value = "/users/private/update", method=RequestMethod.POST)
	public String update(UsersDto dto, HttpSession session) {
		
		service.updateUser(dto, session);

		return "redirect:/users/private/info.do";
	}
	
	//ajax 프로필사진 업로드 요청처리
	@RequestMapping(value = "/users/private/ajax_profile_upload",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> authAjaxProfileUpload(HttpServletRequest request,
			@RequestParam MultipartFile image){
		
		//서비스 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map을 리턴해서 json 문자열 응답하기
		return service.saveProfileImage(request, image);
	}
	
	//회원정보 수정폼 요청처리 (프로필사진)
	@RequestMapping("/users/private/updateform")
	public ModelAndView updateForm(ModelAndView mView, HttpSession session) {
		service.getInfo(session, mView);
		mView.setViewName("users/updateform");
		return mView;
	}
	
	//비밀번호 수정요청
	@RequestMapping("/users/private/pwd_update")
	public ModelAndView pwdUpdate(UsersDto dto,
			ModelAndView mView, HttpSession session) {
		//서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
		service.updateUsersPwd(session, dto, mView);
		//view page로 forward 이동해서 작업 결과를 응답한다.
		mView.setViewName("users/pwd_update");
		return mView;
	}
	
	//비밀번호 수정폼
	@RequestMapping("/users/private/pwd_updateform")
	public String pwdUpdateForm() {
		return "users/pwd_updateform";
	}
	
	@RequestMapping("/users/private/info")
	public ModelAndView info(HttpSession session, ModelAndView mView) {
		
		service.getInfo(session, mView);
		
		mView.setViewName("users/info");
		return mView;
	}
	
	//ID라는 키값으로 저장된 값 삭제 (로그아웃 기능)
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		//세션에서 users_email이라는 키값으로 저장된 값 삭제
		session.removeAttribute("email");
		session.removeAttribute("check");
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
		service.checkbox(dto, session);
		
		String encodedUrl=URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		
		mView.setViewName("users/login");
		return mView;
	}
	
	//vue 로그인 요청
	@RequestMapping("/users/vue/login")
	@ResponseBody
	public Map<String,Object> vuelogin(UsersDto dto, HttpSession session) {
		System.out.println("login 요청");
		System.out.println(dto.getUsers_email());
		
		Map<String, Object> map = new HashMap<String, Object>();
		// response => { email: String, name: String, chk: String ,token: boolean } 
		if(service.loginpro(dto, session)) {
			service.checkbox(dto, session);		
			map.put("email",(String)session.getAttribute("email"));
			map.put("name",(String)session.getAttribute("name"));
			map.put("chk",(String)session.getAttribute("check"));
			// 나중에 JWT 토큰API 사용해보기.
			map.put("token",true);
		}else {
			map.put("token",false);
		}
	
		return map;
	}
	
	//회원가입 요청처리
	@RequestMapping(value="/users/signup", method = RequestMethod.POST)
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		service.addUser(dto);
		mView.setViewName("users/signup");
		return mView;	
	}
	
	// vue 회원가입 요청처리
	@RequestMapping(value="/users/vue/signup", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> vuesignup( UsersDto dto) {
		System.out.println("vue 회원가입 요청");
		System.out.println(dto.getUsers_email());
		dto.setUsers_chk("0");
		service.addUser(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess",true );
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
