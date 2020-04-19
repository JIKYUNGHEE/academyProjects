package kr.co.bit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.pet.dao.petDAO;
import kr.co.bit.pet.vo.petVO;

public class JoinpetProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		System.out.println("request getContentType : " + request.getContentType());
				
		/*int petNo = (int) request.getAttribute("petNo");*/		
		String owner = request.getParameter("MemberId");
		
		String[] name = request.getParameterValues("name");
		String[] sex = new String[5];
		sex[0] = request.getParameter("sex1");
		sex[1] = request.getParameter("sex2");
		sex[2] = request.getParameter("sex3");
		sex[3] = request.getParameter("sex4");
		sex[4] = request.getParameter("sex5");
		String[] age = request.getParameterValues("age");
		String[] species = request.getParameterValues("species");
				
		System.out.println(name.length);
		
		
		for(int i=0; i<name.length; i++) {
			petVO pet = new petVO();
			pet.setOwner(owner);
			pet.setName(name[i]);
			if(name[i].equals(null)) {
				return "/member/joinpetProcess.jsp";
			}				
			pet.setAge(Integer.parseInt(age[i]));
			pet.setSex(sex[i]);
			pet.setSpecies(species[i]);
			petDAO dao = new petDAO();
			dao.insert(pet);
		}
				
		return "/member/joinpetProcess.jsp";
	}

}
