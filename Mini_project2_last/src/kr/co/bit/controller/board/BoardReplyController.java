package kr.co.bit.controller.board;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.controller.Controller;
import kr.co.bit.util.BitFileNamePolicy;

public class BoardReplyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	    request.setCharacterEncoding("utf-8");

	    
	    String saveFolder = "C:/Users/bit-user/Desktop/web_workspace/Project-Web-MVC01/WebContent/upload";
	    
	    MultipartRequest multi = new MultipartRequest(
	    		request,
	    		saveFolder,
	    		1024 * 1024 * 3,
	    		"utf-8",
	    		new BitFileNamePolicy()
	    		); 
	    String no1 = multi.getParameter("no");
	    int bNo = Integer.parseInt(no1); 
	    String type = multi.getParameter("type");
	    String title = multi.getParameter("title");
	    String writer = multi.getParameter("writer");
	    String content = multi.getParameter("content"); 
	    
	    
	    //등록할 게시글 번호 추출
	    BoardDAO dao = new BoardDAO();
	    int no = dao.selectNo();
	    
	    BoardVO reply = new BoardVO();
	    reply.setType(type);
	    reply.setTitle(title);
	    reply.setWriter(writer);
	    reply.setContent(content);
	    reply.setNo(no);
	    reply.setbNo(bNo);
	    
	    dao.insertReply(reply);
	    
	    Enumeration files = multi.getFileNames();
	    while(files.hasMoreElements()){
	    	String fileName = (String)files.nextElement();
	    	
	    	File f = multi.getFile(fileName);
	    	if(f != null) {
	    		String fileOriName = multi.getOriginalFileName(fileName);
	    		String fileSaveName = multi.getFilesystemName(fileName);
	    		int fileSize = (int)f.length();
	    		
	    		//첨부파일 객체 생성 및 초기화
	    		BoardFileVO fileVO = new BoardFileVO();
	    		fileVO.setOriName(fileOriName);
	    		fileVO.setSaveName(fileSaveName);
	    		fileVO.setFileSize(fileSize);
	    		fileVO.setBoardNo(no);
	    		
	    		dao.insertFile(fileVO); 
	    	
	    	}
	    }
	
	    
	    

	   
	    
	    request.setAttribute("type", type);
	   

		
	   
		
		return "/jsp/board/BoardReply.jsp";
	}

}
