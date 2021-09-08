package com.phoenix.farmpam.item.dto;

public class ItemCategoryTopDto {
	private int item_category_top_ref;
	private int item_category_top_idx;
	private String item_category_top_name;
	private int item_category_low_idx;
	
	public ItemCategoryTopDto() {}

	public ItemCategoryTopDto(int item_category_top_ref, int item_category_top_idx, String item_category_top_name,
			int item_category_low_idx) {
		super();
		this.item_category_top_ref = item_category_top_ref;
		this.item_category_top_idx = item_category_top_idx;
		this.item_category_top_name = item_category_top_name;
		this.item_category_low_idx = item_category_low_idx;
	}

	public int getItem_category_top_ref() {
		return item_category_top_ref;
	}

	public void setItem_category_top_ref(int item_category_top_ref) {
		this.item_category_top_ref = item_category_top_ref;
	}

	public int getItem_category_top_idx() {
		return item_category_top_idx;
	}

	public void setItem_category_top_idx(int item_category_top_idx) {
		this.item_category_top_idx = item_category_top_idx;
	}

	public String getItem_category_top_name() {
		return item_category_top_name;
	}

	public void setItem_category_top_name(String item_category_top_name) {
		this.item_category_top_name = item_category_top_name;
	}

	public int getItem_category_low_idx() {
		return item_category_low_idx;
	}

	public void setItem_category_low_idx(int item_category_low_idx) {
		this.item_category_low_idx = item_category_low_idx;
	}
	
	
	
	
}
