package kr.co.bit.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;
import kr.co.bit.page.BoardPage;

public class BoardListController implements Controller {

	
	private int size = 10;
//	private BoardPage boardPage = null;
	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDAO dao = new BoardDAO();
		String pageNoVal = request.getParameter("pageNo");
		
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		String type = request.getParameter("type");

		int total = dao.selectCountByType(type);
		List<BoardVO> boardList = dao.selectPartBoardByType(type, (pageNo - 1) * size, size);

		BoardPage boardPage = new BoardPage(total, pageNo, size, boardList);
		
		
		request.setAttribute("boardPage", boardPage);
		request.setAttribute("type", type);
		
		return "/jsp/board/BoardList.jsp";
	}

}
