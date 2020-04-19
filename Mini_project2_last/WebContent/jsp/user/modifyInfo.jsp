<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript">

	
	function goUserList() {
		location.href = "<%= request.getContextPath() %>/userlist.do";
	}
	
	function doSignup(sign_type) {
		
		var f = document.sForm;
		
		if (sign_type == 'B' && f.password.value == "") {
			alert("ERROR : 수정할 비밀번호를 입력하세요!");
			f.password.focus();
			return false;
		}  else if (f.nickname.value == "") {
			alert("ERROR : 수정할 닉네임을 입력하세요!");
			f.email_id.focus();
			return false;
		}	else if (f.email_id.value == "") {
			alert("ERROR : 수정할 이메일id를 입력하세요!");
			f.email_id.focus();
			return false;
		} else if (f.email_domain.value == "") {
			alert("ERROR : 수정할 이메일domain을 입력하세요!");
			f.email_domain.focus();
			return false;
		}
		
		if (sign_type == 'B') {
			f.action = "<%= request.getContextPath() %>/modifyinfo.do";
		} else if (sign_type == 'K') {
			f.action = "<%= request.getContextPath() %>/modifyinfoKko.do";
		} 
		
	    f.submit();
		return true;
	}

	function checkEmail(){
			
		var sf = document.sForm;
		
		if (sf.email_select.value == '') {
	       	sf.email_domain.value = "";
		}
		
		if (sf.email_select.value == 'etc') {
	       	sf.email_domain.readOnly = false;
	       	sf.email_domain.value = '';
	       	sf.email_domain.focus();
	       }
	       else {
	       	sf.email_domain.readOnly = true;
	       	sf.email_domain.value = sf.email_select.value;
	       }
	}
	
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/board.css">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div class="container">
	      <div class="bg-faded p-4 my-4" align="center">
	        <hr class="divider">
	        <h2 class="text-center text-lg text-uppercase my-0">
	          <strong>♥${ loginUser.nickname }♥님 회원정보 수정</strong>
	        </h2>
	        <hr class="divider">
	        <form method="post"  action="" name="sForm" onsubmit="return doSignup('${ loginUser.sign_type }')">
				<table style="width: 70%;" class="type11" id="modifyTable">
					<tr>
						<th scope="cols" width="25%"  height="30px">아이디</th>
						<td>
							<input type="text" name="id" size="40" style="width: 99%" 
									readonly="readonly" value="${ loginUser.id }">
						</td>
					</tr>
					<c:if test="${ loginUser.sign_type eq 'B' }">
						<tr>
							<th scope="cols">비밀번호</th>
							<td>
								<input type="password" name="password" size="40"  style="width: 99%">
							</td>
						</tr>
					</c:if>
					<tr>
						<th scope="cols">닉네임</th>
						<td>
							<input type="text" name="nickname" size="40"  style="width: 99%">
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
				</table>
				<br>
				<input type="submit" value="수정" >
				<input type="reset" value="모두 지우기" >
				<br><br>
			</form>
			<br>
			<c:if test="${ loginUser.type eq 'S' }">
				<input type="button" value="목록" onclick="goUserList()">
			</c:if>
			<br><br>
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