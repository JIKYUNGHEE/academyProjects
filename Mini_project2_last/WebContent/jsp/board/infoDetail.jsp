<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">
<script type="text/javascript">
	<%-- function doAction(type){
		switch(type){
		case 'I' :
			location.href="<%= request.getContextPath() %>/commentWrite.do?no=${ param.no }";
		}
	} --%>
	
	function doAction(tp) {
		switch(tp) {
		case 'U' :
			location.href="";
			break;
		case 'D' :
			if(confirm("삭제 하시겠습니까?")) {
				location.href="<%=request.getContextPath()%>/boardDelete.do?no=${ board.no }";
			}
			break;
		case 'L' :
			switch("${ board.type }"){
		    case "a":
		    	location.href = "<%= request.getContextPath() %>/info.do?type=a";
		    	break;
		    case "b":
		    	location.href = "<%= request.getContextPath() %>/acc.do?type=b";
		    	break;
		    case "c":
		    	location.href = "<%= request.getContextPath() %>/BoardList.do?type=c";
		    	break;
		    case "d":
		    	location.href = "<%= request.getContextPath() %>/BoardList.do?type=d";
		    	break;
		    
		    }
			}
		}
</script>
<style type="text/css">
th{
background-color: #C0BCD7;
color: white;
text-align: center;
}
button{
border: none;
background: C1C2C6;
color: white;
width: 55px;
height: 35px;
border-radius: 5px;
}
.btn{
border: none;
background: C1C2C6;
color: white;
}
h2{
color: #C1C2C6;
}
</style>
</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
	<div class="container">
    <div class="bg-faded p-4 my-4"style="min-height: 200px; width: 600px;margin-left: 260px">
    
    <div >
		<div style="float:left;" >
			<img style="width:250px; height:300px;" src="<%= request.getContextPath() %>/upload/${ file.saveName }">
		</div>
		<div class="container">
			<div style="color: #7C7CB6 ">${ file.oriName }</div>
			<div style="color: #7C7CB6; min-height: 300px">${ board.content }</div>	
		</div>
		<div class="comment">
			<%-- <jsp:include page="<%=request.getContextPath()%>/comment.do?no=${ param.no }"/> --%>
		</div>
	</div>
	<br>
	<div >
		<form action="<%= request.getContextPath()%>/commentWrite.do?no=${ param.no }" method="post">
			<input type="text" readonly name="writer" value="${ userVO.id }"/><br>
			<textarea rows="5" cols="80" name="content"></textarea><br>
			<input class="btn" type="submit" value="등록"/>
			<%--<button onclick="doAction('I')">등록</button>--%>
		</form>
		<br>
		<c:if test="${ loginUser.type eq 'S' }">
			<button onclick="doAction('U')">수정</button>&nbsp;&nbsp;
			<button onclick="doAction('D')">삭제</button>&nbsp;&nbsp;
		</c:if>
		<button onclick="doAction('L')">목록</button>
	</div>
	</div>
	</div>
	</section>
	<footer class="bg-faded text-center py-5">
		<%@include file="/jsp/include/bottom.jsp" %>
	</footer>
	
    <!-- Bootstrap core JavaScript -->
    <script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%= request.getContextPath() %>/vendor/popper/popper.min.js"></script>
    <script src="<%= request.getContextPath() %>/vendor/bootstrap/js/bootstrap.min.js"></script>
	
</body>
</html>
<%-- file 이 List다 다시 고려해서 짜기 --%>