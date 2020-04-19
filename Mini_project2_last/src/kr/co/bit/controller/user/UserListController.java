package kr.co.bit.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class UserListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//<비즈니스 로직>
		// t1_user 테이블에서 게시물 목록 조회
		UserDAO dao = new UserDAO();
		List<UserVO> userList = dao.selectAllUser();
		
		// 공유영역에 list 객체 등록
		request.setAttribute("userList", userList);
		
		return "/jsp/user/userList.jsp";
	}

}
