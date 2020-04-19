package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.walk.dao.WalkDAO;
import kr.co.bit.walk.vo.ReplyVO;


public class WalkReplyDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		
		int walk_no = Integer.parseInt(request.getParameter("walk_no"));
		
		WalkDAO dao = new WalkDAO();
		System.out.println(reply_no);
		dao.deleteReply(reply_no);
		
		List<ReplyVO> replyList = dao.ajaxProcess(walk_no);
		request.setAttribute("list", replyList);
		
		//삭제 후 다시 데이터 가져오기
		
		return "/walk/walkReply.jsp";
	
	
	}
}
