<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<style type="text/css">
	th{
	font-family:'Adobe Thai';
	font-size: 15px;
	}
	h1{
	font-family:'Adobe Thai';
	}
	td>input{
	border: none;
	border-bottom:1px solid black;
	}
</style>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/board.css">
</head>
<body>             
	<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" onclick="modalClose()">×</button>
		<h1 class="modal-title">Welcome!</h1>
	</div>
	
	<div class="bg-faded p-4 my-4" align="center">
	        <hr class="divider">
	        <h2 class="text-center text-lg text-uppercase my-0">
	          <strong>♥ BLER MOA  회원가입♥</strong>
	        </h2>
	        <hr class="divider">
	        <form action="<%= request.getContextPath() %>/signupKko.do" method="post" name="sForm" >
				<table style="width: 70%" class="type11">
					<tr>
						<th scope="cols" width="25%"  height="30px">아이디</th>
						<td>
							<input type="text" name="id" size="40" style="width: 99%" 
									value="${ param.id }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th scope="cols">비밀번호</th>
						<td>
							<input type="password" name="password" size="40"  style="width: 99%" 
									value="${ param.password }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th scope="cols">닉네임</th>
						<td>
							<input type="text" name="nickname" size="40"  style="width: 99%" 
									value="${ param.nickname }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th scope="cols">이메일</th>
						<td colspan="3">
							<input type="text" name="email_id" size="40"  style="width: 25%"
									value="${ param.email_id }" readonly="readonly">
							&nbsp;&#64;&nbsp;
							<input type="text" name="email_domain" size="40"  style="width: 25%" value="${ param.email_domain }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th scope="cols" colspan="4">성별을 설정해주세요!</th>
					</tr>
					<tr>
						<td colspan="4">
							<input type="radio" name="gender" value="M" checked>&nbsp;&nbsp;남자
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="gender" value="F" >&nbsp;&nbsp;여자
						</td>
					</tr>
				</table>
				<br>
				<!-- 유저타입 U : 고정 -->
				<input type="hidden" name="type" value="U">
				<!-- 가입타입 K : 고정 -->
				<input type="hidden" name="sign_type" value="${ param.sign_type }">
				<input type="submit" value="등록">
				<input type="reset" value="모두 지우기" ><br><br>
			</form>
			<br><br>
		</div>
	
</body>
</html>