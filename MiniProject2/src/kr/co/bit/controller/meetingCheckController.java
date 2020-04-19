package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.map.dao.MapDAO;
import kr.co.bit.map.vo.MapVO;

public class meetingCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		MapDAO dao = new MapDAO();

		// 확인 위한 true나 false를 빼옴
		boolean check = dao.checkMeeting(request.getParameter("meetingTime"), request.getParameter("parkName"), request.getParameter("userId"));
		
		request.setAttribute("check", check);
		System.out.println("!!check : "+check);
		
		return "/map/meetingCheck.jsp";
	}

}
