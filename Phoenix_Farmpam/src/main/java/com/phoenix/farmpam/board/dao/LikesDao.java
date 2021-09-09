package com.phoenix.farmpam.board.dao;

import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.board.dto.LikesDto;

public interface LikesDao {
	//좋아요 추가
	public BoardDto likesInsert(BoardDto boardDto, LikesDto likesDto);
	//좋아요 해제
	public BoardDto likesDelete(BoardDto boardDto, LikesDto likesDto);
}
