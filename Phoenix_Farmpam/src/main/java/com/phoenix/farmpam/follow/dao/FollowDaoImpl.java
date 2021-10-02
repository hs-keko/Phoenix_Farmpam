package com.phoenix.farmpam.follow.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.follow.dto.FollowDto;

@Repository
public class FollowDaoImpl implements FollowDao{
	
	@Autowired
	private SqlSession session;
	
	// 팔로우하기
	@Override
	public void following(FollowDto dto) {
		session.insert("follow.followinsert",dto);
		session.update("follow.followup",dto);
	}
	
	// 언팔 하기
	@Override
	public void unFollow(FollowDto dto) {
		session.delete("follow.followdelete",dto);
		session.update("follow.followdown",dto);
	}
	
	// 팔로우 상태확인
	@Override
	public FollowDto followCheck(FollowDto dto) {
		return session.selectOne("follow.isFollow",dto);
	}
}
