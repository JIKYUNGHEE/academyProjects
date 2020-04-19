package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.walk.dao.WalkDAO;
import kr.co.bit.walk.vo.ReplyVO;
import kr.co.bit.walk.vo.WalkFileVO;
import kr.co.bit.walk.vo.WalkVO;


public class WalkDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int walk_no = Integer.parseInt(request.getParameter("walk_no"));
		
		WalkVO walk = null;
		WalkFileVO fileVO = new WalkFileVO();
		
		WalkDAO dao = new WalkDAO();
		walk = dao.selectOne(walk_no);
		fileVO = dao.selectFileOne(walk_no);
		
		List<ReplyVO> replyList = dao.ajaxProcess(walk_no);
		
		System.out.println("뭐야 ,,"+replyList.size());
		
		request.setAttribute("walk", walk);
		request.setAttribute("fileVO", fileVO);
		request.setAttribute("reply", replyList);
		
		
		return "/walk/walkDetail.jsp";
	
	}
}
