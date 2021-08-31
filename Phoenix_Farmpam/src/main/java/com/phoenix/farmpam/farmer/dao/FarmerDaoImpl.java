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

	@Override
	public FarmerDto getData(String farmer_email) {

		return session.selectOne("farmer.getData", farmer_email);
	}

	@Override
	public void updateFarmerPwd(FarmerDto dto) {
		session.update("farmer.pwdUpdate", dto);
		
	}

	@Override
	public void update(FarmerDto dto) {
		session.update("farmer.update", dto);
		
	}

	@Override
	public void delete(String farmer_email) {
		session.delete("farmer.delete", farmer_email);
		
	}


}