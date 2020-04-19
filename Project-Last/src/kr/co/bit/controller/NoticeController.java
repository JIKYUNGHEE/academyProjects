package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.NoticeDAO;
import kr.co.bit.notice.vo.NoticeVO;

public class NoticeController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		NoticeDAO dao = new NoticeDAO();
		
		List<NoticeVO> notice = dao.selectAll();
		
		request.setAttribute("notice", notice);
		
		return null;
	}
}
