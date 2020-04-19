package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.memberDAO;
import kr.co.bit.member.vo.memberVO;
import kr.co.bit.pet.dao.petDAO;
import kr.co.bit.pet.vo.petVO;

public class MypetinfoModifyFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LoginVO vo = (LoginVO)request.getSession().getAttribute("userVO");		
		String id = vo.getId();
		
	 	petDAO dao = new petDAO();
		List<petVO> petlist = dao.selectAllById(id);
		
		request.setAttribute("petlist", petlist);
		

		return "/mypetinfo/mypetinfoModifyForm.jsp";
	}
}
