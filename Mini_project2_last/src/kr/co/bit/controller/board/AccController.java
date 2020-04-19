package kr.co.bit.controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;
import kr.co.bit.page.BoardPage;

public class AccController implements Controller {
	
	private int size = 12;
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDAO dao = new BoardDAO();
		String type = "b";
//		request.getParameter("type");
		List<BoardVO> acc = dao.selectBoardByType(type);

		List<BoardFileVO> fAcc = new ArrayList<>();

		for (int i = 0; i < acc.size(); i++) {

			fAcc.add(dao.selectFile(acc.get(i).getNo()).get(0));
			// acc는 타입이 b인 boardVO의 no를 기준으로 file의 list를 불러온다.
			// acc 페이지에서는 대표사진 하나만 필요하므로 그 리스트의 제일 첫번째 fileVO 객체를 받아와서
			// fAcc에 넣어 준 것

		}
		String pageNoVal = request.getParameter("pageNo");

		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}

		int total = dao.selectCountByType(type);
		List<BoardVO> boardList = dao.selectPartBoardByType(type, (pageNo - 1) * size, size);

		BoardPage boardPage = new BoardPage(total, pageNo, size, boardList);

		request.setAttribute("boardPage", boardPage);

//		request.setAttribute("acc", acc);
		request.setAttribute("fAcc", fAcc);

		return "/jsp/board/acc.jsp";
	}

}
