package com.phoenix.farmpam.users.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.phoenix.farmpam.users.dao.UsersDao;
import com.phoenix.farmpam.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao dao;
	
	@Override
	public Map<String, Object> isExistEmail(String inputUsersEmail) {
		//Map 객체 생성
		Map<String, Object> map=new HashMap<String, Object>();
		//isExist라는 키값으로 이메일이 존재하는지 여부를 담는다
		map.put("isExist", dao.isExist(inputUsersEmail));
		//map 객체 리턴
		return map;
	}

	@Override
	public void addUser(UsersDto dto) {
		// 사용자가 입력한 비밀번호 읽어오기
		String users_pwd=dto.getUsers_pwd();
		//암호화 하고
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(users_pwd);
		//dto에 넣어주기
		dto.setUsers_pwd(encodedPwd);
		
		dao.insert(dto);
		
	}
}
