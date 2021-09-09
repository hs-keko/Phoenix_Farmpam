package com.phoenix.farmpam.board.dao;

import java.util.List;

import com.phoenix.farmpam.board.dto.BoardCommentsDto;

public interface BoardCommentsDao {
	//댓글 목록 얻어오기 
		public List<BoardCommentsDto> getList(BoardCommentsDto dto);
		//댓글 삭제 
		public void delete(int comments_idx);
		//댓글 추가 
		public void insert(BoardCommentsDto dto);
		//추가할 댓글의 글번호를 리턴하는 메소드 
		public int getSequence();
		//댓글 수정
		public void update(BoardCommentsDto dto);
		//댓글 하나의 정보를 리턴하는 메소드
		public BoardCommentsDto getData(int comments_idx);
		//댓글의 갯수를 리턴하는 메소드
		public int getCount(int comments_ref_group);	
}
