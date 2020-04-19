package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardComVO;

public class MarketCommentDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int no = Integer.parseInt(request.getParameter("no"));
		
		MBoardDAO dao = new MBoardDAO();
		
		MBoardComVO mcvo = new MBoardComVO();
		
		mcvo = dao.selectComNo(no);
		
		request.setAttribute("mcvo", mcvo);
		
		return "/marketBoard/marketCommentDetail.jsp";
	}
}
