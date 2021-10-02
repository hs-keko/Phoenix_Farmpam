package com.phoenix.farmpam.follow.dto;

public class FollowDto {
	private int follow_idx;
	private String farmer_email;
	private String users_email;
	private String follow_check;
	
	public FollowDto() {};
	
	public FollowDto(int follow_idx, String follow_email, String users_email, String follow_check) {
		super();
		this.follow_idx = follow_idx;
		this.users_email = users_email;
		this.follow_check = follow_check;
	}

	public int getFollow_idx() {
		return follow_idx;
	}

	public void setFollow_idx(int follow_idx) {
		this.follow_idx = follow_idx;
	}

	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}

	public String getFollow_check() {
		return follow_check;
	}

	public void setFollow_check(String follow_check) {
		this.follow_check = follow_check;
	}

	public String getFarmer_email() {
		return farmer_email;
	}

	public void setFarmer_email(String farmer_email) {
		this.farmer_email = farmer_email;
	}
	
	
}
