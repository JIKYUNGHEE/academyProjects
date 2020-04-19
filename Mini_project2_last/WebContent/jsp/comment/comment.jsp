<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doAction(type, no){
		switch(type){
		case 'U' :
			location.href="<%= request.getContextPath()%>/commentUpdateForm.do?no="+no;
			break;
		case 'D' :
			location.href="commentDelete.jsp?no="+no;
			break;
		}
	}
</script>
</head>
<body>
	<c:forEach var="comment" items="${ requestScope.list }">
	<div class="cContainer">
		<table>
			<tr>
				<td>${ comment.writer }</td>
				<td>${ comment.regDate }</td>
				<c:if test="${ userVO.id eq comment.writer }">
				<td><button onclick="doAction('U', ${comment.cNo} )">수정</button></td>
				<td><button onclick="doAction('D', ${comment.cNo} )">삭제</button></td>
				</c:if>
			</tr>
			<tr>
				<td>${ comment.content }</td>
			</tr>
		</table>
	</div>
	</c:forEach>
</body>
</html>