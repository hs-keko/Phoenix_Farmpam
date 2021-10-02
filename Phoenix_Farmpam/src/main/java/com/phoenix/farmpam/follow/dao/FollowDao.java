package com.phoenix.farmpam.follow.dao;

import com.phoenix.farmpam.follow.dto.FollowDto;

public interface FollowDao {
	// 팔로우
	public void following(FollowDto dto);
	// 언팔
	public void unFollow(FollowDto dto);
	// 팔로우 상태확인
	public FollowDto followCheck(FollowDto dto);
}
