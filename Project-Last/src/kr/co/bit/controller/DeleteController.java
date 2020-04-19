package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.TipBoardDAO;

public class DeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		TipBoardDAO tdao = new TipBoardDAO();
		tdao.deleteByNo(no);
		
		
		return "/TBoard/delete.jsp";
	}
	 

}
