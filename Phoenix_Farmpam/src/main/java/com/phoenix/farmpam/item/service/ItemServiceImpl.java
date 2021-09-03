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
import com.phoenix.farmpam.item.dto.ItemDto;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired 
	private ItemDao itemDao;

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
	public void updateItem(ItemDto dto, HttpSession session) {
		// 수정할 item에 아이템 번호를 적어주고
		int item_idx=(int)session.getAttribute("item_idx");
		//itemDto에 번호 담아주기
		dto.setItem_idx(item_idx);
		//만일 사진을 수정하지 않았으면
		if(dto.getItem_image().equals("empty")) {
			dto.setItem_image("");
		}
		//ItemDao를 이용해 수정 반영한다.
		itemDao.update(dto);
	}

	@Override
	public void deleteItem(int num, HttpServletRequest request) {
		// TODO Auto-generated method stub 
		
	}

	@Override
	public void insertItem(ItemDto dto, HttpServletRequest request) {
		//dto 에 업로드된 파일의 정보를 담는다.
		//-> parameer 로 넘어온 dto 에는 caption, image 가 들어 있었다.
		//-> 추가할 것 : writer(id), imagePath 만 추가로 담아주면 된다.
		//-> num, regdate : db 에 추가하면서 자동으로 들어감
		String farmer_eamil = (String)request.getSession().getAttribute("email");
		dto.setFarmer_email(farmer_eamil);
		
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
	public void getInfo(HttpSession session, ModelAndView mView) {
		// TODO Auto-generated method stub
		// 아이템 번호를 읽어온다.
		String farmer_email=(String)session.getAttribute("email");
		// DB에서 아이템 정보를 얻어와서
		ItemDto dto = itemDao.getData(farmer_email);
		// modelAndView에 담기
		mView.addObject("dto", dto);
		
	}

}
