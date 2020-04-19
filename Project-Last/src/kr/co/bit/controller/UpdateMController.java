package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;

public class UpdateMController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
	 	String id = request.getParameter("id");
	 	String pw = request.getParameter("pw");
	 	String tel = request.getParameter("tel");
	 	String addr = request.getParameter("addr");
	 	int point = Integer.parseInt(request.getParameter("point"));
	 	String grade = request.getParameter("grade");
	 	
	 	MemberDAO dao = new MemberDAO();
	 	MemberVO member = new MemberVO();
	 	
	 	member.setId(id);
	 	member.setPw(pw);
	 	member.setTel(tel);
	 	member.setAddr(addr);
	 	member.setPoint(point);
	 	member.setGrade(grade);
	 	
	 	// 업뎃
	 	dao.updateM(member);
	 	MemberVO userVO = new MemberVO();
	    userVO	= dao.selectById(member.getId());
	 	
	 	//세션 등록
	 	HttpSession session = request.getSession();
	 	session.setAttribute("userVO", userVO);
	 	
		return "member/updateMProcess.jsp";
	}

}
