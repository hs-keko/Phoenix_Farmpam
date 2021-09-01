package com.phoenix.farmpam.users.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phoenix.farmpam.farmer.dto.FarmerDto;
import com.phoenix.farmpam.users.dao.UsersDao;
import com.phoenix.farmpam.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao dao;
	
	@Override
	public Map<String, Object> isExistEmail(String inputUsersEmail) {
		//Map 객체 생성
		Map<String, Object> map=new HashMap<String, Object>();
		//isExist라는 키값으로 이메일이 존재하는지 여부를 담는다
		map.put("isExist", dao.isExist(inputUsersEmail));
		//map 객체 리턴
		return map;
	}

	@Override
	public void addUser(UsersDto dto) {
		// 사용자가 입력한 비밀번호 읽어오기
		String users_pwd=dto.getUsers_pwd();
		//암호화 하고
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(users_pwd);
		//dto에 넣어주기
		dto.setUsers_pwd(encodedPwd);

		dao.insert(dto);
		
	}

	@Override
	public void loginProcess(UsersDto dto, HttpSession session) {
		//입력한 정보가 맞는여부
		boolean isValid=false;
		
		//1. 로그인 폼에 입력한 아이디를 이용해서 해당 정보를 select 해 본다. 
		UsersDto result=dao.getData(dto.getUsers_email());
		if(result != null) {//만일 존재하는 아이디 라면
			//비밀번호가 일치하는지 확인한다.
			String encodedPwd=result.getUsers_pwd(); //DB 에 저장된 암호화된 비밀번호 
			String inputUsersPwd=dto.getUsers_pwd(); //로그인폼에 입력한 비밀번호
			//Bcrypt 클래스의 static 메소드를 이용해서 일치 여부를 얻어낸다.
			isValid=BCrypt.checkpw(inputUsersPwd, encodedPwd);
		}
		
		if(isValid) {//만일 유효한 정보이면 
			//로그인 처리를 한다.
			session.setAttribute("email", dto.getUsers_email());
		}
	}

	@Override
	public void getInfo(HttpSession session, ModelAndView mView) {
		// 로그인된 이메일을 읽어온다.
		String users_email=(String)session.getAttribute("email");
		// DB에서 회원 정보를 얻어와서
		UsersDto dto = dao.getData(users_email);
		// ModelAndView 객체에 담아준다.
		mView.addObject("dto", dto);
		
	}

	@Override
	public void checkbox(UsersDto dto, HttpSession session) {
		System.out.println(dao.getData(dto.getUsers_email()).getUsers_chk());
			if(dao.getData(dto.getUsers_email()).getUsers_chk().equals("0")) {
			session.setAttribute("check", "chk_common");
		}
	}

	@Override
	public void updateUsersPwd(HttpSession session, UsersDto dto, ModelAndView mView) {
		// 세션 영역에서 로그인된 아이디 읽어오기
		String email=(String)session.getAttribute("email");
		//DB에 저장된 회원정보 얻어오기
		UsersDto resultDto=dao.getData(email);
		//DB에 저장된 암호화된 비밀번호
		String encodedPwd=resultDto.getUsers_pwd();
		//클라이언트가 입력한 비밀번호
		String inputUsersPwd=dto.getUsers_pwd();
		//두 비밀번호가 일치하는지 확인하기
		boolean isValid=BCrypt.checkpw(inputUsersPwd, encodedPwd);
		
		//만일 일치할 경우
		if(isValid) {
			//새로운 비밀번호를 암호화한다.
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedUsersNewPwd = encoder.encode(dto.getUsers_newPwd());
			//암호화된 비밀번호를 dto에 다시 넣어준다.
			dto.setUsers_newPwd(encodedUsersNewPwd);
			//dto에 로그인된 이메일도 넣어주자.
			dto.setUsers_email(email);
			//dao를 이용하여 db에 수정반영한다.
			dao.updateUsersPwd(dto);
			//로그아웃 처리
			session.removeAttribute("email");
		}
		//작업의 성공여부를 ModelAndView 객체에 담는다 (HttpServletRequest에 담긴다)
		mView.addObject("isSuccess", isValid);
		//로그인된 이메도 담아준다
		mView.addObject("email", email);
	}

	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {
		// 업로드된 파일에 대한 정보를 MultipartFile 객체를 이용해서 얻어낼 수 있다.
		
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
	public void updateUser(UsersDto dto, HttpSession session) {
		// 수정할 회원의 아이디
		String email=(String)session.getAttribute("email");
		//UsersDao에 아이디를 담아준다.
		dto.setUsers_email(email);
		//만일 프로필 사진을 수정하지 않았다면
		if(dto.getUsers_profile().equals("empty")) {
			//My Batis에서 null을 바인딩하면 오류가 나기 때문에 빈 문자열을 넣어준다.
			dto.setUsers_profile("");
		}
		//usersDao에서 수정반영한다.
		dao.update(dto);
	}

	@Override
	public void deleteUser(HttpSession session, ModelAndView mView) {
		// 로그인된 이메일을 얻어와서
		String email=(String)session.getAttribute("email");
		//해당 정보를 DB에서 삭제하고
		dao.delete(email);
		//로그아웃 처리도 한다.
		session.removeAttribute("email");
		//ModelAndView 객체에 탈퇴한 회원의 이메일을 담아준다.
		mView.addObject("email", email);

	}
}
