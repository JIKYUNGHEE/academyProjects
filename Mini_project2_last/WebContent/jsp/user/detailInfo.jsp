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
	
	function doAction(type, id) {
		switch (type) {
		case 'D':
			if (confirm("정말 탈퇴하시겠습니까?")) {
				location.href = "<%= request.getContextPath() %>/deleteuser.do?id=" + id;
			}
			break;
		case 'U':
			location.href = "<%= request.getContextPath() %>/jsp/user/checkPwd.jsp?id=" + id;
			break;
		default:
			break;
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
	          <strong>♥${ userData.nickname }♥님 회원정보</strong>
	        </h2>
	        <hr class="divider">
	        <div align="center">
	        	<c:choose>
	        		<c:when test="${ userData.gender eq 'M' }">
			        	<img alt="" src="<%= request.getContextPath() %>/img/profile/user_M.png">
	        		</c:when>
	        		<c:otherwise>
			        	<img alt="" src="<%= request.getContextPath() %>/img/profile/user_F.png">
	        		</c:otherwise>
	        	</c:choose>
	        </div>
	        <table style="width: 80%;" class="type11">
				<tr>
					<th scope="cols" style="width: 18%">아이디</th>
					<td>${ userData.id }</td>
					<th scope="cols" style="width: 20%">비밀번호</th>
					<td>${ userData.password }</td>
				</tr>
				<tr>
					<th scope="cols">닉네임</th>
					<td>${ userData.nickname }</td>
					<c:if test="${ loginUser.type eq 'U' }">
						<th scope="cols">가입일</th>
						<td>${ userData.reg_date }</td>
					</c:if>
					<c:if test="${ loginUser.type eq 'S' }">
						<th scope="cols">가입 타입</th>
						<td>
							<c:choose>
								<c:when test="${ userData.sign_type eq 'K' }">카카오 회원</c:when>
								<c:otherwise>일반 회원</c:otherwise>
							</c:choose>
						</td>
					</c:if>
				</tr>
				<tr>
					<th scope="cols">이메일</th>
					<td colspan="3">
						${ userData.email_id }@${ userData.email_domain }
					</td>
				</tr>
				<c:if test="${ loginUser.type eq 'S' }">
					<tr>
						<th scope="cols">가입일</th>
						<td colspan="3">${ userData.reg_date }</td>
					</tr>
				</c:if>
			</table>
			<br>
			<c:if test="${ loginUser.type eq 'S' }">
				<input type="button" value="목록" onclick="goUserList()">
			</c:if>
			<c:if test="${ loginUser.type eq 'U' }">
				<div align="right" style="width: 80%;">
					<input type="button" value="수정" onclick="doAction('U','${ userData.id }')">
					<input type="button" value="탈퇴" onclick="doAction('D','${ userData.id }')">
				</div>
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