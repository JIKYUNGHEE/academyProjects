package kr.co.bit.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.controller.Controller;

public class BoardDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		   request.setCharacterEncoding("utf-8");
		   int no = Integer.parseInt(request.getParameter("no"));
		   
		   BoardDAO dao = new BoardDAO();
		   String type = dao.selectBoard(no).getType();
		   dao.delete(no);
		
		request.setAttribute("type", type);
		request.setAttribute("no", no);
		
		return "/jsp/board/BoardDelete.jsp";
	}

	
}
