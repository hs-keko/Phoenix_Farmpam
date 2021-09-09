package com.phoenix.farmpam.farmer.dto;

public class FarmerDto {
	private String farmer_email;
	private String farmer_pwd;
	private String farmer_name;
	private String farmer_addr;
	private String farmer_addr_detail;
	private String farmer_phone;
	private String farmer_profile;
	private int farmer_follow;
	private String farmer_intro;
	private String farmer_ban;
	private String farmer_regdate;
	private String farmer_chk;
	private String farmer_newPwd;
	
	public FarmerDto() {}

	public FarmerDto(String farmer_email, String farmer_pwd, String farmer_name, String farmer_addr,
			String farmer_addr_detail, String farmer_phone, String farmer_profile, int farmer_follow,
			String farmer_intro, String farmer_ban, String farmer_regdate, String farmer_chk, String farmer_newPwd) {
		super();
		this.farmer_email = farmer_email;
		this.farmer_pwd = farmer_pwd;
		this.farmer_name = farmer_name;
		this.farmer_addr = farmer_addr;
		this.farmer_addr_detail = farmer_addr_detail;
		this.farmer_phone = farmer_phone;
		this.farmer_profile = farmer_profile;
		this.farmer_follow = farmer_follow;
		this.farmer_intro = farmer_intro;
		this.farmer_ban = farmer_ban;
		this.farmer_regdate = farmer_regdate;
		this.farmer_chk = farmer_chk;
		this.farmer_newPwd = farmer_newPwd;
	}

	public String getFarmer_email() {
		return farmer_email;
	}

	public void setFarmer_email(String farmer_email) {
		this.farmer_email = farmer_email;
	}

	public String getFarmer_pwd() {
		return farmer_pwd;
	}

	public void setFarmer_pwd(String farmer_pwd) {
		this.farmer_pwd = farmer_pwd;
	}

	public String getFarmer_name() {
		return farmer_name;
	}

	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}

	public String getFarmer_addr() {
		return farmer_addr;
	}

	public void setFarmer_addr(String farmer_addr) {
		this.farmer_addr = farmer_addr;
	}

	public String getFarmer_addr_detail() {
		return farmer_addr_detail;
	}

	public void setFarmer_addr_detail(String farmer_addr_detail) {
		this.farmer_addr_detail = farmer_addr_detail;
	}

	public String getFarmer_phone() {
		return farmer_phone;
	}

	public void setFarmer_phone(String farmer_phone) {
		this.farmer_phone = farmer_phone;
	}

	public String getFarmer_profile() {
		return farmer_profile;
	}

	public void setFarmer_profile(String farmer_profile) {
		this.farmer_profile = farmer_profile;
	}

	public int getFarmer_follow() {
		return farmer_follow;
	}

	public void setFarmer_follow(int farmer_follow) {
		this.farmer_follow = farmer_follow;
	}

	public String getFarmer_intro() {
		return farmer_intro;
	}

	public void setFarmer_intro(String farmer_intro) {
		this.farmer_intro = farmer_intro;
	}

	public String getFarmer_ban() {
		return farmer_ban;
	}

	public void setFarmer_ban(String farmer_ban) {
		this.farmer_ban = farmer_ban;
	}

	public String getFarmer_regdate() {
		return farmer_regdate;
	}

	public void setFarmer_regdate(String farmer_regdate) {
		this.farmer_regdate = farmer_regdate;
	}

	public String getFarmer_chk() {
		return farmer_chk;
	}

	public void setFarmer_chk(String farmer_chk) {
		this.farmer_chk = farmer_chk;
	}

	public String getFarmer_newPwd() {
		return farmer_newPwd;
	}

	public void setFarmer_newPwd(String farmer_newPwd) {
		this.farmer_newPwd = farmer_newPwd;
	}
}

