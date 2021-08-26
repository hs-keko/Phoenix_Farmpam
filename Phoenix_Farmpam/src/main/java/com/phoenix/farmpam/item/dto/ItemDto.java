package com.phoenix.farmpam.item.dto;

public class ItemDto {
	private int item_idx;
	private String farmer_email;
	private String item_title;
	private String item_content;
	private String item_image;
	private int item_price;
	private int item_stock;
	private int item_category_top_idx;
	
	public ItemDto() {}
	
	public ItemDto(int item_idx, String farmer_email, String item_title, String item_content, String item_image,
			int item_price, int item_stock, int item_category_top_idx) {
		super();
		this.item_idx = item_idx;
		this.farmer_email = farmer_email;
		this.item_title = item_title;
		this.item_content = item_content;
		this.item_image = item_image;
		this.item_price = item_price;
		this.item_stock = item_stock;
		this.item_category_top_idx = item_category_top_idx;
	}

	public int getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}

	public String getFarmer_email() {
		return farmer_email;
	}

	public void setFarmer_email(String farmer_email) {
		this.farmer_email = farmer_email;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public String getItem_image() {
		return item_image;
	}

	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public int getItem_category_top_idx() {
		return item_category_top_idx;
	}

	public void setItem_category_top_idx(int item_category_top_idx) {
		this.item_category_top_idx = item_category_top_idx;
	}
	
	
	
}
