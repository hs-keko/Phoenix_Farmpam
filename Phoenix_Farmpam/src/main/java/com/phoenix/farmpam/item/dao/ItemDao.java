package com.phoenix.farmpam.item.dao;

import java.util.List;

import com.phoenix.farmpam.item.dto.ItemCategoryTopDto;
import com.phoenix.farmpam.item.dto.ItemDto;

public interface ItemDao {
	//상품 목록
	public List<ItemDto> getListItem(ItemDto dto);
	
	//인자로 전달하는 이메일에 해당하는 정보를 리턴하는 메소드
	public ItemDto getData3(int item_idx);
	
	//글의 갯수
	public int getCount(ItemDto dto);
	
	//글 추가
	public void insertItem(ItemDto dto);
	
	//글 삭제
	public void delete(int num);
	
	//글 수정
	public void update(ItemDto itemDto);
	
	// 상품의 가격을 리턴해주는 메소드
	public int getPrice(int item_idx);
	
	// 계좌 잔고 줄이기
	public void minusMoney(ItemDto itemDto);
	
	// 상품 재고 감소시키기
	public void minusStock(ItemDto itemDto);
	
	//상품 목록을 리턴해주는 메소드
	public List<ItemDto> getList(ItemDto itemDto);
	
	//상품 재고를 감소 시키는 메소드
	public void minusCount(int item_stock);
	
	//글 추가
	public void insert(ItemDto itemDto);
	
	//글정보 얻어오기
	public ItemDto getData2(int item_idx);
	
	//키워드를 활용한 글정보 얻어오기
	public ItemDto getData(ItemDto itemDto);
	
	// vue category_low 가져오기
	public List<ItemCategoryTopDto> getCategory(int item_category_top_ref);
	
	// vue MyShop 아이템 가져오기
	public List<ItemDto> getMyList(ItemDto dto);
	
	// vue MyShop 글 갯수
	public int getMyCount(ItemDto dto);
	
	// vue GoodsDetail 아이템 정보
	public ItemDto getMyDetail(int item_idx);
	
	// vue getShopCategory 리스트
	public List<ItemDto> getShopCategoryList(ItemDto dto);
	
	// vue getShopCategory 글 갯수
	public int getShopCategoryCount(ItemDto dto);

	// 메인 카테고리 최신 신선 상품 아이템 정보
	public List<ItemDto> getNewList();
	
	// 메인 카테고리 품절 임박 상품 리스트
	public List<ItemDto> getCloseList();
	
	// 메인 카테고리 건강을 위한 채식 상품 리스트
	public List<ItemDto> getVeganList();

}

