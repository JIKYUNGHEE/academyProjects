package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MemberDAO;

public class DeleteMController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 	String id = request.getParameter("id");
		 	
		 	MemberDAO dao = new MemberDAO();
		 	dao.delete(id);
	
		return "/member/deleteM.jsp";
	}

}
