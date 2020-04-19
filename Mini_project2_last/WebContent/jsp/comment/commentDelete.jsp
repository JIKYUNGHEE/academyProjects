<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	BoardDAO dao = new BoardDAO();
	
	int boardNo = dao.selectCommentByNo(no).getBoardNo();
	
	dao.deleteComment(no);
	
	pageContext.setAttribute("no", boardNo);
%>

<script>
alert('댓글이 삭제 되었습니다.');
location.href="<%= request.getContextPath()%>/infoDetail.do?no=${ pageScope.no }";

</script>