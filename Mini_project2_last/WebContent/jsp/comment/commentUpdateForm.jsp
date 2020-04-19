<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* function doAction(type){
		switch(type){
		case 'I':
			location.href="commentUpdate.jsp";
			break;
		}
	} */
</script>
</head>
<body>
	<div>
		<form action="<%= request.getContextPath()%>/commentUpdate.jsp?no=${ comment.no }" method="post">
		<input type="text" readonly name="writer" value="${ userVO.id }"/>
		<textarea rows="5" cols="80" name="content">${ comment.content }</textarea> 
		<input type="submit" value="등록"/>
		<%--<button onclick="doAction('I')">등록</button>--%>
		</form>
	</div>
</body>
</html>