<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
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
<style type="text/css">
	.my_btn {
		display : block;
		padding : 1em 3.2em;
		border-radius : 1.6em;
		color : #fff;
		font-size : 18px;
		font-family : 'Lato', sans-serif;
		font-weight : 700;
		text-align : center;
		text-decoration : none;
		background-color : #9282CD;
		box-shadow : 0 5px 20px gray;
	}

</style>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div class="container">
	      <div class="bg-faded p-4 my-4">
	        <hr class="divider">
	        <h2 class="text-center text-lg text-uppercase my-0">
	          <strong>♥${ loginUser.nickname }♥님 MyPage</strong>
	        </h2>
	        <hr class="divider">
	        <table align="center">
	        	<tr>
	        		<th style="padding: 15px;">
				        <!-- 내정보 링크  -->
				        <a class="my_btn" href="<%= request.getContextPath() %>/detailinfo.do?id=${ loginUser.id }">내정보</a>
	        		</th>
	        		<th style="padding: 15px;">
				        <!-- 내글보기 링크  -->
				        <!-- <a class="my_btn" href="#">내글보기</a> -->
				        <a class="my_btn" href="<%= request.getContextPath() %>/mylist.do?id=${ loginUser.id }">내글보기</a>
	        		</th>
	        	</tr>
	        </table>
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