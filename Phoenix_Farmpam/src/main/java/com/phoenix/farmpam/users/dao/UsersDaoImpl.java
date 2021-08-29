package com.phoenix.farmpam.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public boolean isExist(String inputUsersEmail) {
		System.out.println(inputUsersEmail);
		//이메일이 존재하는지 여부
		String users_email=session.selectOne("users.isExist", inputUsersEmail);
		if(users_email==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert",dto);
	}

	@Override
	public UsersDto getData(String users_email) {

		return session.selectOne("users.getData", users_email);
	}


}
