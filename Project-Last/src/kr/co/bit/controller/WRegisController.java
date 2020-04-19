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

public class WRegisController implements Controller {
	


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
		   
		
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		TBoardVO tvo = new TBoardVO();
		
		// tvo 셋팅
		tvo.setWriter(writer);
		tvo.setTitle(title);
		tvo.setContent(content);
		
		TipBoardDAO tdao = new TipBoardDAO();
		tdao.insertTBoard(tvo);
		
		// writer에 해당하는 글의 no 받아오기(혹 몰라서 vo 로 받아옴 필요할때 쓸것)
		TBoardVO tno = new TBoardVO();
		tno = tdao.selectBoardInfo(writer);
		int wno = tno.getNo();
		
		
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
		        tfileVO.setFileNo(wno);
		        tfileVO.setFileOriName(fileOriName);
		        tfileVO.setFileSaveName(fileSaveName);
		        tfileVO.setFileSize(fileSize);
		        
		        
		        tdao.insertTBoardFile(tfileVO);
		      
		      }
		
		   }
		   return "/wRegisFin.do";
	}
}