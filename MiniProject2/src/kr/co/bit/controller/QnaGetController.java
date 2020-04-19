package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.qna.dao.QnADAO;
import kr.co.bit.qna.vo.QnAVO;

public class QnaGetController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		QnAVO qna = new QnAVO();

		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content1 = request.getParameter("content1");
		String content2 = request.getParameter("content2");
		
		qna.setWriter(writer);
		qna.setTitle(title);
		qna.setContent1(content1);
		qna.setContent2(content2);
		
		List<QnAVO> list = null;
		
		QnADAO dao = new QnADAO();
		dao.insert_Q(qna);
		list = dao.selectById(writer);
			
		request.setAttribute("list", list);
		
		return "/qnaBoard/qnaGet.jsp";
	}
}