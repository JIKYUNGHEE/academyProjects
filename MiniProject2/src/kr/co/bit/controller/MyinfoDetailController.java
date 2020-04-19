package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.memberDAO;
import kr.co.bit.member.vo.memberFileVO;
import kr.co.bit.member.vo.memberVO;
import kr.co.bit.pet.dao.petDAO;
import kr.co.bit.pet.vo.petVO;

public class MyinfoDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LoginVO vo = (LoginVO)request.getSession().getAttribute("userVO");		
		String id = vo.getId();
		
		
		memberDAO dao = new memberDAO();
		memberVO member = dao.selectById(id);
		
		memberFileVO pimg = dao.selectFileByNo(id);
		
		request.setAttribute("member", member);
		request.setAttribute("pimg", pimg);
		
		
		
		
		petDAO dao1 = new petDAO();
		List<petVO> petlist = dao1.selectAllById(id);
		
		request.setAttribute("petlist", petlist);
		
		return "/myinfo/myinfoDetail.jsp";
	}

}
