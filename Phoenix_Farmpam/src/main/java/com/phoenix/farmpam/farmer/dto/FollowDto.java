package com.phoenix.farmpam.farmer.dto;

public class FollowDto {
	private int follow_idx;
	private String farmer_email;
	private String users_email;
	
	public FollowDto () {}

	public FollowDto(int follow_idx, String farmer_email, String users_email) {
		super();
		this.follow_idx = follow_idx;
		this.farmer_email = farmer_email;
		this.users_email = users_email;
	}

	public int getFollow_idx() {
		return follow_idx;
	}

	public void setFollow_idx(int follow_idx) {
		this.follow_idx = follow_idx;
	}

	public String getFarmer_email() {
		return farmer_email;
	}

	public void setFarmer_email(String farmer_email) {
		this.farmer_email = farmer_email;
	}

	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	};
	
}
