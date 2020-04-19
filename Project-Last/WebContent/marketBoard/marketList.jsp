<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function goWriteForm() {
		location.href = "marketWrite.do";
	}
	
</script>
</head>
<body >
	<header>
		해더부분
	</header>
	<section  style="height: 700px">
		<div align="center">
		<hr width="100%"/>
		<h2>게시물 목록</h2>
		<hr width="100%"/>
		<br/>
		
		<table border="1" style="width:80% ">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">글쓴이</th>
				<th width="20%">등록일</th>
				<th width="7%">조회수</th>
			</tr>
			<c:forEach items="${ marketList }" var="board" varStatus="loop">
				<tr>	
					<td>${ board.no }</td>
					<td>
						<a href="<%= request.getContextPath() %>/marketDetail.do?no=${ board.no }"><c:out value="${ board.title }" /></a><br/>
							<c:if test="${ not empty marketComlist }">
								<c:forEach items="${ marketComlist }" var="comment">
									&nbsp;&nbsp;<a href="<%= request.getContextPath()%>/marketCommentDetail.do?no=${ comment.no }"><c:out  value="${ comment.title  }"/></a>
								</c:forEach>
							</c:if>
						<!-- </a> -->
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.viewCnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/>
		<%-- <c:if test="${ not empty userVO }"> --%>
			<input type="button" value="등록" onclick="goWriteForm()" />
		<%-- </c:if> --%>
	</div>
	</section>
	<footer >
		footer부분
	</footer>
</body>
</html>