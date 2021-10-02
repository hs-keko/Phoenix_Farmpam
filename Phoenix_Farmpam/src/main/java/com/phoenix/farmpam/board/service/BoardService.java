
package com.phoenix.farmpam.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.board.dto.BoardCommentsDto;
import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.board.dto.LikesDto;
import com.phoenix.farmpam.item.dto.ItemDto;

public interface BoardService {
	//게시글 좋아요 추가
	public BoardDto likesInsert(LikesDto likesDto);
	//게시글 좋아요 삭제
	public BoardDto likesDelete(LikesDto likesDto);
	public void getList(HttpServletRequest request);
	//게시글 목록을 리턴하는 메소드 
	public List<BoardDto> getList2(HttpServletRequest request);
	//이미지와 게시글 자세히 보기
	public void getDetail(ModelAndView mView, int board_idx);
	//게시판에 글 추가하기
	public void insertContent(BoardDto dto, Map<String, Object> map, HttpServletRequest request);
	public void updateContent(BoardDto dto);
	public void deleteContent(int board_idx, HttpServletRequest request);
	public void getData(HttpServletRequest request); //글 수정하기 위해 정보 불러오는 기능
	//갤러리에 사진 저장하기 - ajax
	public Map<String, Object> saveBoardImage(HttpServletRequest request,
			MultipartFile mFile);
	//board에 사진이랑 게시글  upload & DB 저장하기
	public void saveContent(BoardDto dto);
	//갤러리에 사진 저장하기 - db에만 저장(upload 작업은 이미 완료)
	public void insertImage(BoardDto dto, HttpServletRequest request);
	public void saveComment(HttpServletRequest request);//댓글 저장 
	public void deleteComment(HttpServletRequest request);//댓글 삭제
	public void updateComment(BoardCommentsDto dto);//댓글 수정
	public void moreCommentList(HttpServletRequest request);//댓글 추가 응답
	// 유저 글목록 가져오기
	public void getMyList(HttpServletRequest req, Map<String, Object> map);
	//index 페이지에서 보여주는 게시글 리스트
	public void vueIndexList(Map<String, Object> map, HttpServletRequest request);
} 