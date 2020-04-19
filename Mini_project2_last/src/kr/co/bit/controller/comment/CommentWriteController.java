package kr.co.bit.controller.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.CommentVO;
import kr.co.bit.controller.Controller;

public class CommentWriteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String no1 = request.getParameter("no");
		int no = Integer.parseInt(no1);
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		CommentVO comment = new CommentVO();
		
		comment.setBoardNo(no);
		comment.setWriter(writer);
		comment.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.insertComment(comment);
		
		
		return "/jsp/board/infoDetail.jsp?no=${ param.no }";
	}

	
}
