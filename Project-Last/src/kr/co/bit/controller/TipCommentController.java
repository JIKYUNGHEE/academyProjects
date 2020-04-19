package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardComVO;
import kr.co.bit.dao.TipBoardDAO;

public class TipCommentController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int comNo = Integer.parseInt(request.getParameter("no"));
		
		TBoardComVO tcvo = new TBoardComVO();
		tcvo.setCommentNo(comNo);
		tcvo.setTitle(request.getParameter("title"));
		tcvo.setContent(request.getParameter("content"));
		tcvo.setWriter(request.getParameter("writer"));
	
		TipBoardDAO dao = new TipBoardDAO();
		dao.insertCom(tcvo);
		
		String msg = "답글 등록 완료";
		String url = "/tipList.do?comNo="+comNo;
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);
		
		return "/marketBoard/marketWriteForm.jsp";
		
	}
}
