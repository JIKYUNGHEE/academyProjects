package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.dao.TipBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardVO;

public class IndexController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		

		TipBoardDAO dao = new TipBoardDAO();
		List<TBoardVO> tboard = dao.selectAll();

		MBoardDAO dao2 = new MBoardDAO();
		List<MBoardVO> mboard = dao2.selectAll();
		
		
		
		
		request.setAttribute("tboard", tboard);
		request.setAttribute("mboard", mboard);
		
		
		
		return "/index.jsp";
	}

	
	
}
