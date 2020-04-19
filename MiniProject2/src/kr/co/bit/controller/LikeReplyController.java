package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.like.dao.LikeDAO;
import kr.co.bit.like.vo.ReplyVO;
import kr.co.bit.login.vo.LoginVO;

public class LikeReplyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		int like_no = Integer.parseInt(request.getParameter("like_no"));
		String content = request.getParameter("content");
		
		ReplyVO reply = new ReplyVO();
		reply.setId(id);
		reply.setLike_no(like_no);
		reply.setContent(content);
		HttpSession session = request.getSession();
		LoginVO vo = (LoginVO)session.getAttribute("userVO");
		System.out.println("vo "+vo);
		String nickname = vo.getNickname();
		
		reply.setNickname(nickname);
		LikeDAO dao = new LikeDAO();
		
		dao.ajaxInsert(reply);
		List<ReplyVO> replyList = dao.ajaxProcess(like_no);
		//System.out.println(replyList.get(0).toString());
		request.setAttribute("list", replyList);
		
		
		return "/like/likeReply.jsp";
	}
}
