package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.TipBoardDAO;

public class TipCommentDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TipBoardDAO dao = new TipBoardDAO();
		dao.delCom(Integer.parseInt(request.getParameter("no")));
		
		String msg = "답글 삭제완료";
		String url = request.getContextPath()+"/tipList.do";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/marketBoard/marketDelete.jsp";
	}
}
