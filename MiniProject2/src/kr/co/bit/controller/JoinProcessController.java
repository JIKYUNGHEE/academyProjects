package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.member.dao.memberDAO;
import kr.co.bit.member.vo.memberFileVO;
import kr.co.bit.member.vo.memberVO;
import kr.co.bit.util.BitFileNamePolicy;

public class JoinProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		System.out.println("request getContentType : " + request.getContentType());
		String saveFolder = "D:/workspace/MiniProject2/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3, "utf-8", new BitFileNamePolicy());
		
		String name = multi.getParameter("name");
		String id = multi.getParameter("id");
		String password = multi.getParameter("password");
		String nickname = multi.getParameter("nickname");
		String sex = multi.getParameter("sex");
		int petNo = Integer.parseInt(multi.getParameter("petNO"));
		String tel = multi.getParameter("tel");
		String basic_addr = multi.getParameter("basic_addr");

		memberDAO dao = new memberDAO();

		memberVO member = new memberVO();
		member.setId(id);
		member.setName(name);
		member.setPassword(password);
		member.setNickname(nickname);
		member.setSex(sex);
		member.setPetNo(petNo);
		member.setTel(tel);
		member.setBasic_addr(basic_addr);

		dao.insert(member);
		
		
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
		
		String msg = "회원가입이 완료되었습니다.";
		String url = request.getContextPath();
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("petNo", petNo);/* 사람에 따른 동물수 -> 테이블 개수 결정 */
		request.setAttribute("id", id);
		
		return "/member/joinpet.jsp";
	}
}