package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;

public class ListMController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectAllBoard();

		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		return "/member/listM.jsp";
	}

}
