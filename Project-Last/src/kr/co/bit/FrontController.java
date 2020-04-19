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
   
   public void init(ServletConfig config) throws ServletException {
      mappings = new HandlerMapping();
   }
   
   @Override
   public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String uri = request.getRequestURI();
            
      String context = request.getContextPath();      
      uri = uri.substring(context.length());   
      System.out.println("호출된 URI : " + uri);
      
      try {
         String callPage = "";
         
         Controller control = mappings.getController(uri);
         
         if(control!=null)
            callPage = control.handleRequest(request, response);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
         dispatcher.forward(request, response);
         
                  
      }catch(Exception e) {
         e.printStackTrace();
         throw new ServletException(e);   
      }
   }
}