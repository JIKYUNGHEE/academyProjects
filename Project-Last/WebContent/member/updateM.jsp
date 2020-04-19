<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>
  </head>
  
  <script type="text/javascript">
  function doAction(type) { 
		switch(type){
		case 'U' :
			if(confirm("수정하시겠습니까?")) {
				location.href = "<%=request.getContextPath()%>/updateM.do";
			}
			break;
		case 'D' : 
			if(confirm("삭제하시겠습니까?")) {
				location.href = "<%=request.getContextPath()%>/member/deleteM.jsp?id=${userVO.id}";
			}
			break;
		case 'M' : 
			location.href="<%=request.getContextPath()%>/mypage.do";
			break;
		
		case 'LM' : 
			location.href="<%=request.getContextPath()%>/listM.do";
			break;
		
		}
		
	}
  </script>

  <body>

      		<jsp:include page="/include/topmenu.jsp"/>
   

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('<%=request.getContextPath()%>/Resources/img/grass.jpg'); height: 200px;" >
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading" style="padding: 70px 0">
              <h1>My Page</h1>
              <span class="subheading"></span>
            </div>
          </div>
        </div>
      </div>
    </header>
 
    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
        <h3 align="center">정보수정</h3>
        <hr>
        <form name="updateMForm" method="get" action="<%= request.getContextPath() %>/updateM.do" onsubmit="true" enctype="multipart/form-data">
         	<table width="70%">
         		<tr>
         			<th width="30%" align="right">아이디</th>
         			<td>${userVO.id}<input type="hidden" name="id" value="${userVO.id}"/></td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">이름</th>
         			<td>${userVO.name}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">비밀번호</th>
         			<td><input type="text" name="pw" value="${userVO.pw}" required=""/></td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">전화번호</th>
         			<td><input type="text" name="tel" value="${userVO.tel}"/></td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">주소</th>
         			<td><input type="text" name="addr" value="${userVO.addr}"/></td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">회원유형</th>
         			<td>${userVO.type}</td>
         		</tr>
         		<c:if test="${userVO.type eq 'U' }">
         		<tr>
         			<th width="30%" align="right">포인트</th>
         			<td>${userVO.point}<input type="hidden" name="point" value="${userVO.point}"/></td>
         		</tr>
         		</c:if>
         		<c:if test="${userVO.type eq 'S' }">
         		<tr>
         			<th width="30%" align="right">포인트</th>
         			<td><input type="text" name="point" value="${userVO.point}"/></td>
         		</tr>
         		</c:if>
         		<c:if test="${userVO.type eq 'U' }">
         		<tr>
         			<th width="30%" align="right">등급</th>
         			<td>${userVO.grade}<input type="hidden" name="grade" value="${userVO.grade}"/></td>
         		</tr>
         		</c:if>
         		<c:if test="${userVO.type eq 'S' }">
         		<tr>
         			<th width="30%" align="right">등급</th>
         			<td><input type="text" name="grade" value="${userVO.grade}"/></td>
         		</tr>
         		</c:if>
         		
         	</table>
         <hr/>
         	<div align="right">
         	<input type="button" class="btn btn-secondary" name="list" value="뒤로가기" onclick="doAction('M')">
         	<input type="submit" class="btn btn-secondary" value="저장">
         	</div>
			</form>
         </div>
       </div>
    </div>

    
    <hr>

    <!-- Footer -->
    <footer>
         		<jsp:include page="/include/bottom.jsp"/>

    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="Resources/vendor/jquery/jquery.min.js"></script>
    <script src="Resources/vendor/popper/popper.min.js"></script>
    <script src="Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="Resources/js/jqBootstrapValidation.js"></script>
    <script src="Resources/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="Resources/js/clean-blog.min.js"></script>

	



  </body>

</html>
