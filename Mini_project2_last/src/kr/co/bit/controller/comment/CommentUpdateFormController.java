package kr.co.bit.controller.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.CommentVO;
import kr.co.bit.controller.Controller;

public class CommentUpdateFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
				
		String no1 = request.getParameter("no");
		int no = Integer.parseInt(no1);
		BoardDAO dao = new BoardDAO();
		CommentVO comment = dao.selectCommentByNo(no);
		
		request.setAttribute("comment", comment);
		
		
		
		return "/jsp/comment/commentUpdateForm.jsp";
	}

	
}
