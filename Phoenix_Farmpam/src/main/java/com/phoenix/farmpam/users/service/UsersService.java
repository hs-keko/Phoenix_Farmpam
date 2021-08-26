package com.phoenix.farmpam.users.service;

import java.util.Map;

import com.phoenix.farmpam.users.dto.UsersDto;

public interface UsersService {
	
	public Map<String, Object> isExistEmail(String inputUsersEmail);
	public void addUser(UsersDto dto);
}
