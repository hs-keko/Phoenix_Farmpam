package com.phoenix.farmpam.follow.service;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.farmpam.follow.dao.FollowDao;
import com.phoenix.farmpam.follow.dto.FollowDto;

@Service
public class FollowServiceImpl implements FollowService{
	@Autowired
	private FollowDao dao;
	
	// 팔로우
	@Override
	public void following(FollowDto dto) {
		dao.following(dto);
	}
	
	// 언팔
	@Override
	public void unFollow(FollowDto dto) {
		dao.unFollow(dto);
	}
	
	// 팔로우 상태 확인
	@Override
	public boolean followCheck(FollowDto dto) {
		boolean val = false;
		if(dao.followCheck(dto) != null) {
			val = true;
		}
		return val;
	}
}
