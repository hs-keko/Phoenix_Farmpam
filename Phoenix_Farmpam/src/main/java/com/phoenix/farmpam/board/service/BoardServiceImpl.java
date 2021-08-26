package com.phoenix.farmpam.board.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.board.dao.BoardDao;
import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.exception.NotDeleteException;

@Service 
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	
	@Override
	public void getList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=6;
		
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
			
		//BoardDto 객체에 startRowNum 과 endRowNum 을 담는다.
		BoardDto dto=new BoardDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("title_content")){//제목 + 내용 검색인 경우
				//검색 키워드를 CafeDto 에 담아서 전달한다.
				dto.setBoard_title(keyword);
				dto.setBoard_content(keyword);
			}else if(condition.equals("title")){ //제목 검색인 경우
				dto.setBoard_title(keyword);
			}else if(condition.equals("writer")){ //작성자 검색인 경우
				dto.setBoard_writer(keyword);
			} // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}
		//글 목록 얻어오기 
		List<BoardDto> list=dao.getList(dto);
		//전체글의 갯수
		int totalRow=dao.getCount(dto);

		//전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		//view page 에서 필요한 값을 request 에 담아준다. 
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startRowNum", startRowNum);
		request.setAttribute("endRowNum", endRowNum);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("list", list);
		request.setAttribute("totalRow", totalRow);
	}

	//Board detail 페이지에 필요한 data를 ModelAndView 에 저장
	@Override
	public void getDetail(ModelAndView mView, int board_idx) {
		//dao 로 해당 게시글 num 에 해당하는 데이터(dto)를 가져온다.
		BoardDto dto = dao.getData(board_idx);
		//ModelAndView 에 가져온 GalleryDto 를 담는다.
		mView.addObject("dto", dto);
	}

	@Override
	public void updateContent(BoardDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void deleteContent(int board_idx, HttpServletRequest request) {
		//세션에서 로그인된 아이디를 읽어와서
		String id=(String)request.getSession().getAttribute("id");
		//삭제할 글의 작성자
		String writer=dao.getData(board_idx).getBoard_writer();
		//만일 글의 작성자가 로그인된 아이디와 다르다면 
		if(!writer.equals(id)) {
			//예외를 발생시켜서 응답을 예외 Controller 에서 하도록 한다.
			throw new NotDeleteException("남의 파일 지우기 없기!");
		}
		//본인이 작성한 글이 아니면 아래의 코드가 실행이 안되야 된다. 
		dao.delete(board_idx);
		
	}

    //
	@Override
	public void getData(HttpServletRequest request) {
		//수정할 글번호
		int num=Integer.parseInt(request.getParameter("board_idx"));
		//수정할 글의 정보 얻어와서 
		BoardDto dto=dao.getData(num);
		//request 에 담아준다.
		request.setAttribute("dto", dto);
		
	}

	@Override
	public List<BoardDto> getList2(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=6;
	
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
	   
		//startRowNum 과 endRowNum  을 GalleryDto 객체에 담고
		BoardDto dto = new BoardDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		//GalleryDao 객체를 이용해서 회원 목록을 얻어온다.
		List<BoardDto> list = dao.getList(dto);
		
		return list;
	}
	
	//이미지 ajax upload
	@Override
	public Map<String, Object> uploadAjaxImage(BoardDto dto, HttpServletRequest request) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값을 얻어오기
		MultipartFile image = dto.getImage();
		//원본 파일명 -> 저장할 파일 이름 만들기위해서 사용됨
		String orgFileName = image.getOriginalFilename();
		//파일 크기
		long fileSize = image.getSize();
		
		// webapp/upload 폴더 까지의 실제 경로(서버의 파일 시스템 상에서의 경로)
		String realPath = request.getServletContext().getRealPath("/upload");
		//db 에 저장할 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if(!upload.exists()) {
			//만약 디렉토리가 존재하지X
			upload.mkdir();//폴더 생성
		}
		//저장할 파일의 이름을 구성한다. -> 우리가 직접 구성해줘야한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		
		try {
			//upload 폴더에 파일을 저장한다.
			image.transferTo(new File(filePath + saveFileName));
			System.out.println();	//임시 출력
		}catch(Exception e) {
			e.printStackTrace();
		}

		String imagePath = "/upload/" + saveFileName;
		
		//ajax upload 를 위한 imagePath return
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imagePath", imagePath);
		
		return map;
	}

	@Override
	public void insertImage(BoardDto dto, HttpServletRequest request) {
		//dto : caption, imagePath 가지고 있다.
		//dto 에 writer(id) 추가
		dto.setBoard_writer((String)request.getSession().getAttribute("id"));
		
		//GalleryDao 를 이용해서 DB 에 저장하기
		dao.insert(dto);
		
	}


	@Override
	public void saveContent(BoardDto dto, HttpServletRequest request) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값을 얻어오기
		MultipartFile image = dto.getImage();
		//원본 파일명 -> 저장할 파일 이름 만들기위해서 사용됨
		String orgFileName = image.getOriginalFilename();
		//파일 크기 -> 다운로드가 없으므로, 여기서는 필요 없다.
		long fileSize = image.getSize();
		
		// webapp/upload 폴더 까지의 실제 경로(서버의 파일 시스템 상에서의 경로)
		String realPath = request.getServletContext().getRealPath("/upload");
		//db 에 저장할 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if(!upload.exists()) {
			//만약 디렉토리가 존재하지X
			upload.mkdir();//폴더 생성
		}
		//저장할 파일의 이름을 구성한다. -> 우리가 직접 구성해줘야한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		
		try {
			//upload 폴더에 파일을 저장한다.
			image.transferTo(new File(filePath + saveFileName));
			System.out.println();	//임시 출력
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//dto 에 업로드된 파일의 정보를 담는다.
		//-> parameer 로 넘어온 dto 에는 caption, image 가 들어 있었다.
		//-> 추가할 것 : writer(id), imagePath 만 추가로 담아주면 된다.
		//-> num, regdate : db 에 추가하면서 자동으로 들어감
		String id = (String)request.getSession().getAttribute("id");
		dto.setBoard_writer(id);
		//gallery 는 사진 다운 기능이 없다. -> orgFileName, saveFileName, fileSize 저장할 필요X
		//imagePath 만 저장해주면 됨
		dto.setBoard_image("/upload/" + saveFileName);
		
		//GalleryDao 를 이용해서 DB 에 저장하기
		dao.insert(dto);
		
	}
	
	

}
