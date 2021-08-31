package com.phoenix.farmpam.item.dto;

//주문 정보를 담을 Dto
public class OrdersDto {
	private int orders_idx; //주문 번호
	private String users_email;	//주문자의 아이디
	private int orders_price; //주문 가격
	private String orders_check; //주문 확인 여부
	private String orders_regdate; //주문일
	private int orders_detail_idx; //주문 상세정보 번호
	private int item_idx; //상품 번호
	private int item_price; //상품 개당 가격
	private int orders_item_total; //주문 수량
	private String orders_addr; //배송지 주소
	public OrdersDto(int orders_idx, String users_email, int orders_price, String orders_check, String orders_regdate,
			int orders_detail_idx, int item_idx, int item_price, int orders_item_total, String orders_addr) {
		super();
		this.orders_idx = orders_idx;
		this.users_email = users_email;
		this.orders_price = orders_price;
		this.orders_check = orders_check;
		this.orders_regdate = orders_regdate;
		this.orders_detail_idx = orders_detail_idx;
		this.item_idx = item_idx;
		this.item_price = item_price;
		this.orders_item_total = orders_item_total;
		this.orders_addr = orders_addr;
	}
	public int getOrders_idx() {
		return orders_idx;
	}
	public void setOrders_idx(int orders_idx) {
		this.orders_idx = orders_idx;
	}
	public String getUsers_email() {
		return users_email;
	}
	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}
	public int getOrders_price() {
		return orders_price;
	}
	public void setOrders_price(int orders_price) {
		this.orders_price = orders_price;
	}
	public String getOrders_check() {
		return orders_check;
	}
	public void setOrders_check(String orders_check) {
		this.orders_check = orders_check;
	}
	public String getOrders_regdate() {
		return orders_regdate;
	}
	public void setOrders_regdate(String orders_regdate) {
		this.orders_regdate = orders_regdate;
	}
	public int getOrders_detail_idx() {
		return orders_detail_idx;
	}
	public void setOrders_detail_idx(int orders_detail_idx) {
		this.orders_detail_idx = orders_detail_idx;
	}
	public int getItem_idx() {
		return item_idx;
	}
	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getOrders_item_total() {
		return orders_item_total;
	}
	public void setOrders_item_total(int orders_item_total) {
		this.orders_item_total = orders_item_total;
	}
	public String getOrders_addr() {
		return orders_addr;
	}
	public void setOrders_addr(String orders_addr) {
		this.orders_addr = orders_addr;
	}
	
	
}
