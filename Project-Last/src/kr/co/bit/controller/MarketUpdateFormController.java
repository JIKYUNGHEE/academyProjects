package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.dao.TipBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardFileVO;
import kr.co.bit.marketBoard.vo.MBoardVO;
import kr.co.bit.util.BitFileNamePolicy;

public class MarketUpdateFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	request.setCharacterEncoding("utf-8");
		
	String saveFolder = "C:\\Users\\bit-user\\Desktop\\Project-Last\\WebContent\\upload";
	

	MultipartRequest multi = new MultipartRequest(
	         request,
	         saveFolder,
	         1024 * 1024 * 3,
	         "utf-8",
	         new BitFileNamePolicy()
	         );
	
	
	int no = Integer.parseInt(multi.getParameter("no"));
	String title = multi.getParameter("title");
	String content = multi.getParameter("content");
	
	
	MBoardVO mvo = new MBoardVO();
	mvo.setNo(no);
	mvo.setTitle(title);
	mvo.setContent(content);
	mvo.setViewCnt(0);
	
	
	MBoardDAO dao = new MBoardDAO();
	dao.reWriteUp(mvo);
	
	Enumeration files =  multi.getFileNames();
	   while(files.hasMoreElements()){
	      String fileName = (String)files.nextElement();             //reutrn 타입이 object라서 !! (String) 해줘야하마
	    
	   
	      File f = multi.getFile(fileName);       //file객체!!
	      
	      if(f != null){
	         String fileOriName = multi.getOriginalFileName(fileName);
	         String fileSaveName = multi.getFilesystemName(fileName);
	         
	         int fileSize = (int)f.length();
	
	         MBoardFileVO mfileVO = new MBoardFileVO();
	         	mfileVO.setFileNo(no);
	         	mfileVO.setFileOriName(fileOriName);
	         	mfileVO.setFileSaveName(fileSaveName);
	         	mfileVO.setFileSize(fileSize);
		      
		        dao.insertFile(mfileVO);
		      
		      }
		
		   }
	
	
	
/*	MBoardVO mvo = new MBoardVO();
	mvo.setNo(Integer.parseInt(request.getParameter("no")));
	mvo.setTitle(request.getParameter("title"));
	mvo.setWriter(request.getParameter("writer"));
	mvo.setContent(request.getParameter("content"));
	mvo.setViewCnt(0);*/
	
	
		return "/marketBoard/reWriteUp.jsp";
	}
		
		
		
		

}
