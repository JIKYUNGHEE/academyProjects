package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlbumController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/album.jsp";
	}

}
