package com.phoenix.farmpam.board.dao;

import java.util.List;

import com.phoenix.farmpam.board.dto.BoardDto;

public interface BoardDao {
	//글목록
	public List<BoardDto> getList(BoardDto dto);
	//글의 갯수
	public int getCount(BoardDto dto);
	//글 추가
	public void insert(BoardDto dto);
	//글정보 얻어오기
	public BoardDto getData(int board_idx);
	//키워드를 활용한 글정보 얻어오기
	public BoardDto getData2(BoardDto dto);
	//글 삭제
	public void delete(int board_idx);
	//글 수정
	public void update(BoardDto dto);
	
}
