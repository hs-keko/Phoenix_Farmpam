package com.phoenix.farmpam.farmer.Service;

import java.util.Map;

import com.phoenix.farmpam.farmer.dto.FarmerDto;

public interface FarmerService {
	public Map<String, Object> isExistEmail(String inputFarmerEmail);
	public void addUser(FarmerDto dto);
}
