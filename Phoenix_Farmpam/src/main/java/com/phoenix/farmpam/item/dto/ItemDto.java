package com.phoenix.farmpam.item.dto;

public class ItemDto {
   private String farmer_email;
   private int item_idx;
   private String item_title;
   private int item_price;
   private int item_stock;
   private String item_content;
   private String item_image;
   private int item_category_top_idx;
   private String item_category_top_name;
   private int item_category_low_idx;
   private String item_category_low_name;
   private String users_email; // 주문자 아이디
   private int orders_item_total; // 주문 수량
   
   public ItemDto() {}

   public ItemDto(String farmer_email, int item_idx, String item_title, int item_price, int item_stock,
         String item_content, String item_image, int item_category_top_idx, String item_category_top_name,
         int item_category_low_idx, String item_category_low_name, String users_email, int orders_item_total) {
      super();
      this.farmer_email = farmer_email;
      this.item_idx = item_idx;
      this.item_title = item_title;
      this.item_price = item_price;
      this.item_stock = item_stock;
      this.item_content = item_content;
      this.item_image = item_image;
      this.item_category_top_idx = item_category_top_idx;
      this.item_category_top_name = item_category_top_name;
      this.item_category_low_idx = item_category_low_idx;
      this.item_category_low_name = item_category_low_name;
      this.users_email = users_email;
      this.orders_item_total = orders_item_total;
   }

   public String getFarmer_email() {
      return farmer_email;
   }

   public void setFarmer_email(String farmer_email) {
      this.farmer_email = farmer_email;
   }

   public int getItem_idx() {
      return item_idx;
   }

   public void setItem_idx(int item_idx) {
      this.item_idx = item_idx;
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

   public int getItem_stock() {
      return item_stock;
   }

   public void setItem_stock(int item_stock) {
      this.item_stock = item_stock;
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

   public String getItem_category_low_name() {
      return item_category_low_name;
   }

   public void setItem_category_low_name(String item_category_low_name) {
      this.item_category_low_name = item_category_low_name;
   }

   public String getUsers_email() {
      return users_email;
   }

   public void setUsers_email(String users_email) {
      this.users_email = users_email;
   }

   public int getOrders_item_total() {
      return orders_item_total;
   }

   public void setOrders_item_total(int orders_item_total) {
      this.orders_item_total = orders_item_total;
   }

   
   
}