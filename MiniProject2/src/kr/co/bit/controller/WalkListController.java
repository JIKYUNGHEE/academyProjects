package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.walk.dao.WalkDAO;
import kr.co.bit.walk.vo.WalkFileVO;
import kr.co.bit.walk.vo.WalkVO;

public class WalkListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		WalkDAO dao = new WalkDAO();
		
		
		
		int pageSize = 2; // 한 페이지에 출력할 레코드 수
		// 페이지 링크를 클릭한 번호 / 현재 페이지
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum == null){ // 클릭한게 없으면 1번 페이지
			pageNum = "1";
		}
		
		// 연산을 하기 위한 pageNum 형변환 / 현재 페이지
		int currentPage = Integer.parseInt(pageNum);

		// 해당 페이지에서 시작할 레코드 / 마지막 레코드
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		int count = 0;
		count =dao.getCount(); // 데이터베이스에 저장된 총 갯수
		int pageCount = 0;
		int pageBlock = 0;
		int startPage = 0;
		int endPage = 0;
		List<WalkVO> orderbyList =null;
		if (count > 0) {
			// getList()메서드 호출 / 해당 레코드 반환
			
			orderbyList = dao.getList(startRow, endRow);
			//총 페이지수
			pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
			// 한 페이지에 보여줄 페이지 버튼 블럭(링크) 수
			pageBlock = 4;
			// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
			startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			endPage = startPage + pageBlock - 1;
		}
		
		request.setAttribute("count", count);	//릴레이션에 저장된 로우(보드개수)
		request.setAttribute("currentPage", currentPage);	// 현재 페이지
		request.setAttribute("orderbyList", orderbyList);	// 보드객체가 포함된 리스트
		request.setAttribute("startRow", startRow);	//현재페이지의 처음 보드번호
		request.setAttribute("endRow", endRow);	// 현재페이지의 마지막 보드번호
		request.setAttribute("pageSize", pageSize); // 한 페이지의 담을 보드 개수 9개
		request.setAttribute("pageCount", pageCount);  // 만들어져야할 페이지 수
		request.setAttribute("pageBlock", pageBlock); // 한 화면에 보여질 페이징버튼 수 4개 
		request.setAttribute("startPage", startPage); // 한 화면에 보여질 시작버튼 번호
		request.setAttribute("endPage", endPage);	// 한 화면에 보여질 마지막버튼 번호
			
			
		
		
		List<WalkFileVO> fileList = dao.selectFileAll();
		
		request.setAttribute("fileList", fileList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "/walk/walk.jsp";
	}

}
