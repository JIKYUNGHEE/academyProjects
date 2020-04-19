package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardComVO;

/**
 * 답글 게시판
 * 
 * */
public class MarketCommentController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int comNo = Integer.parseInt(request.getParameter("no"));
		
		MBoardComVO mcvo = new MBoardComVO();
		mcvo.setCommentNo(comNo);
		mcvo.setTitle(request.getParameter("title"));
		mcvo.setContent(request.getParameter("content"));
		mcvo.setWriter(request.getParameter("writer"));
	
		MBoardDAO dao = new MBoardDAO();
		dao.insertCom(mcvo);
		
		String msg = "답글 등록 완료";
		String url = "/sellList.do?comNo="+comNo;
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);
		
		return "/marketBoard/marketWriteForm.jsp";
	}
}
