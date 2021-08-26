package com.phoenix.farmpam.item.dto;

public class ItemCategoryLowDto {
	private int item_category_low_idx;
	private String item_category_low_name;
	
	public ItemCategoryLowDto(int item_category_low_idx, String item_category_low_name) {
		super();
		this.item_category_low_idx = item_category_low_idx;
		this.item_category_low_name = item_category_low_name;
	}

	public int getItem_category_low_idx() {
		return item_category_low_idx;
	}

	public void setItem_category_low_idx(int item_category_low_idx) {
		this.item_category_low_idx = item_category_low_idx;
	}

	public String getItem_category_low_name() {
		return item_category_low_name;
	}

	public void setItem_category_low_name(String item_category_low_name) {
		this.item_category_low_name = item_category_low_name;
	}
	
	
	
}
