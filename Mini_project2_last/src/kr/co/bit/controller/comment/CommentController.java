package kr.co.bit.controller.comment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.CommentVO;
import kr.co.bit.controller.Controller;

public class CommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDAO dao = new BoardDAO();
		String no1 = request.getParameter("no");
		int no = Integer.parseInt(no1);
		
		List<CommentVO> list = new ArrayList<>();
		list = dao.selectAllCommentByNo(no);
		
		request.setAttribute("list", list);
		
		return "/jsp/comment/comment.jsp";
	}

	
}
