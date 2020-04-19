package kr.co.bit.controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;

public class InfoDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		List<BoardFileVO> fileList = new ArrayList<>();
		String no1 = request.getParameter("no");
		int no = Integer.parseInt(no1);
		
		board = dao.selectBoard(no);
		fileList = dao.selectFile(no);
		BoardFileVO file = fileList.get(0);
		//infoDetail에서 보여줄 사진은 하나로 고정해 주기 위해 객체 하나만 넘긴다.
		// 입력은 두개까지 가능한데  하나만 입력가능하게 하거나 사진을 여러개 나와도 되게 추후 업데이트가 필요함.
		
		request.setAttribute("board", board);
		request.setAttribute("file", file);
		
		
		return "/jsp/board/infoDetail.jsp";
	}

	
}
