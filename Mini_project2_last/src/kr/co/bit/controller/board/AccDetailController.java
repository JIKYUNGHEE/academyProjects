package kr.co.bit.controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;

public class AccDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		List<BoardFileVO> fileList = new ArrayList<>();
		String no1 = request.getParameter("no");
		int no = Integer.parseInt(no1);
		
		board = dao.selectBoard(no);
		fileList = dao.selectFile(no);
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
			
		return "/jsp/board/accDetail.jsp";
	}

	
}
