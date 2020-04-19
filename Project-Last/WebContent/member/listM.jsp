<%@page import="kr.co.bit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
  function goDetail(id){
	  location.href = "<%=request.getContextPath()%>/detailM.do?id="+id;

  }
  
  
  function doAction(type) { 
		switch(type){
		case 'U' :
			if(confirm("수정하시겠습니까?")) {
				location.href = "";
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
              <h1>admin page</h1>
              <span class="subheading"></span>
            </div>
          </div>
        </div>
      </div>
    </header>
 
    <!-- Main Content -->
   <body>
   <section>
	<div class="container col-lg-8 col-md-10 mx-auto" align="center">
		
		<hr width="80%">
		<h2>회원목록</h2>
		<hr width="80%">
	
		<br>
		<table width="80%">
			<tr>
				<th><font color="gray">이름</font></th>
				<th><font color="gray">아이디</font></th>
				<th><font color="gray">비밀번호</font></th>
				<th><font color="gray">타입</font></th>
			</tr>
			<c:forEach items="${list}" var="member">

				<tr>
					<td><a href="javascript:goDetail('${ member.id }')"> 
							<c:out value="${member.name}" />
					</a></td>
					<td>${ member.id }</td>
					<td>${ member.pw }</td>
					<td>${ member.type }</td>

				</tr>
			</c:forEach>
			
		</table>
		<br>
		<br> 
		 <hr/>
         	<div align="right">
         	<input type="button" class="btn btn-secondary" name="list" value="뒤로가기" onclick="doAction('M')">
         	</div>



	</div>
	
	</section>
   
        		<jsp:include page="/include/modal.jsp"/>

    <hr>

    <!-- Footer -->
    <footer>
         		<jsp:include page="/include/bottom.jsp"/>

    </footer>


  </body>

</html>
