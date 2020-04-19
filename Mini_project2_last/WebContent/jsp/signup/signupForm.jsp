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
	
	#checkid_btn {
		display : block;
		width: 70px;
		border-radius : 1em;
		border-bottom: none;
		color : #fff;
		font-weight : 700;
		text-align : center;
		text-decoration : none;
		background-color : #9282CD;
		box-shadow : 0 5px 5px gray;
	}
</style>
<script type="text/javascript">
	
	function goMemberList() {
		location.href = "memberList.jsp";
	}
	
	function doSignup() {
		
		var f = document.sForm;
		
		if (f.id.value == "") {
			alert("ERROR : 아이디를 입력하세요!");
			f.id.focus();
			return false;
		} else if (f.password.value == "") {
			alert("ERROR : 비밀번호를 입력하세요!");
			f.password.focus();
			return false;
		} else if (f.email_id.value == "") {
			alert("ERROR : 이메일id를 입력하세요!");
			f.email_id.focus();
			return false;
		} else if (f.email_domain.value == "") {
			alert("ERROR : 이메일domain을 입력하세요!");
			f.email_domain.focus();
			return false;
		} else if (f.nickname.value == "") {
			alert("ERROR : 닉네임을 입력하세요!");
			f.nickname.focus();
			return false;
		}
		
		return true;
	}
	
	function checkEmail(){
		
		var f = document.sForm;
		
		if (f.email_select.value == '') {
	    	f.email_domain.value = "";
		}
		
		if (f.email_select.value == 'etc') {
	    	f.email_domain.readOnly = false;
	    	f.email_domain.value = '';
	    	f.email_domain.focus();
	    }
	    else {
	    	f.email_domain.readOnly = true;
	    	f.email_domain.value = f.email_select.value;
	    }
	}
	
	function checkId(){
		
		var f = document.sForm;
		location.href = "<%= request.getContextPath() %>/checkid.do?id=" + f.id.value;
		
		f.id.focus();
		f.id.value = "${ value }";
		
	}
	
	function popupLink(popWidth, popHeight){ 
		
		var winHeight = document.body.clientHeight;	// 현재창의 높이
		var winWidth = document.body.clientWidth;	// 현재창의 너비
		var winX = window.screenLeft;				// 현재창의 x좌표
		var winY = window.screenTop;				// 현재창의 y좌표

		var popX = winX + (winWidth - popWidth) / 2;
		var popY = winY + (winHeight - popHeight) / 2;
		
		window.open("<%= request.getContextPath() %>/jsp/signup/checkId.jsp",
					"popup","width=" + popWidth + "px,height=" + popHeight + "px,top=" + popY + ",left=" + popX);
		
	}
	
</script>
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
	          <strong>♥ BLER MOA 회원가입♥</strong>
	        </h2>
	        <hr class="divider">
	        <form action="<%= request.getContextPath() %>/signup.do" method="post" name="sForm" onsubmit="return doSignup()">
				<table style="width: 70%" class="type11">
					<tr>
						<th scope="cols" width="25%"  height="30px">아이디</th>
						<td colspan="2">
							<input type="text" name="id" size="40" style="width: 99%;">
						</td>
						<td>
							<input id="checkid_btn" type="button" name="idcheck" style="width: 90%;"
									value="중복체크" onclick="popupLink(400,250)" >
						</td>
					</tr>
					<tr>
						<th scope="cols">비밀번호</th>
						<td colspan="3">
							<input type="password" name="password" size="40"  style="width: 99%" >
						</td>
					</tr>
					<tr>
						<th scope="cols">닉네임</th>
						<td colspan="3">
							<input type="text" name="nickname" size="40"  style="width: 99%" >
						</td>
					</tr>
					<tr>
						<th scope="cols">이메일</th>
						<td colspan="3">
							<input type="text" name="email_id" size="40"  style="width: 25%">
							&nbsp;&#64;&nbsp;
							<input type="text" name="email_domain" size="40"  style="width: 25%" readonly="readonly">
							<select name="email_select" style="width: 38%" onchange="checkEmail()">
								<option value="">선택하세요</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="gmail.com">gmail.com</option>
								<option value="nate.com">nate.com</option>
								<option value="yahoo.com">yahoo.com</option>
								<option value="etc">직접입력</option>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="cols">성별</th>
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
				<!-- 가입타입 B : 고정 -->
				<input type="hidden" name="sign_type" value="B">
				<input type="submit" value="등록">
				<input type="reset" value="모두 지우기" ><br><br>
				<c:if test="${ not empty loginUser } and ${ loginUser.type eq 'S' }">
					<input type="button" value="목록" onclick="goMemberList()">
				</c:if>
			</form>
			<br><br>
		</div>
	
</body>
</html>