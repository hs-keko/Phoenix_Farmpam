package com.phoenix.farmpam.board.dto;

public class LikesDto {
	private int likes_idx;
	private int board_idx;
	private String users_email;
	private String likes_check;
	
	public LikesDto() {}

	public LikesDto(int likes_idx, int board_idx, String users_email, String likes_check) {
		super();
		this.likes_idx = likes_idx;
		this.board_idx = board_idx;
		this.users_email = users_email;
		this.likes_check = likes_check;
	}

	public int getLikes_idx() {
		return likes_idx;
	}

	public void setLikes_idx(int likes_idx) {
		this.likes_idx = likes_idx;
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
	
	
}
