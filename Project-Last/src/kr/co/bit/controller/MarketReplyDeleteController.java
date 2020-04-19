package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MBoardDAO;

public class MarketReplyDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MBoardDAO dao = new MBoardDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		
		dao.delRep(no);
		
		String msg = "댓글 삭제 완료";
		
		String url = request.getContextPath()+"/marketDetail.do?no="+reply_no;

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/marketBoard/marketDelete.jsp";
	}

}
