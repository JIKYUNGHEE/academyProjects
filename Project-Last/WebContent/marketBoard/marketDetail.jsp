<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>분양 게시글 상세 보기</title>

<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/isNull.js"></script>
<script>

	$(document).ready(function(){
		$('#com').click(function(){
			
			location.href= "<%= request.getContextPath() %>/marketBoard/marketComment.jsp?no=${marketDetail.no} ";
		});
		
		// 댓글 등록
		$('#replyBtn').click(function() {

			$.ajax({
				url : '<%= request.getContextPath()%>/marketReply.do',
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
		// 수정
		$('#upReply').click(function(){
			alert('서비스 준비 중입니다.');
		});
	});

	function doReply() {
		var reply = document.reply;

		if (isNull(reply.content), "내용을 입력해 주세요.") {
			return false;
		}
		return true;
	}
	
	// 게시글
	function doAction(type){
		
		switch(type){
		// 뒤로가기
		case 'B':
			if(confirm('뒤로 가시겠습니까?')){
				location.href="<%= request.getContextPath()%>/sellList.do";
			}
	/* 		history.back(); */
			break;
		//삭제
		case 'D':
			if(confirm('정말 지우실 거예요?')){
				location.href="<%= request.getContextPath()%>/marketDelete.do?no=${ marketDetail.no}";
			}
			break;
		//수정
		case 'U':
			if(confirm('수정하시겠습니까?')){
				location.href="<%= request.getContextPath()%>/marketBoardUpdate.do?no=${marketDetail.no}";
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
	
	
	<section>
		<div class="container">
   
		<table class="table table-bordered">
            <tr>
					<th width="25%">번호</th>
					<td>${ marketDetail.no }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${ marketDetail.title }</td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td>${ marketDetail.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${ marketDetail.content }</td>
				<%-- 	<td><c:out value="${ tvo.content }" /></td>  --%>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${ marketDetail.viewCnt }</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${ marketDetail.regDate }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<c:forEach items="${ tFileList2 }" var="tFile">
							<img src="<%=request.getContextPath()%>/upload/${ tFile.fileSaveName }" width="250px"> 
							<a href="<%=request.getContextPath() %>/upload/${ tFile.fileSaveName }" target="_blank">
								${ tFile.fileOriName }	
							</a>
							(${ tFile.fileSize } bytes))	<br/>				
						</c:forEach>
					</td>
				</tr>
			</table>
	
		<button onclick="doAction('B')" class="btn btn-secondary">뒤로 가기</button>
			<c:if test="${ userVO.id  eq  tvo.writer }">
				<button onclick="doAction('U')" class="btn btn-secondary">수정</button>
				<button onclick="doAction('D')" class="btn btn-secondary">삭제</button>
			</c:if>
		<button id="com" class="btn btn-secondary">답글</button>
		<br/><br/>
	
		
		<div id="btn">
			<div id="reply">
			<table>
				<c:if test="${ not empty marketRepList }">
				<c:forEach items="${ marketRepList }" var="reply">
						<tr>
							<th><img src=''/><input type="hidden" id="no" name="no" value="${ reply.no }"/></th>
							<th>${ reply.writer } &nbsp;&nbsp;&nbsp;</th>
							<th>${ reply.regDate } &nbsp;&nbsp;&nbsp;</th>
								<c:if test = "${ reply.writer eq  userVO.id }">
									<td><a href="" id="upReply" class="btn btn-secondary">수정</a>&nbsp;&nbsp;&nbsp;</td>
									<td><a href="<%= request.getContextPath() %>/marketReplyDel.do?no=${ reply.no }&reply_no=${marketDetail.no}" class="btn btn-secondary">삭제</a></td>
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
				<input type="hidden" id="replyNo" name="replyNo" value="${ marketDetail.no }" />
				<table>
					<tr>
						<th><textarea id="replyCon" rows="3" cols="56" name="content"></textarea></th>&nbsp;&nbsp;&nbsp;
						<th><input id="replyBtn" type="button" value="전송"  class="btn btn-secondary" /></th>
					</tr>
				</table>
				</form>
			</div>
		</div>
		</div>
		
		
		<!-- 전체 댓글창 -->
		
	</section>
	
	
	
	
	<footer> <jsp:include page="/include/bottom.jsp" /> </footer>

	

	<jsp:include page="/include/modal.jsp" />
</body>
</html>