package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;



public class MypageController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		
		MemberDAO dao = new MemberDAO();
		userVO = dao.selectById(userVO.getId());
		
		
		
		
		request.setAttribute("userVO", userVO);
		
		
		
		
		return "/mypage.jsp";
	}

}
