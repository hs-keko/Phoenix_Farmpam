package com.phoenix.farmpam.farmer.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.follow.dto.FollowDto;

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
	
	// 팔로우 추가
	@Override
	public FarmerDto followInsert(FarmerDto farmerDto, FollowDto followDto) {
		
		// 해당 농장주의 팔로워 수를 +1 한다
		session.update("follow.followup", farmerDto);
		// follow 테이블에 추가
		int result = session.insert("follow.followinsert", followDto);
		if (result == 1) {	// follow 테이블에 새로운 팔로우 추가가 성공한다면
			// 갱신된 팔로워 수를 가져옴
			farmerDto = session.selectOne("follow.followcount", farmerDto);
		}
		return farmerDto; 
	}

	// 팔로우 해제
	@Override
	public FarmerDto followDelete(FarmerDto farmerDto, FollowDto followDto) {
		
		// 해당 농장주의 팔로워 수를 -1 한다
		session.update("follow.followdown", farmerDto);
		// follow 테이블에 추가
		int result = session.insert("follow.followdelete", followDto);
		if (result == 1) {	// follow 테이블에 팔로우 삭제가 성공한다면
			// 갱신된 팔로워 수를 가져옴
			farmerDto = session.selectOne("follow.followcount", farmerDto);
		}
		return farmerDto; 
	}
	
}