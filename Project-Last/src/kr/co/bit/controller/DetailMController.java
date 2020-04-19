package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;

public class DetailMController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.selectById(id);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
	
		
		return "/member/detailM.jsp";
	}

}
