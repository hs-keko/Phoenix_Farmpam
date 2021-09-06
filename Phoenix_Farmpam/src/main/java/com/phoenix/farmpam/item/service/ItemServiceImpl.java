package com.phoenix.farmpam.item.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.item.dao.ItemDao;
import com.phoenix.farmpam.item.dao.OrdersDao;
import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.item.dto.OrdersDto;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public void getList(HttpServletRequest request) {
		String farmer_eamil = (String)request.getSession().getAttribute("email");
		ItemDto itemDto = new ItemDto();
		itemDto.setFarmer_email(farmer_eamil);
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
	//목록 얻어오기 
	List<ItemDto> list=itemDao.getList(dto);
	
	//EL + JSTL 에서 사용할 데이터를 request 영역에 담아두기
	request.setAttribute("list", list);
	request.setAttribute("condition", condition);
	request.setAttribute("keyword", keyword);
	request.setAttribute("encodedK", encodedK);
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
		itemDao.insert(dto);	
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
		ItemDto dto = itemDao.getData2(item_idx);
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

	@Override
	public ModelAndView getDetail(HttpServletRequest request, ModelAndView mView) {
		int item_idx=Integer.parseInt(request.getParameter("item_idx"));
		ItemDto itemDto = itemDao.getData2(item_idx);
		mView.addObject("farmer_email", itemDto.getFarmer_email());
		mView.addObject("item_idx", itemDto.getItem_idx());
		mView.addObject("item_title", itemDto.getItem_title());
		mView.addObject("item_price", itemDto.getItem_price());
		mView.addObject("item_stock", itemDto.getItem_stock());
		mView.addObject("item_category_top_idx", itemDto.getItem_category_top_idx());
		mView.addObject("item_content", itemDto.getItem_content());
		mView.addObject("item_image", itemDto.getItem_image());
		return mView;
	}

	@Override
	public ModelAndView insertCart(HttpServletRequest request, ModelAndView mView) {
		// TODO Auto-generated method stub
		return null;
	}
}
