<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@page import="kr.co.bit.board.vo.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	BoardDAO dao = new BoardDAO();
	CommentVO comment = new CommentVO();
	comment = dao.selectCommentByNo(Integer.parseInt(request.getParameter("no")));
	
	comment.setContent(request.getParameter("content"));
	
	dao.updateComment(comment);
	
	
	
%>

<script>
alert('댓글이 수정 되었습니다.');
location.href="<%= request.getContextPath()%>/infoDetail.do?no=${ param.no }";
</script>