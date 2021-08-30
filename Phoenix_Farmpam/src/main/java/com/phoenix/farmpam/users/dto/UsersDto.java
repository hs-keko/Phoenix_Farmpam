package com.phoenix.farmpam.users.dto;

public class UsersDto {
	private String users_email;
	private String users_pwd;
	private String users_name;
	private String users_addr;
	private String users_addr_detail;
	private String users_phone;
	private String users_profile;
	private String users_ban;
	private String users_regdate;
	private String users_chk;
	private String users_newPwd;
	
	public UsersDto() {}

	public UsersDto(String users_email, String users_pwd, String users_name, String users_addr,
			String users_addr_detail, String users_phone, String users_profile, String users_ban, String users_regdate,
			String users_chk, String users_newPwd) {
		super();
		this.users_email = users_email;
		this.users_pwd = users_pwd;
		this.users_name = users_name;
		this.users_addr = users_addr;
		this.users_addr_detail = users_addr_detail;
		this.users_phone = users_phone;
		this.users_profile = users_profile;
		this.users_ban = users_ban;
		this.users_regdate = users_regdate;
		this.users_chk = users_chk;
		this.users_newPwd = users_newPwd;
	}

	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}

	public String getUsers_pwd() {
		return users_pwd;
	}

	public void setUsers_pwd(String users_pwd) {
		this.users_pwd = users_pwd;
	}

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_addr() {
		return users_addr;
	}

	public void setUsers_addr(String users_addr) {
		this.users_addr = users_addr;
	}

	public String getUsers_addr_detail() {
		return users_addr_detail;
	}

	public void setUsers_addr_detail(String users_addr_detail) {
		this.users_addr_detail = users_addr_detail;
	}

	public String getUsers_phone() {
		return users_phone;
	}

	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}

	public String getUsers_profile() {
		return users_profile;
	}

	public void setUsers_profile(String users_profile) {
		this.users_profile = users_profile;
	}

	public String getUsers_ban() {
		return users_ban;
	}

	public void setUsers_ban(String users_ban) {
		this.users_ban = users_ban;
	}

	public String getUsers_regdate() {
		return users_regdate;
	}

	public void setUsers_regdate(String users_regdate) {
		this.users_regdate = users_regdate;
	}

	public String getUsers_chk() {
		return users_chk;
	}

	public void setUsers_chk(String users_chk) {
		this.users_chk = users_chk;
	}

	public String getUsers_newPwd() {
		return users_newPwd;
	}

	public void setUsers_newPwd(String users_newPwd) {
		this.users_newPwd = users_newPwd;
	}


}
