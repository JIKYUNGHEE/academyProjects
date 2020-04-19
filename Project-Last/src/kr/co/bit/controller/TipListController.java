package kr.co.bit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardComVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.TipBoardDAO;

public class TipListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TipBoardDAO dao = new TipBoardDAO();
		
		List<TBoardComVO> tipComList = new ArrayList<>();	
		tipComList = dao.selectComAll();
		
		
		
		// 현재 페이지 번호 저장 변수
				String no = request.getParameter("pageNo");
				
				int pageNo = 1;
				if(no != null)
					pageNo = Integer.parseInt(no);
				try {
					// 페이지 파라미터가 있는 경우 현재 페이지 번호를 설정
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				} catch(Exception e) {
				}
				
				TipBoardDAO bDao = new TipBoardDAO();
				// 해당 페이지의 게시글 목록
				List<TBoardVO> tboard = bDao.selectBoard(pageNo);
				// 전체 게시글 카운트
				int totalCount = bDao.selectBoardCount();
				
				// 한페이지에 보여질 목록 수
				int listSize = 5;
				// 마지막 페이지 구하기
				int lastPage = (totalCount % listSize == 0) ? totalCount / listSize 
						                                    : totalCount / listSize + 1;	
				
				request.setAttribute("pageNo"  , pageNo);
				request.setAttribute("lastPage", lastPage);
//				request.setAttribute("list"    , list);
				request.setAttribute("tboard", tboard);
				request.setAttribute("tipComList", tipComList);
				
			
	
		
		return "/tipList.jsp";
	}

	
	
	
	
}
