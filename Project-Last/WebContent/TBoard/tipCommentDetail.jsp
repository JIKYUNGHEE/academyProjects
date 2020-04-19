<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function doAction(type){
		
		switch(type){
		// 뒤로가기
		case 'B':
			history.back();
			break;
		//삭제
		case 'D':
			if(confirm('정말 지우실 거예요?')){
				location.href="<%= request.getContextPath() %>/tipComDelete.do?no=${ tcvo.no }";
			}
			break;
		//수정
		case 'U':
			alert('서비스 준비 중입니다.');
			break;
		}
	}

</script>
</head>
<body>
	   		<jsp:include page="/include/topmenu.jsp"/>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('<%= request.getContextPath() %>/Resources/img/grass.jpg'); height: 200px;" >
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading" style="padding: 70px 0">
              <h1>Sell Board</h1>
              <span class="subheading"></span>
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
					<td>${ tcvo.no }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${ tcvo.title }</td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td>${ tcvo.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${ tcvo.content }</td>
				
				</tr>
				<tr>
					<th>조회수</th>
					<td>${ tcvo.viewCnt }</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${ tcvo.regDate }</td>
				</tr>
				
			</table>
			
			<br/><br/>
			<div class="row" align="center">
    			<div class="col-md-12">
					<c:if test="${ userVO.id  eq  tcvo.writer }">
						<button onclick="doAction('U')" class="btn btn-secondary">수정</button>&nbsp;&nbsp;
						<button onclick="doAction('D')" class="btn btn-secondary">삭제</button>&nbsp;&nbsp;
					</c:if> 
					<button onclick="doAction('B')" class="btn btn-secondary">목록</button>
				</div>
			</div>
			
       
</div>
	</section>

    <!-- Footer -->
    <footer>
         		<jsp:include page="/include/bottom.jsp"/>

    </footer>

			<jsp:include page="/include/modal.jsp"/>

</body>
</html>