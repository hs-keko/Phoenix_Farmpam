package com.phoenix.farmpam.follow.service;

import com.phoenix.farmpam.follow.dto.FollowDto;

public interface FollowService {
	// 팔로우
	public void following(FollowDto dto);
	// 언팔하기
	public void unFollow(FollowDto dto);
	// 팔로우 상태확인
	public boolean followCheck(FollowDto dto);
}
