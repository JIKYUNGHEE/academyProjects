<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>


</style>

    
    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/Resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="<%= request.getContextPath() %>/Resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/Resources/css/clean-blog.min.css" rel="stylesheet">
    
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="<%= request.getContextPath() %>/index.do"><h4>사슴벌레 너무좋앙</h4></a>
		
			<span class="navbar-brand">
			<c:if test="${empty userVO}"> 
				<a href="#login" data-toggle="modal" >
					<font size="2pt" color="white">로그인 해주세요.</font>
				</a>
			</c:if>
			
				<c:if test="${not empty userVO }">
				<font size="2pt">	<b>[${userVO.id}</b>님 사슴벌레가 우리곁에 있어용]<br/>
				 <font size="2pt">포인트: <b>${userVO.point}</b> 등급:<b> ${userVO.grade}</b></font>
				</font>
				</c:if>
			
				</span>

			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<c:if test="${ empty userVO }">
					<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/index.do">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#login" data-toggle="modal" >TipBoard</a></li>
					<li class="nav-item"><a class="nav-link" href="#login" data-toggle="modal" >SellBoard</a></li>
					<li class="nav-item"><a class="nav-link" href="#login" data-toggle="modal" >Contact</a></li>
					<li class="nav-item"><a class="nav-link" href="#login" data-toggle="modal">Album</a></li>
					<li class="nav-item"><a class="nav-link" href="#login" data-toggle="modal" >Login</a></li> 
					</c:if>
					<c:if test="${ not empty userVO }">
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/index.do">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/tipList.do">TipBoard</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/sellList.do">SellBoard</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Notice.jsp">Contact</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/album.do">Album</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/logout.do">Logout</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/mypage.do">MyPage</a></li>
						
						
						
						
						
						
						
					</c:if>
				</ul>
			</div>
		</div>
	</nav>










