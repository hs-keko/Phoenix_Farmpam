package com.phoenix.farmpam.users.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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

	@Override
	public void loginProcess(UsersDto dto, HttpSession session) {
		//입력한 정보가 맞는여부
		boolean isValid=false;
		
		//1. 로그인 폼에 입력한 아이디를 이용해서 해당 정보를 select 해 본다. 
		UsersDto result=dao.getData(dto.getUsers_email());
		if(result != null) {//만일 존재하는 아이디 라면
			//비밀번호가 일치하는지 확인한다.
			String encodedPwd=result.getUsers_pwd(); //DB 에 저장된 암호화된 비밀번호 
			String inputUsersPwd=dto.getUsers_pwd(); //로그인폼에 입력한 비밀번호
			//Bcrypt 클래스의 static 메소드를 이용해서 일치 여부를 얻어낸다.
			isValid=BCrypt.checkpw(inputUsersPwd, encodedPwd);
		}
		
		if(isValid) {//만일 유효한 정보이면 
			//로그인 처리를 한다.
			session.setAttribute("email", dto.getUsers_email());
		}
	}
}
