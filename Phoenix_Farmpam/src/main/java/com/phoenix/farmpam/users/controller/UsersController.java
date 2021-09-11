package com.phoenix.farmpam.users.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.users.dto.UsersDto;
import com.phoenix.farmpam.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	//회원 탈퇴 요청
	@RequestMapping("/users/private/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		service.deleteUser(request, map);

		return map;
	}

	//개인정보 수정반영 요청처리 메소드
	@RequestMapping(value = "/users/private/update", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(UsersDto dto, HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		service.updateUser(dto, request, map);

		return map;
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
	@ResponseBody
	public Map<String, Object> updateForm(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		service.getInfo(request, map);
		return map;
	}
	
	//비밀번호 수정요청
	@RequestMapping("/users/private/pwd_update")
	@ResponseBody
	public Map<String, Object> pwdUpdate(UsersDto dto, HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		//서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
		service.updateUsersPwd(dto, request, map);
		//view page로 forward 이동해서 작업 결과를 응답한다.
		return map;
	}
	
	//비밀번호 수정폼
	@RequestMapping("/users/private/pwd_updateform")
	@ResponseBody
	public Map<String, Object> pwdUpdateForm() {
		Map<String, Object> map=new HashMap<String, Object>();
		return map;
	}
	
	//회원정보 폼
	@RequestMapping("/users/private/info")
	@ResponseBody
	public Map<String, Object> info(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		service.getInfo(request, map);
		return map;
	}
	
	//ID라는 키값으로 저장된 값 삭제 (로그아웃 기능)
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		//세션에서 farmer_email 키값으로 저장된 값을 삭제
		session.removeAttribute("users_email");
		return "users/logout";
	}
	
	//로그인 폼 요청 처리
	@RequestMapping("/users/loginform")
	@ResponseBody
	public Map<String,Object> loginform() {
		Map<String, Object> map=new HashMap<String, Object>();
		return map;
	}
	
	//vue 로그인 요청
	@RequestMapping("/users/vue/login")
	@ResponseBody
	public Map<String,Object> vuelogin(UsersDto dto, HttpSession session) {
		System.out.println("login 요청");
		System.out.println("users_email : "+dto.getUsers_email());
		
		Map<String, Object> map = new HashMap<String, Object>();
		// response => { email: String, name: String, chk: String ,token: boolean } 
		if(service.loginpro(dto, session)) {
			service.checkbox(dto, session);		
			map.put("email",(String)session.getAttribute("email"));
			map.put("name",(String)session.getAttribute("name"));
			map.put("chk",(String)session.getAttribute("check"));
			// 나중에 JWT 토큰API 사용해보기.
			map.put("token",true);
			System.out.println("로그인 성공");
		}else {
			map.put("token",false);
			System.out.println("로그인 실패");
		}
	
		return map;
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
	@ResponseBody
	public Map<String,Object> signupBefore() {
		Map<String, Object> map=new HashMap<String, Object>();
		return map;
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
	@ResponseBody
	public Map<String, Object> signupForm() {
		Map<String, Object> map=new HashMap<String, Object>();
		return map;
	}
}