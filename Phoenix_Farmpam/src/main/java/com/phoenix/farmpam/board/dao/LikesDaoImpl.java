package com.phoenix.farmpam.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.board.dto.LikesDto;

@Repository
public class LikesDaoImpl implements LikesDao {

	@Autowired
	private SqlSession session;
	
	// 좋아요 추가
	@Override
	public BoardDto likesInsert(BoardDto boardDto, LikesDto likesDto) {
		// 해당 게시물의 좋아요 수를 +1 한다
		session.update("likes.likesup",boardDto);
		// likes 테이블에 추가
		int result = session.insert("likes.likesinsert", likesDto);
		if (result == 1) {	// likes 테이블에 새로운 좋아요 추가가 성공한다면
			//갱신된 좋아요 갯수를 가져옴
			boardDto = session.selectOne("likes.likescount",boardDto);
		}
		return boardDto;
		
	}

	@Override
	public BoardDto likesDelete(BoardDto boardDto, LikesDto likesDto) {
		//해당 게시물의 좋아요 수를 -1 한다.
		session.update("likes.likesdown",boardDto);
		// likes 테이블에서 삭제
		int result = session.delete("likes.likesdelete", likesDto);
		if (result == 1) {	// likes 테이블에 좋아요 삭제가 성공한다면
			//갱신된 좋아요 갯수를 가져옴
			boardDto = session.selectOne("likes.likescount",boardDto);
		}
		return boardDto;
	}
	
}
