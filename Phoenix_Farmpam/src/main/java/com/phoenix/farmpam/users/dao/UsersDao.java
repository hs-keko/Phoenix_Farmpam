package com.phoenix.farmpam.users.dao;

import com.phoenix.farmpam.users.dto.UsersDto;

public interface UsersDao {
	//인자로 전달된 아이디가 존재 하는지 여부를 리턴하는 메소드 
	public boolean isExist(String inputUsersEmail);
	//인자로 전달된 가입하는 회원의 정보를 DB에 저장
	public void insert(UsersDto dto);
	//인자로 전달하는 이메일에 해당하는 정보를 리턴하는 메소드
	public UsersDto getData(String users_email);
	//비밀번호를 수정하는 메소드
	public void updateUsersPwd(UsersDto dto);
	//개인정보를 수정하는 메소드
	public void update(UsersDto dto);
	//회원 정보 삭제 처리 메소드를 만든다.
	public void delete(String users_email);
}
