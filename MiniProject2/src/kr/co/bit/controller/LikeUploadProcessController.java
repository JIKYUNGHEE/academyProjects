package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.like.dao.LikeDAO;
import kr.co.bit.like.vo.LikeFileVO;
import kr.co.bit.like.vo.LikeVO;
import kr.co.bit.util.BitFileNamePolicy;

public class LikeUploadProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		request.setCharacterEncoding("utf-8");
		String saveFolder ="D:/workspace/MiniProject2/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request,
 				saveFolder,
 				1024*1024*20,
 				"utf-8",
 				new BitFileNamePolicy()
 				);
		
		String id = multi.getParameter("id");
		String pName = multi.getParameter("pName");
		String pIntro = multi.getParameter("pIntro");
		String title = multi.getParameter("title");
		
		LikeDAO dao = new LikeDAO();
		
		int like_no = dao.selectNo();
		
		LikeVO like = new LikeVO();
		
		like.setLike_no(like_no);
		
		like.setId(id);
		like.setpIntro(pIntro);
		like.setpName(pName);
		like.setTitle(title);
		
		
		dao.insert(like);
		
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
				
				LikeFileVO fileVO = new LikeFileVO();
				
				fileVO.setFsize(fsize);
				fileVO.setLike_no(like_no);
				fileVO.setOriname(oriname);
				fileVO.setSavename(savename);
				
				dao.insertFile(fileVO);
				
			}
			
		}
		
		return "/like/likeUpdateProcess.jsp";
	}
}
