package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		
		return "/freeBoard/freeBoardWriteForm.jsp";
	}

}
