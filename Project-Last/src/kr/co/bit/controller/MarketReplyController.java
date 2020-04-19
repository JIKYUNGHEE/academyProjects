package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardRepVO;

public class MarketReplyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		MBoardRepVO rvo = new MBoardRepVO();
		int no = Integer.parseInt(request.getParameter("replyNo"));
		
		rvo.setReplyNo(no);
		rvo.setWriter(request.getParameter("writer"));
		rvo.setContent(request.getParameter("content"));
		
		MBoardDAO dao = new MBoardDAO();
		dao.insertRep(rvo);
		
		List<MBoardRepVO> rlist = dao.SelectRepAll(no);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("marketRepList", rlist);
		
		return "/marketBoard/marketDetail.jsp";
	}
}
