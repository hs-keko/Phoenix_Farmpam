package com.phoenix.farmpam.farmer.dao;

import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.follow.dto.FollowDto;

public interface FarmerDao {
	//인자로 전달된 이메일이 존재하는지 여부를 리턴하는 메소드
	public boolean isExist(String inputFarmerEmail);
	//인자로 전달된 가입하는 회원의 정보를 db에 저장하는 메소드
	public void insert(FarmerDto dto);
	//인자로 전달하는 이메일에 해당하는 정보를 리턴하는 메소드
	public FarmerDto getData(String farmer_email);
	//비밀번호를 수정하는 메소드
	public void updateFarmerPwd(FarmerDto dto);
	//개인정보를 수정하는 메소드
	public void update(FarmerDto dto);
	//회원정보를 삭제하는 메소드
	public void delete(String farmer_email);
	// 팔로우 추가
	public FarmerDto followInsert(FarmerDto farmerDto, FollowDto followDto);
	// 팔로우 해제
	public FarmerDto followDelete(FarmerDto farmerDto, FollowDto followDto);
	
}
