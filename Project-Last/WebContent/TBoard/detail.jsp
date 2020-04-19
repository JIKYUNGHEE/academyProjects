<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/isNull.js"></script>
<script>
	$(document).ready(function(){
		$('#com').click(function(){
		
		location.href= "<%=request.getContextPath()%>/TBoard/tipComment.jsp?no=${ tvo.no } ";
		});
	
		// 댓글 등록
		$('#replyBtn').click(function() {
	
			$.ajax({
				url : '<%=request.getContextPath()%>/tipReply.do',
				type : 'POST',
				data : {
						writer : $('#writer').val(),
						content : $('#replyCon').val(),
						replyNo : $('#replyNo').val()
						},
				success : function(data) {
					if(data != null){
						alert("댓글 작성 완료!");
						location.reload();
						}
					}
				});
			});
		
		$('#upReply').click(function(){
			alert('서비스 준비 중입니다.');
		});
	});






	function doAction(type) {
		switch(type) {
		case 'U' : 
			if(confirm("수정 하시겠습니까?")) {
				location.href="<%=request.getContextPath()%>/reWrite.do"+"?no=${ param.no }";
			}
			break;
		case 'D' : 
			if(confirm("삭제 하시겠습니까?")) {
				location.href="<%=request.getContextPath()%>/delete.do"+"?no=${ param.no }";
			}
			break;
		case 'L' : 
			if(confirm("목록으로 돌아가시겠습니까?")) {
				location.href = "<%=request.getContextPath()%>/tipList.do";
			}
			break;
		}
	}
</script>

<!-- table css link -->
<link
	href='https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css'
	rel='stylesheet' type='text/css'>

</head>

<body>
	<jsp:include page="/include/topmenu.jsp" />


	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('<%= request.getContextPath() %>/Resources/img/mindle.jpg'); height: 200px;">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="page-heading" style="padding: 70px 0">
					<h1>Tip Board</h1>
					<span class="subheading">How To Grow ?</span>
				</div>
			</div>
		</div>
	</div>
	</header>
	
	
		<div class="container">
   
		<table class="table table-bordered">
            <tr>
					<th width="25%">번호</th>
					<td>${ tvo.no }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${ tvo.title }</td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td>${ tvo.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${ tvo.content }</td>
				<%-- 	<td><c:out value="${ tvo.content }" /></td>  --%>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${ tvo.viewCnt }</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${ tvo.regDate }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<c:forEach items="${ tFileList }" var="tFile">
							<a href="<%=request.getContextPath() %>/upload/${ tFile.fileSaveName }" target="_blank">
							<img src="<%=request.getContextPath() %>/upload/${ tFile.fileSaveName }" width="250">
								${ tFile.fileOriName }	
							</a>
							(${ tFile.fileSize } bytes)	<br/>				
						</c:forEach>
					</td>
				</tr>
			</table>
			
			<br/><br/>
			<div class="row" align="center">
    			<div class="col-md-12">
					<c:if test="${ userVO.id  eq  tvo.writer }">
						<button onclick="doAction('U')" class="btn btn-secondary">수정</button>&nbsp;&nbsp;
						<button onclick="doAction('D')" class="btn btn-secondary">삭제</button>&nbsp;&nbsp;
					</c:if> 
					<button onclick="doAction('L')" class="btn btn-secondary">목록</button>
					<button id="com" class="btn btn-secondary">답글</button>
				</div>
			</div>
		<div id="btn">
			<div id="reply">
			<table>
				<c:if test="${ not empty tRepList }">
				<c:forEach items="${ tRepList }" var="reply">
						<tr>
							<th><input type="hidden" id="no" name="no" value="${ reply.no }"/></th>
							<th>${ reply.writer } &nbsp;&nbsp;&nbsp;</th>
							<th>${ reply.regDate } &nbsp;&nbsp;&nbsp;</th>
								<c:if test = "${ reply.writer eq  userVO.id }">
									<td><a href="" id="upReply" class="btn btn-secondary">수정</a>&nbsp;&nbsp;&nbsp;</td>
									<td><a href="<%= request.getContextPath() %>/tipReplyDel.do?no=${ reply.no }&reply_no=${ tvo.no }" class="btn btn-secondary">삭제</a></td>
								</c:if>
						</tr>
						<tr><td colspan="5">${ reply.content }</td></tr>
				</c:forEach>
				</c:if>
				</table>
			</div>
			<div>
			<form name="replyForm" method="post">
				<input type="hidden" id="writer" name="writer" value="${ userVO.id }" /> 
				<input type="hidden" id="replyNo" name="replyNo" value="${ tvo.no }" />
				<table>
					<tr>
						<th><textarea id="replyCon" rows="3" cols="56" name="content"></textarea></th>&nbsp;&nbsp;&nbsp;
						<th><input id="replyBtn" type="button" value="댓글 등록"  class="btn btn-secondary" /></th>
					</tr>
				</table>
				</form>
			</div>
		</div>
</div>

	<footer> <jsp:include page="/include/bottom.jsp" /> </footer>

	

	<jsp:include page="/include/modal.jsp" />
</body>
</html>