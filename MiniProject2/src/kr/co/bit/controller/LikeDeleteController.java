package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.like.dao.LikeDAO;

public class LikeDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


		int like_no = Integer.parseInt(request.getParameter("like_no"));
		
		LikeDAO dao = new LikeDAO();
		dao.delete(like_no);
		
		
		return "/like/likeUpdateProcess.jsp";
	
	}
	
}
