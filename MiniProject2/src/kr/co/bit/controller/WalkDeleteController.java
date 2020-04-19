package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.walk.dao.WalkDAO;


public class WalkDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


		int walk_no = Integer.parseInt(request.getParameter("walk_no"));
		
		WalkDAO dao = new WalkDAO();
		dao.delete(walk_no);
		
		
		return "/walk/walkUpdateProcess.jsp";
	
	}
	
}
