package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.TipBoardDAO;

public class DetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
	
		
		TipBoardDAO tDao = new TipBoardDAO();
		TBoardVO tvo = new TBoardVO();
		// no 에 해당하는 게시글 가져오기
		tvo = tDao.selectBoardByNo(no);
		
		
		// viewCnt +1 
				int viewNo = tvo.getViewCnt()+1;
				tDao.viewCntPlus(no, viewNo);
		
		// no 에 해당하는 게시글 가져오기
		tvo = tDao.selectBoardByNo(no);
		
		// no에 해당하는 게시글 사진파일 받아오기
		List<TBoardFileVO> tFileList = tDao.selectTFileByNo(no);
		System.out.println("no : " + no);
		
		
		HttpSession session = request.getSession();
		
		System.out.println("tFileList : " + tFileList);
		
		session.setAttribute("tvo", tvo);
		session.setAttribute("tFileList", tFileList);
		
		
		return "/TBoard/detail.jsp";
	}
	

}
