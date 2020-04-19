<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@page import="kr.co.bit.board.vo.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.bit.util.ConnectionFactory" %>
<%@page import="kr.co.bit.util.JDBCClose"%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%--
	http://localhost:8000/Misson-Web/jsp/board/detail.jsp
	
	작업순서
	1. no 파라미터를 얻어온다
	2. no에 해당하는 게시물을 DB에서 가져온다 (t_board)
	3. 조회된 게시물을 화면에 출력한다
 --%>
 <%
	request.setCharacterEncoding("UTF-8");
 
 	int no = Integer.parseInt(request.getParameter(("no")));
 	
 	BoardDAO dao = new BoardDAO();
 	BoardVO board = dao.selectByNo(no);
 	
 	pageContext.setAttribute("board", board);
 	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doAction(id) {
		location.href = "/Mission-Web/jsp/mypage/mylist.jsp?id=" + id;
	}
</script>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>상세 게시물</h2>
			<hr>
			<br>
		
			<table style="width: 80%" class="type11">
				<tr>
					<th scope="cols" width="15%">번호</th>
					<td width="7%">${ board.no }</td>
					<th scope="cols" width="15%">조회수</th>
					<td width="7%">${ board.viewCnt }</td>
					<th scope="cols" width="15%">등록일</th>
					<td>${ board.regDate }</td>
				</tr>
				<tr>
					<th scope="cols" width="15%">제목</th>
					<td colspan="5"><c:out value="${ board.title }"></c:out></td>
				</tr>
				<tr>
					<th scope="cols" width="15%">글쓴이</th>
					<td colspan="5">${board.writer}</td>
				</tr>
				<tr>
					<th scope="cols" width="15%">내용</th>
					<td colspan="5"><c:out value="${ board.content }"></c:out></td>
				</tr>
			</table>
			<br>
			<button onclick="doAction('${ loginMember.id }')">목록</button>
		</div>
	</section>
	<footer>
		<%@include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>