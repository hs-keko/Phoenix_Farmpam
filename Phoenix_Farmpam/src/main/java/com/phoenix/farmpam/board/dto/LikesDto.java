package com.phoenix.farmpam.board.dto;

public class LikesDto {
	private int board_idx;
	private String users_email;
	private String likes_check;
	private int count; //좋아요가 눌린 상태인지 아닌지
	
	public LikesDto() {}

	public LikesDto(int board_idx, String users_email, String likes_check, int count) {
		super();
		this.board_idx = board_idx;
		this.users_email = users_email;
		this.likes_check = likes_check;
		this.count = count;
	}

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}

	public String getLikes_check() {
		return likes_check;
	}

	public void setLikes_check(String likes_check) {
		this.likes_check = likes_check;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
