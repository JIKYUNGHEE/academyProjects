package kr.co.bit.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;

public class ListController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		
		List<BoardVO> list = dao.selectAllBoard();
		
		request.setAttribute("list", list);
		
		// /Mission-Web-MVC01 생략!
		return "/jsp/board/list.jsp";
	}
	
}
