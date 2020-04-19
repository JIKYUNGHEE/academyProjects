<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script>
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
    <div class="bg-faded p-4 my-4">
        <hr class="divider" style="border:1px solid #C1C2C6">
        <h2 class="text-center text-lg text-uppercase my-0" >
		A C C D E T A I L
		</h2>
		<hr class="divider" style="border:1px solid #C1C2C6">
        <div class="row" align="center">
			
		<table style="border:1PX splid white; width:80% ; " id="detail">
			<tr>
				<th width="25%">NO</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th align="right">VIEW</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th>DATE</th>
				<td>${ board.regDate }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>${ board.content }</td>
			</tr>
				<c:forEach var="file" items="${ fileList }" varStatus="loop">
			<tr>
				<th>FILE</th>
				<td><a href="<%= request.getContextPath() %>/upload/${ file.saveName }" target="_blank">
						<img style="width:200px; height:200px;" src="<%= request.getContextPath() %>/upload/${ file.saveName }" align="center">
						</a><br/>
						
						<button onclick="download(${ loop.count })">다운로드</button><br/>
					</td>
			</tr>
			<tr>
				<th>FILESIZE</th>
				<td>${ file.fileSize }bytes</td>
			</tr>
			</c:forEach>
		</table>
					
		</div>
		<br/><br/>
		<div align="center">
		<c:if test="${ loginUser.id eq board.writer }">
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
