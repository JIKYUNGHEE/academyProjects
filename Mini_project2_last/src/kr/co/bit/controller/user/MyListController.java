package kr.co.bit.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;

public class MyListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		
		// t_board 테이블에서 게시물 목록 조회
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectByIdBoard(id);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 공유영역에 list 객체 등록
		request.setAttribute("list", list);
		
		return "/jsp/mypage/mylist.jsp";
	}

}
