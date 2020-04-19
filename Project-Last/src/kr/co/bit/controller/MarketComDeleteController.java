package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MBoardDAO;

public class MarketComDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MBoardDAO dao = new MBoardDAO();
		dao.delCom(Integer.parseInt(request.getParameter("no")));
		
		String msg = "답글 삭제완료";
		String url = request.getContextPath()+"/sellList.do";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/marketBoard/marketDelete.jsp";
	}
}
