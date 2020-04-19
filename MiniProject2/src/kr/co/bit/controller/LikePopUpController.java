package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.like.dao.LikeDAO;
import kr.co.bit.like.vo.LikeFileVO;
import kr.co.bit.like.vo.LikeVO;
import kr.co.bit.like.vo.ReplyVO;

public class LikePopUpController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int like_no = Integer.parseInt(request.getParameter("like_no"));
		
		LikeVO like = new LikeVO();
		LikeFileVO fileVO = new LikeFileVO();
		
		LikeDAO dao = new LikeDAO();
		like = dao.selectOne(like_no);
		fileVO = dao.selectFileOne(like_no);
		List<ReplyVO> replyList = dao.ajaxProcess(like_no);
		
		request.setAttribute("like", like);
		request.setAttribute("fileVO", fileVO);
		request.setAttribute("reply", replyList);
		
		
		return "/like/likePopUp.jsp";
	
	}
}
