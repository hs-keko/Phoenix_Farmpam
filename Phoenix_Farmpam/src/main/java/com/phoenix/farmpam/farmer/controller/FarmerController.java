package com.phoenix.farmpam.farmer.controller;

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
import org.springframework.web.multipart.MultipartFile;
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
	

	//회원 탈퇴 요청 처리
	@RequestMapping("/farmer/private/delete_farmer")
	public ModelAndView delete(HttpSession session, ModelAndView mView) {
		
		service.deleteUser(session, mView);
		
		mView.setViewName("farmer/delete_farmer");
		return mView;
	}
	
	//개인 정보 수정 반영 요청 처리 메소드
	@RequestMapping(value = "/farmer/private/update_farmer", method=RequestMethod.POST)
	public String update(FarmerDto dto, HttpSession session) {
		
		service.updateUser(dto, session);

		return "redirect:/farmer/private/info_farmer.do";
	}
	
	//ajax 프로필 사진 업로드 요청처리
	@RequestMapping(value = "/farmer/private/ajax_profile_upload_farmer",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> authAjaxProfileUpload(HttpServletRequest request,
			@RequestParam MultipartFile image){
		
		//서비스 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map을 리턴해서 json 문자열 응답하기
		return service.saveProfileImage(request, image);
	}
	
	//회원정보 수정폼 요청처리
	@RequestMapping("/farmer/private/updateform_farmer")
	public ModelAndView updateForm(ModelAndView mView, HttpSession session) {
		service.getInfo(session, mView);
		mView.setViewName("farmer/updateform_farmer");
		return mView;
	}
	
	//비밀번호 수정요청
	@RequestMapping("/farmer/private/pwd_update_farmer")
	public ModelAndView pwdUpdate(FarmerDto dto,
			ModelAndView mView, HttpSession session) {
		
		//서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
		service.updateFarmerPwd(session, dto, mView);
		
		//view page로 forward 이동해서 작업 결과를 응답한다.
		mView.setViewName("farmer/pwd_update_farmer");
		return mView;
	}
	
	//비밀번호 수정폼 요청
	@RequestMapping("/farmer/private/pwd_updateform_farmer")
	public String pwdUpdateForm() {
		return "farmer/pwd_updateform_farmer";
	}
	
	//회원 정보 페이지 요청
	@RequestMapping("/farmer/private/info_farmer")
	public ModelAndView info(HttpSession session, ModelAndView mView) {
		
		service.getInfo(session, mView);
		
		mView.setViewName("farmer/info_farmer");
		return mView;
	}
	
	//로그아웃 요청 처리
	@RequestMapping("/farmer/logout")
	public String logout(HttpSession session) {
		//세션에서 farmer_email 키값으로 저장된 값을 삭제
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
		service.checkbox(dto, session);
		
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
