package com.phoenix.farmpam.farmer.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.farmer.dao.FarmerDao;
import com.phoenix.farmpam.farmer.dto.FarmerDto;

@Repository
public class FarmerDaoImpl implements FarmerDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public boolean isExist(String inputFarmerEmail) {
		String farmer_email=session.selectOne("farmer.isExist", inputFarmerEmail);
			if(farmer_email==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void insert(FarmerDto dto) {
		session.insert("farmer.insert", dto);
		
	}
}