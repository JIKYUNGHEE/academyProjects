package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.map.dao.MapDAO;
import kr.co.bit.map.vo.MapVO;

public class MeetingDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		//넘어온 데이터를 저장
		MapVO meeting = new MapVO();
		meeting.setParkName(request.getParameter("parkName"));
		meeting.setUserId(request.getParameter("userId"));	
		meeting.setMeetingTime(request.getParameter("meetingTime"));
		
		// db 저장을 위한 dao에 데이터 전달
		MapDAO dao = new MapDAO();
		dao.deleteMeeting(meeting);
		
		// 출력 위한 리스트 빼옴
		List<MapVO> list = dao.getParticipants(request.getParameter("parkName"));
				
		request.setAttribute("list", list);
		
		return "/map/meetingParticipants.jsp";
	}

}
