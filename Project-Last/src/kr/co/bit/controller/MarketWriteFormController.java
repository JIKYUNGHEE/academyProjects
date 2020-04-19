package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.dao.MBoardDAO;
import kr.co.bit.marketBoard.vo.MBoardFileVO;
import kr.co.bit.marketBoard.vo.MBoardVO;
import kr.co.bit.util.BitFileNamePolicy;

public class MarketWriteFormController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String saveFoler = "C:\\Users\\bit-user\\Desktop\\Project-Last\\WebContent\\upload";
		
		MultipartRequest multi = new MultipartRequest(request, saveFoler, 1024*10234*3, "utf-8", new BitFileNamePolicy());
		
		// 게시물 번호만 추출
		MBoardDAO nodao = new MBoardDAO();
		int no = nodao.selectFileNo();
		
		// 게시물 DB에 저장
		MBoardVO mvo = new MBoardVO();
		
		mvo.setNo(no);
		mvo.setTitle(multi.getParameter("title"));
		mvo.setContent(multi.getParameter("content"));
		mvo.setWriter(multi.getParameter("writer"));
		
		MBoardDAO dao = new MBoardDAO();
		dao.insert(mvo);
		
		// file 저장
		Enumeration files = multi.getFileNames();
		
		while(files.hasMoreElements()) {
			String fileName = (String)files.nextElement(); // file 이름
			
			File f = multi.getFile(fileName);
			
			if( f != null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				
				int fileSize = (int)f.length();
				
				MBoardFileVO fvo = new MBoardFileVO();
				
				fvo.setFileNo(no);
				fvo.setFileOriName(fileOriName);
				fvo.setFileSaveName(fileSaveName);
				System.out.println("fileSaveName : " + fileSaveName);
				fvo.setFileSize(fileSize);
				dao.insertFile(fvo);
			}
		}

		request.setAttribute("msg", "등록 완료!");
		request.setAttribute("url", request.getContextPath() + "/sellList.do");

		return "/marketBoard/marketWriteForm.jsp";
	}
}
