package kr.co.bit.controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;

public class BoardUpdateFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		board = dao.selectByNo(no);
		List<BoardFileVO> fileList = new ArrayList<>();
		fileList = dao.selectFile(no);
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		
		return "/jsp/board/boardUpdateForm.jsp";
	}
	
}
