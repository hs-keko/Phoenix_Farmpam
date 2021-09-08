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

import com.phoenix.farmpam.item.dao.ItemDao;
import com.phoenix.farmpam.item.dto.ItemDto;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	
	@Override
	public List<ItemDto> getList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertItem(ItemDto itemDto) {
		itemDao.insert(itemDto);
		
	}

	@Override
	public void getInfo(HttpServletRequest request, HttpSession session) {
		// 아이템 번호를 읽어온다.
		int item_idx=Integer.parseInt(request.getParameter("item_idx"));
		// DB에서 아이템 정보를 얻어와서
		ItemDto itemDto = itemDao.getData2(item_idx);
		request.setAttribute("itemDto", itemDto);
		
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
	public void updateItem(ItemDto itemDto) {
		itemDao.update(itemDto);
		
	}

	@Override
	public void deleteItem(int item_idx, HttpServletRequest request) {
		itemDao.delete(item_idx); 
		
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
