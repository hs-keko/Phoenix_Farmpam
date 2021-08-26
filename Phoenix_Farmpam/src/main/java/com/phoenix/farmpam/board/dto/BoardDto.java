package com.phoenix.farmpam.board.dto;

import org.springframework.web.multipart.MultipartFile;

public class BoardDto {
	//게시글 num
	private int board_idx;
	private String board_title;
	//게시글 내용
	private String board_content;
	//게시글 좋아요 수 
	private int board_likes;
	//상품글 num
	private int item_idx;
	private String board_regdate;
	private String board_writer;
	//게시글 이미지 경로
	private String board_image;
	private int startRowNum;
	private int endRowNum;
	private int prevNum; //이전글의 글번호
	private int nextNum; //다음글의 글번호
	//이미지 파일 업로드 처리를 위한 필드
	private MultipartFile image;	
	
	public BoardDto() {}
	
	public BoardDto(int board_idx, String board_title, String board_content, int board_likes, int item_idx,
			String board_regdate, String board_writer, String board_image, int startRowNum, int endRowNum, int prevNum,
			int nextNum, MultipartFile image) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_likes = board_likes;
		this.item_idx = item_idx;
		this.board_regdate = board_regdate;
		this.board_writer = board_writer;
		this.board_image = board_image;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
		this.image = image;
	}

	

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_likes() {
		return board_likes;
	}

	public void setBoard_likes(int board_likes) {
		this.board_likes = board_likes;
	}

	public int getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}

	public String getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public String getBoard_image() {
		return board_image;
	}

	public void setBoard_image(String board_image) {
		this.board_image = board_image;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
}
	
	
