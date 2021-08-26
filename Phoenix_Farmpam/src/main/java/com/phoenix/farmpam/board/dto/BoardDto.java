package com.phoenix.farmpam.board.dto;

public class BoardDto {
	private int board_idx;
	private String board_title;
	private int board_likes;
	private int item_idx;
	private String board_regdate;
	private String board_writer;
	private String board_image;
	private String board_content;
	
	public BoardDto() {}

	public BoardDto(int board_idx, String board_title, int board_likes, int item_idx, String board_regdate,
			String board_writer, String board_image, String board_content) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_likes = board_likes;
		this.item_idx = item_idx;
		this.board_regdate = board_regdate;
		this.board_writer = board_writer;
		this.board_image = board_image;
		this.board_content = board_content;
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

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	
	
}
