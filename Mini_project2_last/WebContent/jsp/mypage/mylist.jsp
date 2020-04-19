<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BLER MOA - Starbucks Tumbler review</title>

<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

<script type="text/javascript">

	function doAction(type, boardNo) {
		
		switch (type) {
		case 'V':
			location.href = "<%= request.getContextPath() %>/BoardDetail.do?no=" + boardNo;
			break;
		case 'D':
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href = "<%= request.getContextPath() %>/boardDelete.do?no=" + boardNo;
			}
			break;
		case 'U':
			location.href="<%=request.getContextPath()%>/BoardUpdateForm.do?no="+boardNo+"&type="+type;
			break;
		default:
			break;
		}
	}
	
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/board2.css">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div class="container">
	      <div class="bg-faded p-4 my-4" align="center">
	        <hr class="divider">
	        <h2 class="text-center text-lg text-uppercase my-0">
	          <strong>♥${ loginUser.nickname }♥님 게시물 List</strong>
	        </h2>
	        <hr class="divider">
	        <form action="<%= request.getContextPath() %>/BoardDetail.do" method="post">
				<table style="width: 80%" class="type11">
					<thead>
						<tr>
							<th scope="cols" width="8%">번호</th>
							<th scope="cols">제목</th>
							<th scope="cols" width="13%">작성자</th>
							<th scope="cols" width="13%">등록일</th>
							<th scope="cols" colspan="3" width="25%">내 글관리</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ list }" var="board" varStatus="loop">
						<tr <c:if test="${ loop.count mod 2 eq 0 }">class="even"</c:if>>
							<td>${ board.no }</td>
							<td>${ board.title }</td>
							<td>${ board.writer }</td>
							<td>${ board.regDate }</td>
							<td>
								<input type="button" value="보기" onclick="doAction('V','${ board.no }')">
							</td>
							<td>
								<input type="button" value="수정" onclick="doAction('U','${ board.no }')">
							</td>
							<td>
								<input type="button" value="삭제" onclick="doAction('D','${ board.no }')">
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			<br><br>
	      </div>
	    </div>
	    <!-- /.container -->
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