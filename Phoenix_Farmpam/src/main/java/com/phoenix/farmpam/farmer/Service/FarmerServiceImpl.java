package com.phoenix.farmpam.farmer.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.phoenix.farmpam.farmer.dao.FarmerDao;
import com.phoenix.farmpam.farmer.dto.FarmerDto;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerDao dao;
	
	@Override
	public Map<String, Object> isExistEmail(String inputFarmerEmail) {
		// map 객체를 생성한다
		Map<String, Object> map = new HashMap<String, Object>();
		//isExist라는 키값으로 아이디가 존재하는지 여부를 담는다.
		map.put("isExist", dao.isExist(inputFarmerEmail));
		return map;
	}

	@Override
	public void addUser(FarmerDto dto) {
		// 사용자가 입력한 비밀번호 읽어오기
		String users_pwd=dto.getFarmer_pwd();
		//암호화 하고
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(users_pwd);
		//dto에 넣어주기
		dto.setFarmer_pwd(encodedPwd);
		
		dao.insert(dto);
		
	}

}
