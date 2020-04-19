package kr.co.bit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardComVO;
import kr.co.bit.marketBoard.vo.MBoardVO;

public class MarketListController implements Controller {

@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

	// client가 목록을 누르면 DB에 저장된 목록 list로 받음
	MBoardDAO dao = new MBoardDAO();
	
	List<MBoardComVO> marketComlist = new ArrayList<>();	
	marketComlist = dao.selectComAll();
	

	request.setAttribute("marketComlist", marketComlist);
	
	
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
	
	// 답글 list
		MBoardDAO cdao = new MBoardDAO();
	// 해당 페이지의 게시글 목록
	List<MBoardVO> marketList = cdao.selectBoard(pageNo);
	// 전체 게시글 카운트
	int totalCount = cdao.selectBoardCount();
	
	// 한페이지에 보여질 목록 수
	int listSize = 5;
	// 마지막 페이지 구하기
	int lastPage = (totalCount % listSize == 0) ? totalCount / listSize 
			                                    : totalCount / listSize + 1;	
	
	request.setAttribute("pageNo"  , pageNo);
	request.setAttribute("lastPage", lastPage);
//	request.setAttribute("list"    , list);
	request.setAttribute("marketList", marketList);
	request.setAttribute("marketComlist", marketComlist);
	
	
	
	
	
	
	
	
		return "/sellList.jsp";
	}
} 
