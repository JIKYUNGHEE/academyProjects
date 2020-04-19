package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class FreeBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		// 페이징
		int currentPage;// 현재 페이지 번호
		String num = request.getParameter("pageNum");
		
		if (num!=null  && !num.trim().equals("")) {
			currentPage = Integer.parseInt(num);
		}else {
			num = "1";
			currentPage=1;
		}
		
		int pageSize = 10;	// 한 페이지에 출력할 게시물 수-->지정하기
		// 해당 페이지에서 시작할 레코드 / 마지막 레코드
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		
		int pageCount = 0;
		
		BoardDAO dao = new BoardDAO();
		int count = dao.getCount();
		
		List<BoardVO> list = null;
		
		if (count > 0) {
			// getList()메서드 호출 / 해당 레코드 반환
			list = dao.getList(startRow, endRow);
			pageCount = count / pageSize + ((count % pageSize == 0) ? 0 : 1);
		}
		
		int pageBlock = 5;// pageBlock 수--> 수정해
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;// page 시작번호 및 끝 번호
		int endPage = startPage + pageBlock - 1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		
		/*List<BoardVO> list = dao.selectAllBoard();*/
		
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
        request.setAttribute("list", list);
        
		System.out.println("list :"+list);
		return "/freeBoard/freeBoardList.jsp";
	}
}




