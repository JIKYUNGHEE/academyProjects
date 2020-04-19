package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.TipBoardDAO;

public class ReWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		 넘버 받아서 db에서 글 vo 로받아오기
		
	
		int no = Integer.parseInt(request.getParameter("no"));
		
		TipBoardDAO tDao = new TipBoardDAO();
		TBoardVO tvo = new TBoardVO();
		// no 에 해당하는 게시글 가져오기
		tvo = tDao.selectBoardByNo(no);
		
		
		// no에 해당하는 게시글 사진파일 받아오기
		List<TBoardFileVO> tFileList = tDao.selectTFileByNo(no);
		
		
		request.setAttribute("tvo", tvo);
		request.setAttribute("tFileList", tFileList);
		
		
		return "/TBoard/reWrite.jsp";
	}

}
