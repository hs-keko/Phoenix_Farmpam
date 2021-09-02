package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.users.dto.UsersDto;

public interface ItemDao {

	//인자로 전달하는 이메일에 해당하는 정보를 리턴하는 메소드
	public ItemDto getData(String farmer_email);
}
