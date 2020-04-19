package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class DeleteUserController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");

		// 배열로 받기
		String[] id = request.getParameterValues("id");
	 	
		UserDAO dao = new UserDAO();
		
		String msg = "";
		String url = "";
		try{
			// 회원 삭제
			for(int i = 0; i < id.length; i++) {
				dao.deleteUser(id[i]);
				
				//UserVO userData = dao.selectById(id[i]);
				
				HttpSession session = request.getSession();
				UserVO[] loginUser = new UserVO[id.length];
				loginUser[i] = (UserVO)session.getAttribute("loginUser");
				
				if (loginUser[i].getId().equals(id[i])) {
					// 탈퇴 회원 로그아웃
					session.invalidate();
					msg = id[i] + " 회원님 정상 탈퇴 되었습니다!";
					url = request.getContextPath();
					// 공유영역 등록
				} else {
					msg = "회원 [" + id.length + "]명이 삭제되었습니다!";
					url = request.getContextPath() +"/userlist.do";
				}
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		// 공유영역 등록
		request.setAttribute("id", id);
		request.setAttribute("length", id.length);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/user/deleteUser.jsp";
	}

}
