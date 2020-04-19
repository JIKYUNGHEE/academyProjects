package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		// 파라미터 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// VO 객체 생성 및 초기화
		UserVO  user = new UserVO();
		user.setId(id);
		user.setPassword(password);
		
		// DB에서 로그인 수행
		UserDAO dao = new UserDAO();
		UserVO loginUser = dao.login(user);
		
		String msg = "";
		String url = "";
		
		if (loginUser == null) {
			msg = "ID 또는 PASSWORD가 잘못되었습니다!";
			url = request.getContextPath() + "?sign=modal";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			switch (loginUser.getType()) {
				case "S" :
					msg = "♥관리자님 환영합니다♥ :)";
					break;
				case "U" :
					msg = "♥"+ loginUser.getNickname()+ "님 환영합니다♥ :)";
					break;
			}
			url = request.getContextPath() + "/FirstPage.jsp";
		}
		
		// 공유영역 등록
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/login/loginProcess.jsp";
	}

}
