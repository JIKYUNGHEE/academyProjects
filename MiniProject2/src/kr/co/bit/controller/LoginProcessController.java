package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.dao.LoginDAO;
import kr.co.bit.login.vo.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
				
		String msg = "";
		String url = "";
		if(userVO == null) {
			msg = "아이디 또는 패스워드가 잘못되었습니다.";
			url = request.getContextPath();
		}else {
			HttpSession session = request.getSession();
			String file = dao.selectPictureById(id);
			if(!file.equals(null)) {
				session.setAttribute("file", file);
			}
			session.setAttribute("userVO", userVO);
			switch(userVO.getType()) {
			case "S" :
				msg += "관리자님 환영합니다.";
				break;
			case "U" : 
				msg += userVO.getNickname() + "님 환영합니다.";
				break;
			}
			url = request.getContextPath();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
				
		return "/login/loginProcess.jsp";
	}

}
