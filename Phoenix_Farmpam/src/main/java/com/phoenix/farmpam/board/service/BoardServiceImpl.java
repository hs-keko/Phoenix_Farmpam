package com.phoenix.farmpam.board.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.board.dao.BoardCommentsDao;
import com.phoenix.farmpam.board.dao.BoardDao;
import com.phoenix.farmpam.board.dto.BoardCommentsDto;
import com.phoenix.farmpam.board.dto.BoardDto;
import com.phoenix.farmpam.exception.NotDeleteException;
import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.item.dto.ItemDto;
import com.phoenix.farmpam.board.dao.LikesDao;
import com.phoenix.farmpam.board.dto.LikesDto;

@Service 
public class BoardServiceImpl implements BoardService{

	@Autowired
	private LikesDao dao;
	
	@Autowired
	private BoardCommentsDao boardCommentsDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardDto likesInsert(LikesDto likesDto) {
		// board 테이블에 해당 게시물의 좋아요 수를 +1 하기위한 BoardDto세팅
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_idx(likesDto.getBoard_idx());
		// DB에서 좋아요 추가 작업을 하고 BoardDto 리턴
		return dao.likesInsert(boardDto, likesDto);
	}

	@Override
	public BoardDto likesDelete(LikesDto likesDto) {
		// board 테이블에 해당 게시물의 좋아요 수를 -1 하기 위한  BoardDto세팅
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_idx(likesDto.getBoard_idx());
		// DB에서 좋아요 삭제 작업을 하고 BoardDto 리턴
		return dao.likesDelete(boardDto, likesDto);
	}
	
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
			}else if(condition.equals("board_title")){ //제목 검색인 경우
				dto.setBoard_title(keyword);
			}else if(condition.equals("board_writer")){ //작성자 검색인 경우
				dto.setBoard_writer(keyword);
			} // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}
		
		//글 목록 얻어오기 
		List<BoardDto> list=boardDao.getList(dto);
		//전체글의 갯수
		int totalRow=boardDao.getCount(dto);

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
		BoardDto dto = boardDao.getData(board_idx);

		mView.addObject("dto", dto);
	}

	@Override
	public void updateContent(BoardDto dto) {
		boardDao.update(dto);
		
	}

	@Override
	public void deleteContent(int board_idx, HttpServletRequest request) {
		//세션에서 로그인된 아이디를 읽어와서
		String users_email=(String)request.getSession().getAttribute("email");
		//삭제할 글의 작성자
		String board_writer=boardDao.getData(board_idx).getBoard_writer();
		//만일 글의 작성자가 로그인된 아이디와 다르다면 
		if(!board_writer.equals(users_email)) {
			//예외를 발생시켜서 응답을 예외 Controller 에서 하도록 한다.
			throw new NotDeleteException("남의 파일 지우기 없기!");
		}
		//본인이 작성한 글이 아니면 아래의 코드가 실행이 안되야 된다. 
		boardDao.delete(board_idx);
		
	}

    //
	@Override
	public void getData(HttpServletRequest request) {
		//수정할 글번호
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		//수정할 글의 정보 얻어와서 
		BoardDto dto=boardDao.getData(board_idx);
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
		List<BoardDto> list = boardDao.getList(dto);
		
		return list;
	}
	

	@Override
	public void insertImage(BoardDto dto, HttpServletRequest request) {
		//dto : caption, imagePath 가지고 있다.
		//dto 에 writer(id) 추가
		dto.setBoard_writer((String)request.getSession().getAttribute("email"));
		
		//GalleryDao 를 이용해서 DB 에 저장하기
		boardDao.insert(dto);
		
	}


	@Override
	public void saveContent(BoardDto dto) {
		//GalleryDao 를 이용해서 DB 에 저장하기
		boardDao.insert(dto);
		
	}

	@Override
	public void saveComment(HttpServletRequest request) {
		//폼 전송되는 파라미터 추출 
		int comments_ref_group=Integer.parseInt(request.getParameter("comments_ref_group"));
		String comments_target_id=request.getParameter("comments_target_id");
		String comments_content=request.getParameter("comments_content");
		/*
		 *  원글의 댓글은 comment_group 번호가 전송이 안되고
		 *  댓글의 댓글은 comment_group 번호가 전송이 된다.
		 *  따라서 null 여부를 조사하면 원글의 댓글인지 댓글의 댓글인지 판단할수 있다. 
		 */
		String comments_group=request.getParameter("comments_group");
		
		//댓글 작성자는 session 영역에서 얻어내기
		String comments_writer=(String)request.getSession().getAttribute("email");
	
		//댓글의 시퀀스 번호 미리 얻어내기
		int seq=boardCommentsDao.getSequence();
		//저장할 댓글의 정보를 dto 에 담기
		BoardCommentsDto dto=new BoardCommentsDto();
		dto.setComments_idx(seq);
		dto.setComments_writer(comments_writer);
		dto.setComments_target_id(comments_target_id);
		dto.setComments_content(comments_content);
		dto.setComments_ref_group(comments_ref_group);
		//원글의 댓글인경우
		if(comments_group == null){
			//댓글의 글번호를 comment_group 번호로 사용한다.
			dto.setComments_group(seq);
		}else{
			//전송된 comment_group 번호를 숫자로 바꾸서 dto 에 넣어준다. 
			dto.setComments_group(Integer.parseInt(comments_group));
		}
		//댓글 정보를 DB 에 저장하기
		boardCommentsDao.insert(dto);
		
	}

	@Override
	public void deleteComment(HttpServletRequest request) {
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		
		BoardCommentsDto dto=boardCommentsDao.getData(board_idx);
		String users_email=(String)request.getSession().getAttribute("email");
		if(!dto.getComments_writer().equals(users_email)) {
			throw new NotDeleteException("남의 댓글 지우면 혼난당!");
		}
		
		boardCommentsDao.delete(board_idx);
		
	}

	@Override
	public void updateComment(BoardCommentsDto dto) {
		boardCommentsDao.update(dto);
	}

	@Override
	public void moreCommentList(HttpServletRequest request) {
		//로그인된 아이디
		String users_email=(String)request.getSession().getAttribute("email");
		//ajax 요청 파라미터로 넘어오는 댓글의 페이지 번호를 읽어낸다
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		//ajax 요청 파라미터로 넘어오는 원글의 글 번호를 읽어낸다
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		/*
			[ 댓글 페이징 처리에 관련된 로직 ]
		*/
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=10;
		
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		//원글의 글번호를 이용해서 해당글에 달린 댓글 목록을 얻어온다.
		BoardCommentsDto commentDto=new BoardCommentsDto();
		commentDto.setComments_ref_group(board_idx);
		//1페이지에 해당하는 startRowNum 과 endRowNum 을 dto 에 담아서  
		commentDto.setStartRowNum(startRowNum);
		commentDto.setEndRowNum(endRowNum);
		
		//pageNum에 해당하는 댓글 목록만 select 되도록 한다. 
		List<BoardCommentsDto> commentList=boardCommentsDao.getList(commentDto);
		//원글의 글번호를 이용해서 댓글 전체의 갯수를 얻어낸다.
		int totalRow=boardCommentsDao.getCount(board_idx);
		//댓글 전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		//view page 에 필요한 값 request 에 담아주기
		request.setAttribute("commentList", commentList);
		request.setAttribute("board_idx", board_idx); //원글의 글번호
		request.setAttribute("pageNum", pageNum); //댓글의 페이지 번호

	}

	@Override
	public void insertContent(BoardDto dto, Map<String, Object> map, HttpServletRequest request) {
		boardDao.insertContent(dto);
		map.put("insertContent", true);
		}

	@Override
	public Map<String, Object> saveBoardImage(HttpServletRequest request, MultipartFile mFile) {
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
	public void getMyList(HttpServletRequest req, Map<String, Object> map) {
		FarmerDto dto = new FarmerDto();
		dto.setFarmer_email(req.getParameter("email"));
		map.put("list",boardDao.getMyList(dto));
	}
}
