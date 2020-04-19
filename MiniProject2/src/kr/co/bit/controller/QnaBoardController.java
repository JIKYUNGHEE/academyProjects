package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.qna.dao.QnADAO;
import kr.co.bit.qna.vo.QnAVO;

public class QnaBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		LoginVO userVO = (LoginVO)session.getAttribute("userVO");
		
		String writer = null;
		
		QnADAO dao = new QnADAO();
		List<QnAVO> list = null;
		
		if(userVO != null) {
			writer = userVO.getId();
		}
		
		System.out.println(userVO.getType());
		
		if(userVO.getType().equals("S") || userVO.getType() == "S") {// 관리자일 때 모든 q&a 가져옴
			list = dao.selectAllBoard();
		}else {
			list = dao.selectById(writer);	// user일 때 자신이 작성한 q&a 가져옴
		}
		
		request.setAttribute("list", list);
		
		return "/qnaBoard/qnaBoard.jsp";
	}
}