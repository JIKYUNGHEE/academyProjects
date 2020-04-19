package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class SignupController_kko implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1)
		request.setCharacterEncoding("UTF-8");
		
		// VO 객체 생성 및 초기화
		UserVO userData = new UserVO();
		
		userData.setId(request.getParameter("id"));
		userData.setPassword(request.getParameter("password"));
		userData.setNickname(request.getParameter("nickname"));
		userData.setEmail_id(request.getParameter("email_id"));
		userData.setEmail_domain(request.getParameter("email_domain"));
		userData.setType(request.getParameter("type"));
		userData.setGender(request.getParameter("gender"));
		userData.setSign_type(request.getParameter("sign_type"));
		
		// 2) DB에서 회원가입 수행
		UserDAO dao = new UserDAO();
		dao.insertUser(userData);
		
		// 3) 메시지 & url 등록(로그인 페이지)
		String msg = "등록완료 : 회원가입을 축하합니다 :)";
		String url = request.getContextPath() + "?sign=modal";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/signup/signup.jsp";
	}

}
