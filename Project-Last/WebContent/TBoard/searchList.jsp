<%@page import="kr.co.bit.TipBoard.vo.TBoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.bit.dao.TipBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8" lang="ko">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>사슴벌레를 사랑하는 사람들의 모임</title>

<script>

	function goWriteForm(){
	    
	    location.href="/Project-Web/writeForm.do"; //같은폴더에 있으니 이렇게써도 무관
	 }
	
	   function goDetail(no){
    	   
			location.href ="/Project-Web/detail.do" + "?no=" + no;
 			/* <c:choose>
				<c:when test="${ not empty membVO }">
					location.href ="detail.jsp?no=" + boardNo;
				</c:when>
				<c:otherwise>
					if(confirm("로그인 후 사용 가능합니다.\n로그인하시겠습니까?")) {
						location.href = "/Mission-Web/jsp/login/login.jsp";
					}
				</c:otherwise>
			</c:choose>	 */
      }
	
	
	function goJoinForm(){
		
		location.href = "/Project-Web/Join.do";
		
	}
	

	$(document).ready(function() {
		$('#example').DataTable();
	});
	
	
	
	
	
	
	
</script>

<!-- table css link -->
<link
	href='https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css'
	rel='stylesheet' type='text/css'>


</head>

<body>

	<jsp:include page="/include/topmenu.jsp"/>

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
	<div class="row" align="center">
    <div class="col-md-12">
	<table id="example" class="table table-striped table-bordered" cellspacing="0" style = "width : 70%"  >
		<thead>
			<tr>
				<th width="10%" style="text-align: center">No</th>
				<th width="40%" style="text-align: center">Title</th>
				<th width="20%" style="text-align: center">Writer</th>
				<th width="20%" style="text-align: center">Date</th>
				<th width="10%" style="text-align: center">ViewCnt</th>
			</tr>
		</thead>
		<c:forEach var="tboard" items="${ tboard }" varStatus="loop">
			 <tbody>
			  <tr>
            <td> ${ tboard.no } </td>
            <td>
           		 <a href="javascript:goDetail('${ tboard.no }')">
            	 ${ tboard.title} 
           		 </a>
             </td>
            <td>${ tboard.writer }</td>
            <td>${ tboard.regDate }</td>
            <td>${ tboard.viewCnt }</td> 
         </tr>
         </tbody>
		</c:forEach>
	</table>
		</div>
	</div>
	<br />
	<br />
	<c:if test="${ not empty userVO }">
		
		<div class="row" align="center" >
    		<div class="col-md-12">
		<form  name = "search" action = "/Project-Web/tSearch.do" method = "POST">
			<input type="button" class = "btn btn-primary" value="Write" onclick="goWriteForm()"/>
			<input type="submit" class = "btn btn-primary" value="Search"/>
			<input type = "text" name = "writer" size ="25" placeholder="글쓴이를 입력해주세요"/>
		</form>
			</div>
		</div> 
	</c:if>

	<!-- Footer -->
	
	<footer>
		   		<jsp:include page="/include/bottom.jsp"/>

	</footer>

        		<jsp:include page="/include/modal.jsp"/>
 		
</body>

</html>
