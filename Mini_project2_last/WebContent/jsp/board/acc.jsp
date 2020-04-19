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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/boardcard.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/paging.css" />
<script type="text/javascript">
	function goBoardWriteForm(){
		location.href="<%=request.getContextPath()%>/BoardWriteForm.do?type=${param.type}";
	}
</script>
<style type="text/css">
.btn{
border: none;
background: white;
color: #C1C2C6;
}
</style>

</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<br>
	<section>
	<div class="board-card-list">
		<ul>
			<c:forEach var="fAcc" items="${ requestScope.fAcc }">
				<c:forEach var="acc" items="${ boardPage.boardList }">
					<c:if test="${ fAcc.boardNo eq acc.no }">
						<li><a
							href="<%= request.getContextPath() %>/accDetail.do?no=${ fAcc.boardNo }">
								<em class="card-id">${ acc.writer }</em> <span class="card-img">
									<img alt=""
									src="<%= request.getContextPath() %>/upload/${ fAcc.saveName }">
							</span> <strong class="card-tit">${ acc.title }</strong>


								<p class="card-para">${ acc.content }</p>
						</a></li>
					</c:if>
				</c:forEach>
			</c:forEach>

		</ul>
	</div>
	<br/><br/>
	<div align="center">
	<c:if test="${boardPage.startPage > 5}">
			<form class="pagingBox" action="<%= request.getContextPath() %>/acc.do" method="post">
				<input type="hidden" name="type" value="${param.type}">
				<input type="hidden" name="pageNo" value="${boardPage.startPage-5 }">
				<input class="btn" class="pagingBox" type="submit" value="이전">
			</form>
		</c:if>
		<c:forEach var="pNo" begin="${boardPage.startPage}" end="${boardPage.endPage }">
			<form class="pagingBox" action="<%= request.getContextPath() %>/acc.do" method="post">
				<input type="hidden" name="type" value="${param.type}">
				<input type="hidden" name="pageNo" value="${pNo}">
				<input class="btn" type="submit" value="${pNo}">
			</form>				
				
		</c:forEach>
		<c:if test="${boardPage.endPage < boardPage.totalPages}">
				<form class="pagingBox" action="<%= request.getContextPath() %>/acc.do" method="post">
				<input type="hidden" name="type" value="${param.type}">
				<input type="hidden" name="pageNo" value="${boardPage.startPage+5}">
				<input class="btn" type="submit" value="다음">
			</form>
		</c:if>
		<br /><br />
		<c:if test="${ not empty loginUser }">
		
		<input class="btn" type="button" value="게시물 작성" onclick="goBoardWriteForm()" />
		
		</c:if>
		</div>
		</section>
		<br>
	<footer class="bg-faded text-center py-5">
		<%@include file="/jsp/include/bottom.jsp" %>
	</footer>
	
    <!-- Bootstrap core JavaScript -->
    <script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%= request.getContextPath() %>/vendor/popper/popper.min.js"></script>
    <script src="<%= request.getContextPath() %>/vendor/bootstrap/js/bootstrap.min.js"></script>
		

</body>
</html>