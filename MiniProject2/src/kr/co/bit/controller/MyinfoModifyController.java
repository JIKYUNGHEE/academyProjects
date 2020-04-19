package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.memberDAO;
import kr.co.bit.member.vo.memberFileVO;
import kr.co.bit.member.vo.memberVO;
import kr.co.bit.util.BitFileNamePolicy;

public class MyinfoModifyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			
		request.setCharacterEncoding("utf-8");
		
		String saveFolder = "D:/workspace/MiniProject2/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3, "utf-8", new BitFileNamePolicy());
						
		
		LoginVO vo = (LoginVO)request.getSession().getAttribute("userVO");		
		
		String id = vo.getId();		
		String name = multi.getParameter("name");
		String password = multi.getParameter("password");
		String nickname = multi.getParameter("nickname");
		String sex = multi.getParameter("sex");
		int petNo = Integer.parseInt(multi.getParameter("petNO"));
		String tel = multi.getParameter("tel");
		String basic_addr = multi.getParameter("basic_addr");
	
			
			
			memberVO member = new memberVO();
			member.setId(id);
			member.setName(name);
			member.setPassword(password);
			member.setNickname(nickname);
			member.setSex(sex);
			member.setPetNo(petNo);
			member.setTel(tel);	
			member.setBasic_addr(basic_addr);			
			

			memberDAO dao = new memberDAO();
			dao.modifyMember(member);
			dao.deleteFile(id);
			
			
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()){
				String fileName = (String)files.nextElement();
				
				File f = multi.getFile(fileName);
				
				if(f != null){
					String fileOriName = multi.getOriginalFileName(fileName);
					String fileSaveName = multi.getFilesystemName(fileName);
					
					int fileSize = (int)f.length();
					
					memberFileVO fileVO = new memberFileVO();
					
					fileVO.setFileOriName(fileOriName);
					fileVO.setFileSaveName(fileSaveName);
					fileVO.setFileSize(fileSize);
					fileVO.setMemberId(id);
					
					dao.insertFile(fileVO);
				}
			}
					
			
			
			
			String msg= "회원정보가 수정되었습니다.";
			String url= "/MiniProject2/myinfoDetail.do";
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			
			return "/myinfo/myinfoModify.jsp";
	}

}
