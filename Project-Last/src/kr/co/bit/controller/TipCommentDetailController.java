package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardComVO;
import kr.co.bit.dao.TipBoardDAO;

public class TipCommentDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int no = Integer.parseInt(request.getParameter("no"));
		
		TipBoardDAO dao = new TipBoardDAO();
		
		TBoardComVO tcvo = new TBoardComVO();
		
		tcvo = dao.selectComNo(no);
		
		request.setAttribute("tcvo", tcvo);
		
		return "/TBoard/tipCommentDetail.jsp";
	}
}
