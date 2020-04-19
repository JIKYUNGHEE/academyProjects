package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MBoardDAO;

public class MarketDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 게시물 번호에 해당하는 번호 삭제
		MBoardDAO dao = new MBoardDAO();
		
		int no = Integer.parseInt(request.getParameter("no"));
		dao.del(no);
		dao.fileDel(no);
		
		String msg = "삭제 되었습니다.";
		String url = request.getContextPath()+"/sellList.do";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/marketBoard/marketDelete.jsp";
	}
}
