package com.phoenix.farmpam.item.controller;

import java.util.List;
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
   public ModelAndView authInsert(ItemDto itemDto, HttpSession session, HttpServletRequest request) {
      //글 작성자는 세션에서 얻어낸다. 
      String farmer_email=(String)session.getAttribute("email");
      //CafeDto 객체에 글 작성자도 담기
      itemDto.setFarmer_email(farmer_email);
      service.insertItem(itemDto);
      
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
   public ModelAndView authUpdate(ItemDto itemDto, HttpServletRequest request) {
      service.updateItem(itemDto);
      return new ModelAndView("item/update");
   }
   
   //삭제하기
   @RequestMapping("/item/private/delete")
   public String delete(@RequestParam int item_idx, HttpServletRequest request) {
      service.deleteItem(item_idx, request);
      return "redirect:/item/private/list.do";
   }
   
   //ajax 요청에 대해 item 목록을 출력할 컨트롤러 메소드 
 	@RequestMapping("/api/item/list")
 	@ResponseBody 
 	public List<ItemDto> getList2(HttpServletRequest request){
 		
 		return service.getList2(request);
 	}
 	
 	//item 게시글의 item_idx 이 parameter get 방식으로 넘어온다.
	//detail 페이지
	@RequestMapping(value = "/item/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mView, @RequestParam int item_idx) {
		//item detail 페이지에 필요한 data를 item_idx 으로 가져와, ModelAndView 에 저장
		service.getDetail(mView, item_idx);
		mView.setViewName("item/detail");
		
		return mView;
	}
	
	// 물품 구매 테스트 페이지 요청
	@RequestMapping("/item/test_buy")
	public String testDetailForm() {
		return "item/test_buy";
	}
	
	
}