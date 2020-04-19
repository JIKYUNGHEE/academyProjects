package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarketWriteController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("마켓뢀ㅇㄹㄴ잍크");
		
		return "/marketBoard/marketWrite.jsp";
	}

}
