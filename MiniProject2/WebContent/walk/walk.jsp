<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Petting</title>

<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/Resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/Resources/css/business-casual.css" rel="stylesheet">



</head>

<body>

	<jsp:include page="../include/topMenu.jsp" />

	<div class="container">
	<c:if test="${ (reply.id eq 'shook88@naver.com')or (sessionScope.userVO.type eq 'S') }">
		<a href="<%=request.getContextPath()%>/walkUpload.do"
			class="btn btn-secondary">Upload</a></c:if>
		<c:forEach items="${orderbyList}" var="walk">
			<c:forEach items="${fileList}" var="file">
				<c:if test="${file.walk_no eq walk.walk_no}">
					<c:set var="walkTitle" value="${walk.title}" scope="page" />
					<c:set var="file_savename" value="${file.savename }" scope="page" />
				</c:if>
			</c:forEach>

			<div class="bg-faded p-4 my-4">
				<div class="card card-inverse">
					<a href="/MiniProject2/walkDetail.do?walk_no=${walk.walk_no}"> <img
						class="card-img img-fluid w-100"
						src="<%=request.getContextPath()%>/upload/${file_savename}" alt="">
					</a>

					<div class="card-img-overlay bg-overlay">
						<h2 class="card-title text-shadow text-white text-uppercase mb-0">Title : ${walkTitle }</h2>
						<h4 class="text-shadow text-white">${walk.reg_date}</h4>
						<%-- <p
							class="lead card-text text-shadow text-white w-50 d-none d-lg-block">${walk.content }</p> --%>
						<a
							href="<%=request.getContextPath()%>/walkDetail.do?walk_no=${walk.walk_no}"
							class="btn btn-secondary">Read More</a>
					</div>
				</div>
			</div>


		</c:forEach>

		<!-- Pagination -->
		<!-- 페이징 시작 -->
		<div class="bg-faded p-4 my-4">
			<ul class="pagination justify-content-center mb-0">
				<c:if test="${count >0}">
					<c:choose>
						<c:when test="${currentPage eq 1 }">
							<li class="page-item disabled"><a class="page-link" href="#">&larr; Older
									</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/walk.do?pageNum=${currentPage-1}">
									&larr; Older </a></li>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${currentPage eq pageCount }">
							<li class="page-item disabled"><a class="page-link" href="#">Newer
									&rarr;</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/walk.do?pageNum=${currentPage+1}">
									 Newer &rarr;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
			</ul>
		</div>
		<!-- 페이징 종료 -->

	</div>

	<!-- /.container -->

	<jsp:include page="/include/bottom.jsp" />

	<!-- Bootstrap core JavaScript -->
	<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/popper/popper.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
