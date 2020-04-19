<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>답글 작성</title>
<script src="/js/isNull.js"></script>
<script>
	function checkForm(){
		
		var com = document.comment;
		
		if(inNull(com.title, "Title을 입력하세요.")){
			return false;
			}
		
		if(inNull(com.content, "Content를 입력하세요.")){
			return false;
		}
		return true;
	}
	
	function doAction(){
		
		history.back();
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
	<div  class="container">
			<form name="comment" action="<%= request.getContextPath() %>/marketComment.do?no=<%=request.getParameter("no") %>" method="post" onsubmit="return checkForm()">
				<input type="hidden" name="writer" value="${ userVO.id }"/>
				<table class="table table-bordered">
					<tr>
						<th>제목</th>
						<td><input name="title" size="50" maxlength="100" value="[Re] "></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${ userVO.id }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" cols="50" rows="13"></textarea></td>
					</tr>
					<tr align="center">
						<td colspan="2">
						<input type="submit" value="등록" class="btn btn-secondary"/> &nbsp; 
						<input type="reset" value="취소" class="btn btn-secondary"/> &nbsp; 
						<input type="button" value="뒤로 가기" onclick="doAction()" class="btn btn-secondary"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		

		
		
		
		
		
		
		
		
		
		
		
		
	</section>
	
    <!-- Footer -->
    <footer>
         		<jsp:include page="/include/bottom.jsp"/>

    </footer>

			<jsp:include page="/include/modal.jsp"/>

	
</body>
</html>