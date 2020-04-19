package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.walk.dao.WalkDAO;
import kr.co.bit.walk.vo.ReplyVO;


public class WalkReplyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		int walk_no = Integer.parseInt(request.getParameter("walk_no"));
		String reply_content = request.getParameter("reply_content");
		
		ReplyVO reply = new ReplyVO();
		reply.setId(id);
		reply.setWalk_no(walk_no);
		reply.setReply_content(reply_content);
		
		HttpSession session = request.getSession();
		LoginVO vo = (LoginVO)session.getAttribute("userVO");
		String nickname = vo.getNickname();
		reply.setNickname(nickname);
		
		
		
		WalkDAO dao = new WalkDAO();
		dao.ajaxInsert(reply);
		System.out.println("돌아가고 있니");
		List<ReplyVO> replyList = dao.ajaxProcess(walk_no);
		System.out.println(replyList.get(0).toString());
		
		request.setAttribute("list", replyList);
		
		
		return "/walk/walkReply.jsp";
	}
}
