package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class LoginProcessController_kko implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("email_id");
		String password = request.getParameter("password");
		String email_id = request.getParameter("email_id");
		String email_domain = request.getParameter("email_domain");
		String nickname = request.getParameter("nickname");
		
		UserVO loginKko = new UserVO();
		loginKko.setId(id);
		loginKko.setPassword(password);
		loginKko.setEmail_id(email_id);
		loginKko.setEmail_domain(email_domain);
		loginKko.setNickname(nickname);
		
		UserDAO dao = new UserDAO();
		UserVO loginUser = dao.login(loginKko);
		
		String msg = "";
		String url = "";
		
		if(loginUser == null) {
			msg = "카카오 회원님! BLER MOA 첫 방문 감사합니다!";
			// id, password, email_id, email_domain, nickname
			url = request.getContextPath() + "?log=kko&id=" + id + "&password=" + password
					+ "&email_id=" + email_id + "&email_domain=" + email_domain 
					+ "&nickname=" + nickname + "&sign_type=K";
		} else {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			switch(loginUser.getType()) {
			case "S" :
				msg = "♥관리자님 환영합니다♥ :)";
				break;
			case "U" : 
				msg = "♥"+ loginUser.getNickname()+ "님 환영합니다♥ :)";
				break;
			}
			url = request.getContextPath() + "/FirstPage.jsp";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/login/loginProcess.jsp";
	}

}




