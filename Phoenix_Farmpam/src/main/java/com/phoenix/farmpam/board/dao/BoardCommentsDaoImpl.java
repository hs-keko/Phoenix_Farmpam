package com.phoenix.farmpam.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.board.dto.BoardCommentsDto;

@Repository
public class BoardCommentsDaoImpl implements BoardCommentsDao{

	@Autowired
    private SqlSession session;

	@Override
	public List<BoardCommentsDto> getList(BoardCommentsDto dto) {
		return session.selectList("boardComments.getList", dto);
	}

	@Override
	public void delete(int comments_idx) {
		session.update("boardComments.delete", comments_idx);
		
	}

	@Override
	public void insert(BoardCommentsDto dto) {
		session.insert("boardComments.insert", dto);
		
	}

	@Override
	public int getSequence() {
		return session.selectOne("boardComments.getSequence");
	}

	@Override
	public void update(BoardCommentsDto dto) {
		session.update("boardComments.update", dto);
		
	}

	@Override
	public BoardCommentsDto getData(int comments_idx) {
		return session.selectOne("boardComments.getData", comments_idx);
	}

	@Override
	public int getCount(int comments_ref_group) {
		return session.selectOne("boardComments.getCount", comments_ref_group);
	}

	


}
