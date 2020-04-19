package kr.co.bit.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;

public class BoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		

		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectBoard(no);
		dao.updateCount(board);
		board = dao.selectBoard(no);
		

		//첨부파일 조회
		List<BoardFileVO> fileList = dao.selectFile(no);

		//조회수 업데이트 

		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList); 
		
		
		return "/jsp/board/BoardDetail.jsp";
	}

}
