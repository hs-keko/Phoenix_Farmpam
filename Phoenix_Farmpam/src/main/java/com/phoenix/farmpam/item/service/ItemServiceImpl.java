package com.phoenix.farmpam.item.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.farmpam.item.dao.ItemDao;
import com.phoenix.farmpam.item.dto.ItemDto;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired 
	private ItemDao dao;

	@Override
	public void getList(HttpServletRequest request) {
		/*
		[ 검색 키워드에 관련된 처리 ]
		-검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.		
	    */
	String keyword=request.getParameter("keyword");
	String condition=request.getParameter("condition");
	//만일 키워드가 넘어오지 않는다면 
	if(keyword==null){
		//키워드와 검색 조건에 빈 문자열을 넣어준다. 
		//클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서  
		keyword="";
		condition=""; 
	}

	//특수기호를 인코딩한 키워드를 미리 준비한다. 
	String encodedK=URLEncoder.encode(keyword);
	
	ItemDto dto=new ItemDto();
	
	//만일 검색 키워드가 넘어온다면 
	if(!keyword.equals("")){
		//검색 조건이 무엇이냐에 따라 분기 하기
		if(condition.equals("item_title")){ //제목 검색인 경우
			dto.setItem_title(keyword);
	}
}
	//파일 목록 얻어오기 
	List<ItemDto> list=dao.getList(dto);
	
	//EL + JSTL 에서 사용할 데이터를 request 영역에 담아두기
	request.setAttribute("list", list);
	request.setAttribute("condition", condition);
	request.setAttribute("keyword", keyword);
	request.setAttribute("encodedK", encodedK);
}

	@Override
	public void updateItem(ItemDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(int num, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
}
