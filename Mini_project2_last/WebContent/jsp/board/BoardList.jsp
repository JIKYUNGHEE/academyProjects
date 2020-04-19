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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/paging.css" />
<script>
function goBoardWriteForm(){
	location.href="<%=request.getContextPath()%>/BoardWriteForm.do?type=${param.type}";
}
function doAction(boardNo){
	location.href = "<%=request.getContextPath()%>/BoardDetail.do?no="+ boardNo;
		/* <c:choose>
		<c:when test="${ not empty userVO }">
		location.href = "BoardDetail.jsp?no=" + boardNo;
		</c:when>
		<c:otherwise>
		if(confirm("로그인 후 사용 가능합니다\n로그인 하시겠습니까?")){
			//location.href="/Mission-web/JSP/login/login.jsp";
		}
		</c:otherwise>
		</c:choose> */
	}
</script>
<style type="text/css">
.btn{
border: none;
background: #F4D0D4;
color: white;
}

tr>*{
text-align: center;
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
          <strong style="color: #C1C2C6"><c:if test="${ param.type eq 'c'}">
		<h2>B O A R D</h2>
		</c:if>
		<c:if test="${ param.type eq 'd'}">
		<h2>M A R K E T</h2>
		</c:if></strong>
        </h2>
        <hr class="divider" style="border:1px solid #C1C2C6">
        <div class="row" align="center">
          
          <table style="border:1PX splid white; width:80% ; ">
			<tr style="background:#C0BCD7; color: white;">
				<th width="7%" >NO</th>
				<th>TITLE</th>
				<th width="16%">WRITER</th>
				<th width="20%">DATE</th>
			</tr>
	
			<c:forEach items="${ boardPage.boardList }" var="board" varStatus="loop">
				<tr <%-- <c:if test="${ loop.count mod 2 eq 0 }">class="even"</c:if> --%>>
					<td style="text-align: center;">
					<c:if test="${ board.re eq 0 }">
					${ board.no }
					</c:if>
					</td>
					<td><a href="javascript:doAction('${ board.no }')">
					    <c:if test="${ board.re ne 0 }">
							[re]	
						</c:if>		
							${ board.title }
					</a></td>
					<td style="text-align: center;">${ board.writer }</td>
					<td style="text-align: center;">${ board.regDate }</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		
		<br><br>
		<div style="position: static; text-align: center;">
		<c:if test="${boardPage.startPage > 5}">
			<form class="pagingBox" action="<%= request.getContextPath() %>/BoardList.do" method="post">
				<input type="hidden" name="type" value="${param.type}">
				<input type="hidden" name="pageNo" value="${boardPage.startPage-5 }">
				<input class="btn" class="pagingBox" type="submit" value="이전">
			</form>
		</c:if>
		<c:forEach var="pNo" begin="${boardPage.startPage}" end="${boardPage.endPage }">
			<form class="pagingBox" action="<%= request.getContextPath() %>/BoardList.do" method="post">
				<input type="hidden" name="type" value="${param.type}">
				<input type="hidden" name="pageNo" value="${pNo}">
				<input class="btn" type="submit" value="${pNo}">
			</form>				
				
		</c:forEach>
		<c:if test="${boardPage.endPage < boardPage.totalPages}">
				<form class="pagingBox" action="<%= request.getContextPath() %>/BoardList.do" method="post">
				<input type="hidden" name="type" value="${param.type}">
				<input type="hidden" name="pageNo" value="${boardPage.startPage+5}">
				<input class="btn" type="submit" value="다음">
			</form>
		</c:if>
		
		<br><br>
		<c:if test="${ not empty loginUser }">
		<input class="btn" type="button" value="게시물 작성" onclick="goBoardWriteForm()" />
		</c:if> 
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