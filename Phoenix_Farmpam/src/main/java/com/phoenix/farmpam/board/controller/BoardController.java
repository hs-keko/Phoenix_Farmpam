package com.phoenix.farmpam.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.board.dao.LikesDao;
import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.board.dto.LikesDto;
import com.phoenix.farmpam.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 좋아요 테스트 페이지 요청
	@RequestMapping(value = "/board/test_likes")
	public String testLikes() {
		
		return "board/test_likes";
	}
	
	// 좋아요 안된 상태에서 클릭시 좋아요 저장
	@ResponseBody
	@RequestMapping(value = "/board/saveLikes", method = RequestMethod.POST)
	public BoardDto saveLikes(@RequestParam int board_idx, HttpSession session) {
		
		LikesDto likesDto = new LikesDto();
		// 게시물 번호 세팅
		likesDto.setBoard_idx(board_idx);
		// 좋아요 누른 유저의 이메일을 세션에서 얻어내기
		String users_email=(String)session.getAttribute("email");
		// LikesDto 객체에 유저 이메일 담기
		likesDto.setUsers_email(users_email);
		// +1된 좋아요를 담아오기 위함
		return service.likesInsert(likesDto);
	}
	
	// 좋아요 된 상태에서 클릭시 좋아요 해제
	@ResponseBody
	@RequestMapping(value = "/board/removeLikes", method = RequestMethod.POST)
	public BoardDto removeLikes(@RequestParam int board_idx, HttpSession session) {
		
		LikesDto likesDto = new LikesDto();
		//게시물 번호 세팅
		likesDto.setBoard_idx(board_idx);
		//좋아요 누른 유저의 이메일을 세션에서 얻어내기
		String users_email=(String)session.getAttribute("email");
		// LikesDto 객체에 유저 이메일 담기
		likesDto.setUsers_email(users_email);
		// -1된 좋아요 갯수를 담아오기 위함
		return service.likesDelete(likesDto);
	}
}