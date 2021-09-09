package com.phoenix.farmpam.item.dto;

public class CartDto {
	private int cart_idx;
	private int item_idx;
	private String users_email;
	private int cart_amount;
	private String item_title;
	private int item_price;
	private String item_image;
	private int cart_price;
	
	public CartDto() {}

	public CartDto(int cart_idx, int item_idx, String users_email, int cart_amount, String item_title, int item_price,
			String item_image, int cart_price) {
		super();
		this.cart_idx = cart_idx;
		this.item_idx = item_idx;
		this.users_email = users_email;
		this.cart_amount = cart_amount;
		this.item_title = item_title;
		this.item_price = item_price;
		this.item_image = item_image;
		this.cart_price = cart_price;
	}

	public int getCart_idx() {
		return cart_idx;
	}

	public void setCart_idx(int cart_idx) {
		this.cart_idx = cart_idx;
	}

	public int getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}

	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}

	public int getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_image() {
		return item_image;
	}

	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}

	public int getCart_price() {
		return cart_price;
	}

	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}

	
}
