package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.map.dao.MapDAO;
import kr.co.bit.map.vo.MapVO;

public class MeetingViewController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		MapDAO dao = new MapDAO();

		// 출력 위한 리스트 빼옴
		List<MapVO> list = dao.getParticipants(request.getParameter("parkName"));
		
		request.setAttribute("list", list);
		
		return "/map/meetingParticipants.jsp";
	}

}
