package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;

public class DeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
	
		BoardDAO dao = new BoardDAO();	 	
	 	dao.delete(no);
	 	
		return "/freeBoard/freeBoardDelete.jsp";
	}

}
