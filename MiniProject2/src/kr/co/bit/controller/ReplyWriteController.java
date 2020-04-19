package kr.co.bit.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.ReplyDAO;
import kr.co.bit.board.vo.ReplyVO;

public class ReplyWriteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 댓글 목록을 db로 부터 구해옴
		
		//넘어온 데이터를 저장
		ReplyVO reply = new ReplyVO();
		reply.setBoard_no(Integer.parseInt(request.getParameter("no")));
		reply.setId(request.getParameter("id"));
		reply.setReply_content(request.getParameter("reply_content"));
			
		
		// db 저장을 위한 dao에 데이터 전달
		ReplyDAO manager = new ReplyDAO();
		manager.insertReply(reply);
		
		List<ReplyVO> list = manager.getReply(Integer.parseInt(request.getParameter("no")));
		
		request.setAttribute("list", list);
					
	      
		
	      return "/freeBoard/reply.jsp";
	}

}
