package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.TipBoard.vo.TBoardRepVO;
import kr.co.bit.dao.TipBoardDAO;

public class TipReplyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		TBoardRepVO rvo = new TBoardRepVO();
		
		// 글번호에 댓글 저장
		int no = Integer.parseInt(request.getParameter("replyNo"));
		
		rvo.setReplyNo(no);
		rvo.setWriter(request.getParameter("writer"));
		rvo.setContent(request.getParameter("content"));
		
		TipBoardDAO dao = new TipBoardDAO();
		dao.insertRep(rvo);
		
		List<TBoardRepVO> tlist = dao.SelectRepAll(no);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("tRepList", tlist);
		
		return "/TipBoard/detail.jsp";
	}
}
