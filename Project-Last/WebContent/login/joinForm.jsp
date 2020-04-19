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
		style="background-image: url('<%=request.getContextPath()%>/Resources/img/grass.jpg'); height: 200px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading" style="padding: 70px 0">
						<h1>Join Us</h1>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	
	<!--  회원가입 폼 -->
		<div class = "row" align ="center">
			<div class="col-lg-8 col-md-10 mx-auto">
				<form name="JoinForm" class="form" role="form" style = "width : 70%" action ="<%= request.getContextPath() %>/joinForm.do" method = "POST" onsubmit="true";  >
  				<h4>회원 가입</h4>
 				 <div class="row" >
  					 <div class="col-xs-6 col-md-6">
     					 <input type="text" name="id" class="form-control input-lg" placeholder="ID" />
 					   </div>
  				 <div class="col-xs-6 col-md-6">
    				 <input type="password" name="pw" class="form-control input-lg" placeholder="PassWord" />
   				 </div>
 			 </div>
  				<br>
  					<input type="text" name="name" class="form-control input-lg" placeholder="이름" />
  				<br>
 					 <input type="text" name="tel" class="form-control input-lg" placeholder="전화번호" />
  				<br>
 					 <input type="text" name="addr" class="form-control input-lg" placeholder="주소" />
  				<br>
    				<br>
 					 <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">회원가입</button>
			</form>
		</div>
		</div>
		



		<!-- Footer -->
		<footer>
		   		<jsp:include page="/include/bottom.jsp"/>

		</footer>

        		<jsp:include page="/include/modal.jsp"/>
 	
</body>

</html>
