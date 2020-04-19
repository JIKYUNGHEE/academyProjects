package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.TipBoardDAO;

public class TSearchController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String writer = request.getParameter("writer");
		
		TipBoardDAO dao = new TipBoardDAO();
		
		List<TBoardVO> tboard = dao.selectWriter(writer);
		
		request.setAttribute("tboard", tboard);
		
		return "/TBoard/searchList.jsp";
	}

	
	
	
}
