package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.pet.dao.petDAO;
import kr.co.bit.pet.vo.petVO;

public class MypetinfoModifyController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		LoginVO vo = (LoginVO)request.getSession().getAttribute("userVO");		
		
		String owner = vo.getId();
		String[] no = request.getParameterValues("no");
		String[] name = request.getParameterValues("name");
		String[] sex = request.getParameterValues("sex");	
		String[] age = request.getParameterValues("age");
		String[] species = request.getParameterValues("species");
			
		System.out.println("mypetinfomodifycontroller");
		
		for(int i=0; i<name.length; i++) {
			
			petVO pet = new petVO();
			pet.setOwner(owner);
			pet.setName(name[i]);	
			pet.setNo(Integer.parseInt(no[i]));
			pet.setAge(Integer.parseInt(age[i]));
			pet.setSex(sex[i]);
			pet.setSpecies(species[i]);
			petDAO dao = new petDAO();
			dao.modifyPet(pet);
		}
		
		
		String msg= "펫정보가 수정되었습니다.";
		String url= "/MiniProject2/myinfoDetail.do";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
				
		return "/mypetinfo/mypetinfoModify.jsp";
	}

}
