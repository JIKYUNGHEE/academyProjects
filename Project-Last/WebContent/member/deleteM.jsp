

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%--

	작업순서:
	1. 무엇을 삭제할 지 삭제할 게시판 번호를 파라미터(no)를 통해서 얻어와야함
    2. Database를 통해 해당 게시물을 삭제(t_board)
    3. 삭제했다는 메시지를 남긴 후 목록 게시판으로 이동한다.

 --%>

 
 <script>
  	
 	alert('${ member.id }의 정보가 삭제되었습니다. ');
  	location.href = "<%=request.getContextPath()%>/index.do";
  	
 </script>
 
 <link rel = "stylesheet" href="/Mission-Web/CSS/m_layout.css">
 <link rel = "stylesheet" href="/Mission-Web/CSS/member.css">