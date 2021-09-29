package com.phoenix.farmpam.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
    @Autowired
    private SqlSession session;
	
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return session.selectList("board.getList", dto);
	}

	@Override
	public int getCount(BoardDto dto) {
		
		return session.selectOne("board.getCount", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		session.insert("board.insert", dto);
		
	}

	@Override
	public BoardDto getData(int board_idx) {
		return session.selectOne("board.getData", board_idx);
	}

	@Override
	public BoardDto getData2(BoardDto dto) {
		return session.selectOne("board.getData2", dto);
	}

	@Override
	public void delete(int board_idx) {
		session.delete("board.delete", board_idx);
		
	}

	@Override
	public void update(BoardDto dto) {
		session.update("board.update", dto);
		
	}

	@Override
	public void insertContent(BoardDto dto) {
		session.insert("board.insertContent", dto);
		
	}
	
}
