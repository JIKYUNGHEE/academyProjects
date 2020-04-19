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

public class BoardUpdateController implements Controller{

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
	    
	    String type = multi.getParameter("type");
	    String title = multi.getParameter("title");
	    String writer = multi.getParameter("writer");
	    String content = multi.getParameter("content");
		String no1 = multi.getParameter("no");
		int no = Integer.parseInt(no1);

		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setNo(no);
		
		BoardDAO dao = new BoardDAO();
		dao.update(board);
		
		request.setAttribute("board", board);
		
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()){
			String fileName = (String)files.nextElement();
			
			File f = multi.getFile(fileName);
			if(f != null){
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)f.length();
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setOriName(fileOriName);
				fileVO.setSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				fileVO.setBoardNo(no);
				
				dao.insertFile(fileVO);
			}
		}
		
		request.setAttribute("type", type);
		
		return "/jsp/board/boardUpdate.jsp";
	}

	
}
