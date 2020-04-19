package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.dao.TipBoardDAO;
import kr.co.bit.util.BitFileNamePolicy;

public class ReWriteUpController implements Controller {

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
		
		TBoardVO tvo = new TBoardVO();
		tvo.setNo(no);
		tvo.setTitle(title);
		tvo.setContent(content);
		
		TipBoardDAO tdao = new TipBoardDAO();
		tdao.reWriteUp(tvo);
		
		
		
		 Enumeration files =  multi.getFileNames();
		   while(files.hasMoreElements()){
		      String fileName = (String)files.nextElement();             //reutrn 타입이 object라서 !! (String) 해줘야하마
		    
		   
		      File f = multi.getFile(fileName);       //file객체!!
		      
		      if(f != null){
		         String fileOriName = multi.getOriginalFileName(fileName);
		         String fileSaveName = multi.getFilesystemName(fileName);
		         
		         int fileSize = (int)f.length();
		      
		      //첨부파일 객체를 생성하고 초기화하기!!
		      
		        TBoardFileVO tfileVO = new TBoardFileVO();
		        tfileVO.setFileNo(no);
		        tfileVO.setFileOriName(fileOriName);
		        tfileVO.setFileSaveName(fileSaveName);
		        tfileVO.setFileSize(fileSize);
		      
		        tdao.insertTBoardFile(tfileVO);
		      
		      }
		
		   }
		
		
		
		return "TBoard/reWriteUp.jsp";
	}

}
