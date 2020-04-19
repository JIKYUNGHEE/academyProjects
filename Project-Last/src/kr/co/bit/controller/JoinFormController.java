package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.JoinDAO;
import kr.co.bit.member.vo.MemberVO;

public class JoinFormController  implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 파라미터 넘기기
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		// 객체생성	
		JoinDAO dao = new JoinDAO();
		MemberVO member = new MemberVO(); 
		//VO에 파라미터값 세팅
		
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setTel(tel);
		member.setAddr(addr);
		
	
		
		dao.join(member);
		
		return "/login/joinAlert.jsp" ;
		
	}

}
