package com.phoenix.farmpam.board.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@Autowired
	private LikesDao likesDao;
	
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
		// +1 된 좋아요 담아오기 위함
		BoardDto boardDto = likesDao.likesInsert(likesDto);
		
		return boardDto;
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
		BoardDto boardDto = likesDao.likesDelete(likesDto);
		
		return boardDto;
	}
	
	@RequestMapping("/board/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		
		return "board/list";
	}
	
	@RequestMapping("/board/insertform")
	public ModelAndView authInsertForm(HttpServletRequest request) {
		
		return new ModelAndView("board/insertform");
	}
	
	//imagePath 구성 X -> dto 로 imagePath 를 받아서 DB 에 저장하기
	@RequestMapping(value = "/board/insert")
	public ModelAndView authInsert(BoardDto dto, HttpServletRequest request) {
		//dto : caption, imagePath 가지고 있다.
		//request : dto 에 writer(id) 추가
		service.saveContent(dto, request);
		
		return new ModelAndView("board/insert");
	}		
	
	//imagePath 구성 X -> dto 로 imagePath 를 받아서 DB 에 저장하기
	@RequestMapping(value = "/board/ajax_insert")
	@ResponseBody
	public Map<String, Object> authAjaxInsert(BoardDto dto, HttpServletRequest request) {
		//dto : caption, imagePath 가지고 있다.
		//request : dto 에 writer(id) 추가
		service.saveContent(dto, request);
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", true);
		return map;
	}	
	//게시글의 num 이 parameter get 방식으로 넘어온다.
	//이미지, 글 자세히 보기 요청 처리 (detail 페이지)
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mView, @RequestParam int num) {
		//갤러리 detail 페이지에 필요한 data를 num 으로 가져와, ModelAndView 에 저장
		service.getDetail(mView, num);
		mView.setViewName("board/detail");
		
		return mView;
	}
	
	//카페글 삭제 요청 처리 
	@RequestMapping("/board/delete")
	public ModelAndView authDelete(@RequestParam int num, HttpServletRequest request) {
		
		service.deleteContent(num, request);
		
		return new ModelAndView("redirect:/board/list.do");
	}
	
	@RequestMapping("/board/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request) {
		
		service.getData(request);
		
		return  new ModelAndView("board/updateform");
	}
	//카페글 수정 요청 처리 
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public ModelAndView authUpdate(BoardDto dto, HttpServletRequest request) {
		service.updateContent(dto);
		return new ModelAndView("board/update");
	}
}




