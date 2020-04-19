package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("url", "/MiniProject2/index.jsp");
		
		return "/login/logout.jsp";
	}
}
