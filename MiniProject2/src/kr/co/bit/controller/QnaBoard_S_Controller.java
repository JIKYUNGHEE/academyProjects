package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.qna.dao.QnADAO;
import kr.co.bit.qna.vo.QnAVO;

public class QnaBoard_S_Controller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		QnADAO dao = new QnADAO();
				
		List<QnAVO> list = dao.selectAllBoard();	
		
		request.setAttribute("list", list);
		
		return "/qnaBoard/qnaBoard_S.jsp";
	}

}
