package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardRepVO;
import kr.co.bit.marketBoard.vo.MBoardVO;

public class MarketDetailController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MBoardDAO dao = new MBoardDAO();
		
		int no = Integer.parseInt(request.getParameter("no"));
		// 상세 보기 - 게시글
		MBoardVO bvo = dao.selectDetail(no);
		
		
		System.out.println(no);
		// 상세보기 - 사진파일
		List<TBoardFileVO> tFileList2 = dao.selectTFileByNo(no);
		
		
		// 게시물 번호 받아서 댓글 불러 오기
		List<MBoardRepVO> rlist = dao.SelectRepAll(no);
		
		HttpSession session = request.getSession();
		
		System.out.println(tFileList2);
		
		session.setAttribute("marketDetail", bvo);
		session.setAttribute("tFileList2", tFileList2);
		session.setAttribute("marketRepList", rlist);
		
		return "/marketBoard/marketDetail.jsp";
	}

}
