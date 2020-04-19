package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class DetailInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		UserDAO dao = new UserDAO();
		UserVO userData = dao.selectById(id);
		
		request.setAttribute("userData", userData);
		
		return "/jsp/user/detailInfo.jsp";
	}

}
