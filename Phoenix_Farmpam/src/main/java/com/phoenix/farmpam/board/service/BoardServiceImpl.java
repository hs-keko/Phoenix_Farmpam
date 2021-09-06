package com.phoenix.farmpam.board.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.farmpam.board.dao.LikesDao;
import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.board.dto.LikesDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private LikesDao dao;
	
	@Override
	public BoardDto likesInsert(LikesDto likesDto) {
		// board 테이블에 해당 게시물의 좋아요 수를 +1 하기위한 BoardDto세팅
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_idx(likesDto.getBoard_idx());
		// DB에서 좋아요 추가 작업을 하고 BoardDto 리턴
		return dao.likesInsert(boardDto, likesDto);
	}

	@Override
	public BoardDto likesDelete(LikesDto likesDto) {
		// board 테이블에 해당 게시물의 좋아요 수를 -1 하기 위한  BoardDto세팅
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_idx(likesDto.getBoard_idx());
		// DB에서 좋아요 삭제 작업을 하고 BoardDto 리턴
		return dao.likesDelete(boardDto, likesDto);
	}

}
