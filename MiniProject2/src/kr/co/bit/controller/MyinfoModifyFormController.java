package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.memberDAO;
import kr.co.bit.member.vo.memberVO;

public class MyinfoModifyFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		LoginVO vo = (LoginVO)request.getSession().getAttribute("userVO");		
		String id = vo.getId();
		
	 	memberDAO dao = new memberDAO();
		memberVO info = dao.selectById(id);
		
		//공유영역에 list 객체 등록
		request.setAttribute("info", info);
		
		return "/myinfo/myinfoModifyForm.jsp";
	}

}
