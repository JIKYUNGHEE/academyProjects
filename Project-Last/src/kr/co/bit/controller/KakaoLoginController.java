package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.dao.LoginDAO;
import kr.co.bit.member.vo.MemberVO;

public class KakaoLoginController  implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		  
	      String id = request.getParameter("id");
	      String password = request.getParameter("password");
	      String name = request.getParameter("name");
	     
	      
	      MemberVO memberVO = new MemberVO();
	      memberVO.setId(id);
	      memberVO.setPw(password);
	      memberVO.setName(name);
	      
	      LoginDAO dao = new LoginDAO();
	      MemberVO loginVO = dao.login(memberVO);
	      
	      String msg="";
	      String url ="";
	            
	      if(loginVO == null) {
	         msg = "초기 로그인 시 추가 입력 페이지로 넘어갑니다";
	         url = request.getContextPath() + "/kakaoJoin.do?id=" + id + "&password=" + password + "&name=" + name ;
	      }else {
	         HttpSession session = request.getSession();
	         session.setAttribute("userVO", loginVO);
	         
	         msg = loginVO.getId() + "님 환영합니다";
	         url = request.getContextPath() + "/index.jsp";
	      }
	      
	      request.setAttribute("msg", msg);
	      request.setAttribute("url", url);
	      
	      return "/login/loginProcess.jsp";

	}

}
