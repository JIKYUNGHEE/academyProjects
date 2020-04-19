package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.dao.ReplyDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.board.vo.ReplyVO;
import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;

public class DetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		
		//게시물 목록 조회
		BoardVO board = dao.selectByNo(no);
		System.out.println(no);
		
		//첨부파일 조회
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		
		ReplyDAO manager = new ReplyDAO();
		List<ReplyVO> replylist = manager.getReply(no);
		
		
		request.setAttribute("replylist", replylist);	
		
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		return "/freeBoard/freeBoardDetail.jsp";
	}

	
	
}
