package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.dao.LoginDAO;
import kr.co.bit.member.vo.MemberVO;

public class LoginController implements Controller{

		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			//vo객체 생성 및 초기화
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPw(pw);
			
			//DB에서 로그인 수행
			LoginDAO dao = new LoginDAO();
			MemberVO userVO = dao.login(member);
			
			
			String msg = "";
			String url = "";
			
			HttpSession session = request.getSession();
			
			if(userVO == null){
				
				msg = "아이디가 없거나 패스워드가 일치하지 않습니다.";
				url = request.getContextPath() + "/index.do";	
				
				
			} else {
				
				session.setAttribute("userVO",userVO);
				
				switch(userVO.getType()){ 
				case "S" :
					msg = "관리자님 관리 잘해영";
					break;
					
				case "U" :
					msg = userVO.getId() + "님 사슴벌레 넘나좋아행~";
					break;
				}
				
				url = request.getContextPath() + "/index.do";	
				
				
			}
			
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			
			
			return "/login/loginProcess.jsp";
		}

		
	



}
