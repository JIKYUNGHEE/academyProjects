package kr.co.bit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.controller.FreeBoardListController;
import kr.co.bit.controller.WriteFormController;

public class FrontController extends HttpServlet {
	private HandlerMapping mappings;
	
	public void init(ServletConfig config) throws ServletException{
		mappings = new HandlerMapping();
	}

	public void service(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println("호출된 URI : " + uri);
		String context = request.getContextPath();
		System.out.println("호출된 context : " + context);
		uri = uri.substring(context.length());
		
		System.out.println("호출된 URI : " + uri);
		
		try {
			
			Controller control = mappings.getContoller(uri);
			System.out.println("control : "+control);
			String callPage = control.handleRequest(request, response);
			System.out.println("callpage :"+callPage);
			// 요청 servlet -> jsp 이동
			RequestDispatcher dispatcher 
				= request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// e.printStackTrace();
			throw new ServletException(e);
		}
	}
}



