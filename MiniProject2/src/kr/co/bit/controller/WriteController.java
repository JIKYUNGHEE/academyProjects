package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.BitFileNamePolicy;

public class WriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String saveFolder = "D:/workspace/MiniProject2/WebContent/upload";
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new BitFileNamePolicy());
				
		
		//1. 게시물 저장
		String title = multi.getParameter("title"); 
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		
		//등록할 게시물 번호 추출
		BoardDAO dao = new BoardDAO();
	 	int no = dao.selectNo();	
	 	
	 	BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setNo(no);
		
		dao.insert(board);
		
		
		
		//2. 첨부파일 저장
		Enumeration files = multi.getFileNames();
	
		
		while(files.hasMoreElements()){
			String fileName = (String)files.nextElement();
			
			File f = multi.getFile(fileName); 
			if(f != null){
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)f.length();
				
				//첨부파일 객체 생성 및 초기화
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				fileVO.setBoardNo(no);
				
				dao.insertFile(fileVO);
			}
		}
	
		return "/freeBoard/freeBoardWrite.jsp";
	}
}