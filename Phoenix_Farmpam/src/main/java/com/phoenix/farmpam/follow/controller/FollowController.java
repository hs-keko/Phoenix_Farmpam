package com.phoenix.farmpam.follow.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoenix.farmpam.follow.dto.FollowDto;
import com.phoenix.farmpam.follow.service.FollowService;
import com.phoenix.farmpam.users.dto.UsersDto;

@Controller
public class FollowController {
	
	@Autowired
	private FollowService service;
	
	// 팔로우 하기
	@RequestMapping("/follow/follow")
	@ResponseBody
	public Map<String, Object> following(HttpServletRequest req) {
		FollowDto dto = new FollowDto();
		dto.setFarmer_email(req.getParameter("farmer_email"));
		dto.setUsers_email(req.getParameter("email"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isOk",true);
		try {			
			service.following(dto);
		}catch(Exception e) {
			System.out.println(e);
			map.put("isOk",false);
		}
		return map;
	}
	
	// 언팔 하기
	@RequestMapping("/follow/unfollow")
	@ResponseBody
	public Map<String, Object> unFollow(HttpServletRequest req) {
		FollowDto dto = new FollowDto();
		dto.setFarmer_email(req.getParameter("farmer_email"));
		dto.setUsers_email(req.getParameter("email"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isOk",true);
		try {			
			service.unFollow(dto);
		}catch(Exception e) {
			System.out.println(e);
			map.put("isOk",false);
		}
		return map;
	}
	
	// 팔로우 상태 확인
	@RequestMapping("/follow/followcheck")
	@ResponseBody
	public Map<String, Object> followCheck(HttpServletRequest req){
		FollowDto dto = new FollowDto();
		dto.setFarmer_email(req.getParameter("farmer_email"));
		dto.setUsers_email(req.getParameter("email"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("val",service.followCheck(dto));
		
		return map;
	}
}
