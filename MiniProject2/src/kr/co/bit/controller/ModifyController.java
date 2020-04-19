package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.BitFileNamePolicy;

public class ModifyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String saveFolder = "C:/Users/bit-user/Desktop/이지유강사님/web-workspace/MiniProject2/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new BitFileNamePolicy());

		
		String title = multi.getParameter("title"); 
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		int no = Integer.parseInt(multi.getParameter("no"));
		
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setNo(no);
		

		BoardDAO dao = new BoardDAO();
		dao.modify(board);	
		dao.deleteFile(no);	 		
		
		
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

		return "/freeBoard/freeBoardModify.jsp";
	}

}
