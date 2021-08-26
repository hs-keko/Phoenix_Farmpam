package com.phoenix.farmpam.item.dto;

public class ItemCommentsDto {
	private int comments_idx;
	private String comments_writer;
	private String comments_content;
	private String comments_target_id;
	private int comments_ref_group;
	private int comments_group;
	private String comments_deleted;
	private String comments_ban;
	private String comments_regdate;
	private int startRowNum;
	private int endRowNum;
	
	public ItemCommentsDto(int comments_idx, String comments_writer, String comments_content, String comments_target_id,
			int comments_ref_group, int comments_group, String comments_deleted, String comments_ban,
			String comments_regdate, int startRowNum, int endRowNum) {
		super();
		this.comments_idx = comments_idx;
		this.comments_writer = comments_writer;
		this.comments_content = comments_content;
		this.comments_target_id = comments_target_id;
		this.comments_ref_group = comments_ref_group;
		this.comments_group = comments_group;
		this.comments_deleted = comments_deleted;
		this.comments_ban = comments_ban;
		this.comments_regdate = comments_regdate;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	}

	public int getComments_idx() {
		return comments_idx;
	}

	public void setComments_idx(int comments_idx) {
		this.comments_idx = comments_idx;
	}

	public String getComments_writer() {
		return comments_writer;
	}

	public void setComments_writer(String comments_writer) {
		this.comments_writer = comments_writer;
	}

	public String getComments_content() {
		return comments_content;
	}

	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}

	public String getComments_target_id() {
		return comments_target_id;
	}

	public void setComments_target_id(String comments_target_id) {
		this.comments_target_id = comments_target_id;
	}

	public int getComments_ref_group() {
		return comments_ref_group;
	}

	public void setComments_ref_group(int comments_ref_group) {
		this.comments_ref_group = comments_ref_group;
	}

	public int getComments_group() {
		return comments_group;
	}

	public void setComments_group(int comments_group) {
		this.comments_group = comments_group;
	}

	public String getComments_deleted() {
		return comments_deleted;
	}

	public void setComments_deleted(String comments_deleted) {
		this.comments_deleted = comments_deleted;
	}

	public String getComments_ban() {
		return comments_ban;
	}

	public void setComments_ban(String comments_ban) {
		this.comments_ban = comments_ban;
	}

	public String getComments_regdate() {
		return comments_regdate;
	}

	public void setComments_regdate(String comments_regdate) {
		this.comments_regdate = comments_regdate;
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
	
	
}
