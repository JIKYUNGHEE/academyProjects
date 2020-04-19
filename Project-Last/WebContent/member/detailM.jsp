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
  
  
  function goDelete(id){
	  location.href = "<%=request.getContextPath()%>/deleteM.do?id="+id;
	  
  }
  
  
  
  
  function doAction(type) { 
		switch(type){
		case 'U' :
			if(confirm("수정하시겠습니까?")) {
				location.href = "<%= request.getContextPath()%>/member/updateM.jsp";
			}
			break;
		case 'M' : 
			location.href="<%=request.getContextPath()%>/index.do";
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
        <h3 align="center">회원정보</h3>
        <hr>
         	<table width="70%">
         		<tr>
         			<th width="30%" align="right">아이디</th>
         			<td>${member.id}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">이름</th>
         			<td>${member.name}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">비밀번호</th>
         			<td>${member.pw}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">전화번호</th>
         			<td>${member.tel}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">주소</th>
         			<td>${member.addr}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">회원유형</th>
         			<td>${member.type}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">포인트</th>
         			<td>${member.point}</td>
         		</tr>
         		<tr>
         			<th width="30%" align="right">등급</th>
         			<td>${member.grade}</td>
         		</tr>
         		
         	</table>
         <hr/>
         	<div align="right">
         	<input type="button" class="btn btn-secondary" name="list" value="메인" onclick="doAction('M')">
         	<input type="button" class="btn btn-secondary" name="list"  onclick="doAction('U')" value="수정">
         		<c:if test="${userVO.type eq 'S'}">
         	<input type="button" class="btn btn-secondary"  onclick="doAction('LM')" name="list" value="회원목록">
         	<input type="button" class="btn btn-secondary"  onclick="javascript:goDelete('${ member.id }')" name="list" value="삭제">
         		</c:if>
         	</div>
         </div>
       </div>
    </div>
  
        		<jsp:include page="/include/modal.jsp"/>

    <hr>

    <!-- Footer -->
    <footer>
         		<jsp:include page="/include/bottom.jsp"/>

    </footer>

 


  </body>

</html>
