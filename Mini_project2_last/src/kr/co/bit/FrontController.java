package kr.co.bit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;

public class FrontController extends HttpServlet {
	
	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String configName = config.getInitParameter("configName");
		if (configName == null) {
			mappings = new HandlerMapping();
		} else {
			mappings = new HandlerMapping(configName);
		}
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		uri = uri.substring(context.length());
		
		System.out.println("호출된 URI : " + uri);
		System.out.println("context : " + context);
		
		try {
			Controller control = mappings.getController(uri);
			String callPage = control.handleRequest(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) { 
			e.printStackTrace();
			throw new ServletException(e); }
		
		
	}
}
