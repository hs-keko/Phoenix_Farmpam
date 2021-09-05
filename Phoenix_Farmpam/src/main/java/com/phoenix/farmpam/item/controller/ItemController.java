package com.phoenix.farmpam.item.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.service.ItemService;
import com.phoenix.farmpam.users.dto.UsersDto;

@Controller
public class ItemController {

	@Autowired
	private ItemService service;
	
	//목록
	@RequestMapping("/item/private/list")
	public String getList(HttpServletRequest request) {
		//글 작성자는 세션에서 얻어낸다. 
		String farmer_email=(String)request.getSession().getAttribute("email");
		//Dto 객체에 글 작성자도 담기
		ItemDto itemDto = new ItemDto();
		itemDto.setFarmer_email(farmer_email);
		service.getList(request);
		return "/item/list";
	}
	
	//새글 저장 폼
	@RequestMapping("/item/private/insertform")
	public String insertForm() {
		return "item/insertform";
	}
	
	//새글 저장 요청 처리 
	@RequestMapping("/item/insert")
	public ModelAndView authInsert(ItemDto dto, HttpSession session, HttpServletRequest request) {
		//글 작성자는 세션에서 얻어낸다. 
		String farmer_email=(String)session.getAttribute("email");
		//CafeDto 객체에 글 작성자도 담기
		dto.setFarmer_email(farmer_email);
		service.insertItem(dto);
		
		return new ModelAndView("item/insert");
	}	
	
	//ajax 사진 업로드 요청처리
	@RequestMapping(value = "/item/private/ajax_image_upload",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ajaxImageUpload(HttpServletRequest request,
					@RequestParam MultipartFile image){
		return service.saveImage(request, image);
	}
	
	//수정폼
	@RequestMapping("/item/private/updateform")
	public ModelAndView updateForm(HttpServletRequest request, HttpSession session) {
		service.getInfo(request, session);
		return new ModelAndView("item/updateform");
	}

	//수정반영 요청처리
	@RequestMapping(value = "/item/update", method = RequestMethod.POST)
	public ModelAndView authUpdate(ItemDto dto, HttpServletRequest request) {
		service.updateItem(dto);
		return new ModelAndView("item/update");
	}
	
	//삭제하기
	@RequestMapping("/item/private/delete")
	public String delete(@RequestParam int item_idx, HttpServletRequest request) {
		service.deleteItem(item_idx, request);
		return "redirect:/item/private/list.do";
	}
	
}