package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.util.BitFileNamePolicy;
import kr.co.bit.walk.dao.WalkDAO;
import kr.co.bit.walk.vo.WalkFileVO;
import kr.co.bit.walk.vo.WalkVO;

public class WalkUploadProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		request.setCharacterEncoding("utf-8");
		String saveFolder = "D:/workspace/MiniProject2/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request,
 				saveFolder,
 				1024*1024*20,
 				"utf-8",
 				new BitFileNamePolicy()
 				);
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		WalkDAO dao = new WalkDAO();
		
		int walk_no = dao.selectNo();
		
		WalkVO walk = new WalkVO();
		
		walk.setWalk_no(walk_no);
		
		walk.setTitle(title);
		walk.setContent(content);
		
		dao.insert(walk);
		
		// 사진 DB저장
		
		Enumeration file = multi.getFileNames();
		
		while(file.hasMoreElements())
		{
			String fileName = (String)file.nextElement();
			
			File f = multi.getFile(fileName);
			if(f!=null)
			{
				String oriname = multi.getOriginalFileName(fileName);
				String savename = multi.getFilesystemName(fileName);

				int fsize = (int)f.length();
				
				WalkFileVO fileVO = new WalkFileVO();
				
				fileVO.setWalk_no(walk_no);
				fileVO.setOriname(oriname);
				fileVO.setSavename(savename);
				fileVO.setFsize(fsize);
				
				dao.insertFile(fileVO);
				
			}
			
		}
		
		return "/walk/walkUpdateProcess.jsp";
	}
}
