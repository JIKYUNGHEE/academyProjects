package kr.co.bit.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.user.dao.UserDAO;
import kr.co.bit.user.vo.UserVO;

public class ModifyInfoController_kko implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1)
		request.setCharacterEncoding("UTF-8");
		
		String id =request.getParameter("id");
		// VO 객체 생성 및 초기화
		UserVO user = new UserVO();
	
		user.setNickname(request.getParameter("nickname"));
		user.setEmail_id(request.getParameter("email_id"));
		user.setEmail_domain(request.getParameter("email_domain"));
		user.setId(id);
		
		// 2) DB에서 회원정보 수정 - 카카오 (비번 변경 불가)
		UserDAO dao = new UserDAO();
		dao.updatekkoUser(user);
		
		// 3) 업데이트된 정보 가져오기
		UserVO loginUser = dao.selectById(id);
		
		// 4) 로그인 정보 업데이트
		dao.login(loginUser);
		
		// 5) 로그인 세션 업데이트
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		// 6) msg / url 생성
		String msg = "";
		String url = "";
		switch (loginUser.getType()) {
			case "S" :
				msg = "아이디 : " + loginUser.getId() + "회원정보 수정 완료!";
				url = request.getContextPath() + "/userlist.do";
			break;
			case "U" :
				msg = loginUser.getNickname()+ "님 회원정보 수정되었습니다! :)";
				url = request.getContextPath() + "/jsp/mypage/mypage.jsp";
			break;
		}
		
		// 7) 공유영역 등록
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/user/modifyInfoProcess.jsp";
	}

}
