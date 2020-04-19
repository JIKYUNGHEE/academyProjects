package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;

public class CheckIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1) 아이디 가져오기
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		// 2) DB에서 아이디 중복체크
		UserDAO dao = new UserDAO();
		boolean check = dao.checkId(id);
		
		String msg = "";
		String url = "";
		
		// 3) true : 중복 / false : 중복x
		if (check) {
			msg = "이미 사용중인 ID입니다!";
			url = request.getContextPath() + "?log=modal&value=''";
		} else {
			msg = "멋진 ID네요!";
			url = request.getContextPath() + "?log=modal&value=" + id;
		}
		System.out.println(msg);
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("id", id);
		
		//return "?log=modal";
		return "/jsp/signup/checkIdProcess.jsp";
		//return "/jsp/signup/signupForm.jsp";
	}

}
