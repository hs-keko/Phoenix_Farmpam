package com.phoenix.farmpam.item.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.exception.NotDeleteException;
import com.phoenix.farmpam.item.dao.CartDao;
import com.phoenix.farmpam.item.dao.ItemDao;
import com.phoenix.farmpam.item.dao.OrdersDao;
import com.phoenix.farmpam.item.dto.CartDto;
import com.phoenix.farmpam.item.dto.ItemCategoryTopDto;
import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public void vueGetMyShop(Map<String, Object> map, HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=9;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=10;
		
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum=request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
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
		

		//특수기호를 인코딩한 키워드를 미리 준비한다. 1
		String encodedK=URLEncoder.encode(keyword);
		
		ItemDto dto = new ItemDto();
			
		//CafeDto 객체에 startRowNum 과 endRowNum 을 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		System.out.println(dto.getStartRowNum());
		System.out.println(dto.getEndRowNum());
		
		
		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("item_title")){ //제목 검색인 경우
				dto.setItem_title(keyword);
			}
		}
		
		// 카테고리 값이 넘어오면
		if(request.getParameter("category_ref") != null) {
			int ref = Integer.parseInt(request.getParameter("category_ref"));
			dto.setItem_category_top_ref(ref);
			List<ItemCategoryTopDto> catelist = itemDao.getCategory(ref);
			map.put("category_low",catelist);
		}
		
		// 세부 카테고리 값이 넘어오면
		if(request.getParameter("category_top_idx") != null) {
			int idx = Integer.parseInt(request.getParameter("category_top_idx"));
			dto.setItem_category_top_idx(idx);
		}
		
		// 판매자 아이디가 넘어오면
		if(request.getParameter("farmer_email") != null) {
			System.out.println(request.getParameter("farmer_email"));
			dto.setFarmer_email(request.getParameter("farmer_email"));
		}
		
		//글 목록 얻어오기 
		List<ItemDto> list = itemDao.getMyList(dto);
		map.put("goodsList", list);
		
		//전체글의 갯수
		int totalRow=itemDao.getMyCount(dto);
		
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		//전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다.
		}
		Map<String, Integer> pagedata = new HashMap<String, Integer>();
		pagedata.put("totalPageCount", totalPageCount);
		pagedata.put("endPageNum", endPageNum);
		pagedata.put("startPageNum", startPageNum);
		
		map.put("pagingData", pagedata);
	}
	
	// vue 아이템 정보 가져오기
	@Override
	public void vueGetInfo(Map<String, Object> map, HttpServletRequest request) {
		// 아이템 번호를 읽어온다.
		int item_idx=Integer.parseInt(request.getParameter("item_idx"));
		// DB에서 아이템 정보를 얻어와서
		ItemDto dto = itemDao.getMyDetail(item_idx);
		map.put("goodsData",dto);
	}
	
	// vue 아이템 리스트 가져오기
	@Override
	public void vueGetMainList(Map<String, Object> map, HttpServletRequest request) {
		
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=9;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=10;
		
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum=request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			System.out.println(strPageNum);
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
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
		

		//특수기호를 인코딩한 키워드를 미리 준비한다. 1
		String encodedK=URLEncoder.encode(keyword);
		
		ItemDto dto = new ItemDto();
			
		//CafeDto 객체에 startRowNum 과 endRowNum 을 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		System.out.println(dto.getStartRowNum());
		System.out.println(dto.getEndRowNum());
		
		
		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("item_title")){ //제목 검색인 경우
				dto.setItem_title(keyword);
			}
		}
		
		// 카테고리 값이 넘어오면
		if(request.getParameter("category_ref") != null) {
			int ref = Integer.parseInt(request.getParameter("category_ref"));
			dto.setItem_category_top_ref(ref);
			List<ItemCategoryTopDto> catelist = itemDao.getCategory(ref);
			map.put("category_low",catelist);
		}
		
		// 세부 카테고리 값이 넘어오면
		if(request.getParameter("category_top_idx") != null) {
			int idx = Integer.parseInt(request.getParameter("category_top_idx"));
			dto.setItem_category_top_idx(idx);
		}
		
		//글 목록 얻어오기 
		List<ItemDto> list=itemDao.getList(dto);
		map.put("goodsList", list);
		
		//전체글의 갯수
		int totalRow=itemDao.getCount(dto);
		
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		//전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다.
		}
		Map<String, Integer> pagedata = new HashMap<String, Integer>();
		pagedata.put("totalPageCount", totalPageCount);
		pagedata.put("endPageNum", endPageNum);
		pagedata.put("startPageNum", startPageNum);
		
		map.put("pagingData", pagedata);
		
		

	}
	
	@Override
	public void getList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=10;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=10;
		
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum=request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
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
		
		//세션을 받아준다.
		String farmer_email = (String)request.getSession().getAttribute("email");
		ItemDto dto = new ItemDto();
		dto.setFarmer_email(farmer_email);
			
		//CafeDto 객체에 startRowNum 과 endRowNum 을 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("item_title")){ //제목 검색인 경우
				dto.setItem_title(keyword);
			}
		}
		//글 목록 얻어오기 
		List<ItemDto> list=itemDao.getListItem(dto);
		//전체글의 갯수
		int totalRow=itemDao.getCount(dto);
		
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		//전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다.
		}
		//view page 에서 필요한 값을 request 에 담아준다. 
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("list", list);
		request.setAttribute("totalRow", totalRow);
		
	}
			
	@Override
	public void updateItem(HttpServletRequest request) {
		
		ItemDto itemDto = new ItemDto();
		
		itemDto.setItem_image((String)request.getParameter("item_image"));
		itemDto.setItem_idx(Integer.parseInt(request.getParameter("item_idx")));
		itemDto.setItem_title((String)request.getParameter("item_title"));
		itemDto.setItem_content((String)request.getParameter("item_content"));
		itemDto.setItem_price(Integer.parseInt(request.getParameter("item_price")));
		itemDto.setItem_stock(Integer.parseInt(request.getParameter("item_stock")));
		
		itemDao.update(itemDto);
	}

	@Override
	public void deleteItem(int item_idx, HttpServletRequest request) {
		itemDao.delete(item_idx); 
		
	}
	
	//새글저장
	@Override
	public void insertItem(ItemDto dto) {
		itemDao.insertItem(dto);	
	}

	@Override
	public Map<String, Object> saveImage(HttpServletRequest request, MultipartFile mFile) {
		//원본 파일명
		String orgFileName=mFile.getOriginalFilename();
		//upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName=System.currentTimeMillis()+orgFileName;
		
		// webapp/upload 폴더까지의 실제 경로 얻어내기 
		String realPath=request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload=new File(realPath);
		if(!upload.exists()) {//만일 존재 하지 않으면
			upload.mkdir(); //만들어준다.
		}
		try {
			//파일을 저장할 전체 경로를 구성한다.  
			String savePath=realPath+File.separator+saveFileName;
			//임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			mFile.transferTo(new File(savePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// json 문자열을 출력하기 위한 Map 객체 생성하고 정보 담기 
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("imagePath", "/upload/"+saveFileName);
		
		return map;
	}

	@Override
	public void getInfo(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		// 아이템 번호를 읽어온다.
		int item_idx=Integer.parseInt(request.getParameter("item_idx"));
		// DB에서 아이템 정보를 얻어와서
		ItemDto dto = itemDao.getData3(item_idx);
		request.setAttribute("dto", dto);
		
	}

	@Override
	public ModelAndView buy(OrdersDto ordersDto, ModelAndView mView) 
	{
		//구입자의 이메일
		String users_email=(String)mView.getModel().get("users_email");
		//1. 파라미터로 전달되는 구입할 상품 번호
		int item_idx=ordersDto.getItem_idx();
		//2. 파라미터로 전달되는 구입할 상품의 수량
		int orders_item_total=ordersDto.getOrders_item_total();
		//3. 파라미터로 전달되는 배송지 주소
		String orders_addr=ordersDto.getOrders_addr();
		//4. 상품의 개당 가격을 얻어온다.
		int item_price=itemDao.getPrice(item_idx);
		//5. (구입 수량*상품의 가격) 만큼 계좌 잔액을 줄인다.
		ItemDto itemDto=new ItemDto();
		itemDto.setUsers_email(users_email);
		int orders_price = item_price * orders_item_total;
		itemDto.setItem_price(orders_price);
		itemDao.minusMoney(itemDto);
		//6. 재고의 갯수를 구입한 수량만큼 줄인다.
		itemDto.setOrders_item_total(orders_item_total);
		itemDao.minusStock(itemDto);
		//7. 주문 테이블에 정보를 추가 한다.
		ordersDto.setItem_price(item_price);
		ordersDto.setOrders_price(orders_price);
		ordersDto.setUsers_email(users_email);
		ordersDao.addOrders(ordersDto);
		return mView;
	}

	//장바구니 담기
	@Override
	public void insertCart(HttpServletRequest request, HttpSession session) {
		//파라미터로 전송된 정보들을 가져오기
		CartDto cartDto = new CartDto();
		int item_idx=Integer.parseInt(request.getParameter("item_idx"));
		int cart_amount=Integer.parseInt(request.getParameter("cart_amount"));
		String users_email=(String)session.getAttribute("email");
		// item_price 가져와서 cart_amount * item_price 값을 cart_price 에 저장
		int item_price=itemDao.getData3(item_idx).getItem_price();
		int cart_price = cart_amount * item_price ;
		//CartDto 에 저장
		cartDto.setItem_idx(item_idx);
		cartDto.setUsers_email(users_email);
		cartDto.setCart_amount(cart_amount);
		cartDto.setCart_price(cart_price);
		// 장바구니 테이블에 저장
		cartDao.insertCart(cartDto);
	}

	//장바구니 목록 불러오기
	@Override
	public void getCartList(HttpSession session, Map<String, Object> map) {
		//세션에서 로그인된 유저 이메일 불러오기
		String users_email = (String)session.getAttribute("email");
		//장바구니 상품 목록을 담을 List
		List<CartDto> list = cartDao.getCartList(users_email);
		//ModelAndView 객체에 list 라는 키값으로 담는다.
		map.put("cartList", list);
		
	}

	//장바구니에서 상품 삭제
	@Override
	public void deleteCart(HttpServletRequest request) {
		int cart_idx=Integer.parseInt(request.getParameter("cart_idx"));
		String users_email=(String)request.getSession().getAttribute("email");
		String cart_users_email=cartDao.getCartEmail(cart_idx);
		
		// 장바구니 테이블 이메일과 세션 이메일 일치 여부
		if(!cart_users_email.equals(users_email)) {
			throw new NotDeleteException("다른 이용자의 장바구니를 삭제할 수 없습니다.");
		}
		
		cartDao.deleteCart(cart_idx);
	}

	//장바구니 구매수량 변경
	@Override
	public void updateCart(HttpServletRequest request, Map<String, Object> map) {
		int cart_idx=Integer.parseInt(request.getParameter("cart_idx"));
		int cart_amount=Integer.parseInt(request.getParameter("cart_amount"));
		int item_price=cartDao.getCartData(cart_idx);
		int cart_price = cart_amount * item_price;
		String users_email=(String)request.getSession().getAttribute("email");
		String cart_users_email=cartDao.getCartEmail(cart_idx);
		
		// 장바구니 테이블 이메일과 세션 이메일 일치 여부
		if(!cart_users_email.equals(users_email)) {
			throw new NotDeleteException("다른 이용자의 구매수량을 변경할 수 없습니다.");
		}
		
		CartDto cartDto=new CartDto();
		cartDto.setCart_idx(cart_idx);
		cartDto.setCart_amount(cart_amount);
		cartDto.setCart_price(cart_price);
		
		cartDao.updateCart(cartDto);
		
		map.put("cart_amount", cart_amount);
		map.put("cart_price", cart_price);
		map.put("isSuccess", true);
	}

	@Override
	public void getDetail(ModelAndView mView, int item_idx) {
		ItemDto itemDto = itemDao.getData2(item_idx);

		mView.addObject("itemDto", itemDto);
		
	}


	@Override
	public List<ItemDto> getList2(HttpServletRequest request) {
		///한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=9;
	
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		//startRowNum 과 endRowNum을 ItemDto 객체에 담고
		ItemDto itemDto = new ItemDto();
		itemDto.setStartRowNum(startRowNum);
		itemDto.setEndRowNum(endRowNum);
	   
		//ItemDao 객체를 이용해서 상품목록을 얻어온다.
		List<ItemDto> list = itemDao.getList(itemDto);
		
		
		return list;
	}


	@Override
	public List<ItemDto> moreItemList(HttpServletRequest request) { 
		int item_category_top_idx=Integer.parseInt(request.getParameter("item_category_top_idx"));
		
		
		//ajax 요청 파라미터로 넘어오는 페이지 번호를 읽어낸다
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=9;
		
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		ItemDto itemDto = new ItemDto();
		itemDto.setStartRowNum(startRowNum);
		itemDto.setEndRowNum(endRowNum);
		
		List<ItemDto> moreList= new ArrayList<>();
		moreList= itemDao.getList(itemDto);
		
		int totalRow=itemDao.getCount(itemDto);
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		moreList.set(totalRow, itemDto);
		moreList.set(totalPageCount, itemDto);
		
		return moreList;
	}

}