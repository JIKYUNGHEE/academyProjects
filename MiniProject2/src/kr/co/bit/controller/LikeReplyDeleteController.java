package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.like.dao.LikeDAO;
import kr.co.bit.like.vo.ReplyVO;

public class LikeReplyDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		int reply_no = Integer.parseInt(request.getParameter("no"));
		
		int like_no = Integer.parseInt(request.getParameter("like_no"));
		
		LikeDAO dao = new LikeDAO();
		
		dao.deleteReply(reply_no);
		
		List<ReplyVO> replyList = dao.ajaxProcess(like_no);
		request.setAttribute("list", replyList);
		
		//삭제 후 다시 데이터 가져오기
		
		return "/like/likeReply.jsp";
	
	
	}
}
