package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardVO;

public class MarketUpdateController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MBoardDAO mDao = new MBoardDAO();
		MBoardVO mvo = new MBoardVO();
		// no 에 해당하는 게시글 가져오기
		mvo = mDao.selectBoardByNo(no);
		System.out.println(no);
		
		// no에 해당하는 게시글 사진파일 받아오기
		List<TBoardFileVO> mFileList2 = mDao.selectTFileByNo(no);
		
		System.out.println("마켓업데이트 파일불러옴" + mFileList2);
		request.setAttribute("mvo", mvo);
		request.setAttribute("mFileList2", mFileList2);
		
		
		return "/marketBoard/marketReWrite.jsp";
	}
		
	

}
