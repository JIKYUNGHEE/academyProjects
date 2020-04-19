package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.dao.ReplyDAO;
import kr.co.bit.board.vo.ReplyVO;

public class ReplyDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : " + no);
		
		ReplyDAO dao = new ReplyDAO();	 	
	 	dao.delete(no);	
	 	
	 	int board_no = Integer.parseInt(request.getParameter("board_no"));
	 	System.out.println("board_no : " + board_no);
		List<ReplyVO> list = dao.getReply(board_no);		
		
		request.setAttribute("list", list);
		
		return "/freeBoard/reply.jsp";
	}

}
