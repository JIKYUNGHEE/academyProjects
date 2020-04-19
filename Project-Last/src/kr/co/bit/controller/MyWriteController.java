package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.dao.TipBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardVO;
import kr.co.bit.member.vo.MemberVO;

public class MyWriteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		
		
		 MemberVO memberVO = new MemberVO();
		  memberVO = (MemberVO) session.getAttribute("userVO");
		System.out.println(memberVO);
		
		
		TipBoardDAO dao = new TipBoardDAO();
		MBoardDAO dao2 = new MBoardDAO();
		
		List<TBoardVO> tboard = dao.selectWriter(memberVO.getId());
		List<MBoardVO> mboard = dao2.selectWriter(memberVO.getId());
		
		
		request.setAttribute("tboard", tboard);
		request.setAttribute("mboard", mboard);
		
		return "/mypage.jsp";
	}

}
