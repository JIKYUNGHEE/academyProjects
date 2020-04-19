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
	
 	function doAction(type, id) {
		switch (type) {
		case 'V':
			location.href = "<%= request.getContextPath() %>/detailinfo.do?id=" + id;
			break;
		case 'D':
			if (confirm("정말 삭제하시겠습니까?")) {
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
 	
 	function toggle() {
		var check = false;
		var cnt = 0;
		var checkmember = document.inputForm.checkmember;
		
		// cnt와 i가 같이 증가할때만 cnt ++
		for (var i = 0; i < checkmember.length && cnt == i; i++) {
			if (checkmember[i].checked) {
				cnt++;
			}
		}
		// cnt와 총길이 다르면(전체 선택된 경우를 제외하고) 모두 선택
		if (cnt != checkmember.length) {
			check = true;
		}
		for (var i = 0; i < checkmember.length; i++) {
			checkmember[i].checked = check;
		}
	}
	
	function checkValues() {
		// 2) 배열로 읽고 출력
		var checkmember = document.inputForm.checkmember;
		var list = "";
		var index = 0;
		for ( var i in checkmember) {
			if (checkmember[i].checked) {
				if (index != 0) {
					list +=  "-" + checkmember[i].value;
				} else if (index == 0) {
					list = checkmember[i].value;
				}
				index++;
			}
		}
		//alert(list);
		return list;
	}
	
	function deleteCheck() {
		var id = checkValues();
		var idArr = id.split('-');
		for (var i in idArr) {
			alert(idArr[i]);
		}
		
		var str = "";
		if (confirm("정말 삭제하시겠습니까?")) {
			for (var i in idArr) {
				if (i != 0) {
					str += "&id=" + idArr[i];
				} else if (i == 0) {
					str = "id=" + idArr[i];
				}
				//alert(str);
				location.href = "<%= request.getContextPath() %>/deleteuser.do?" + str;
			}
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
	          <strong>회원 List</strong>
	        </h2>
	        <hr class="divider">
	        <form action="<%= request.getContextPath() %>/detailInfo.do" method="post" name="inputForm">
				<table style="width: 80%; max-width: 800px;" class="type11">
					<thead>
						<tr>
							<th scope="cols" width="5%"><input type="checkbox" name="checkAll" onclick="toggle()"></th>
							<th scope="cols" style="width: 8%">타입</th>
							<th scope="cols">ID</th>
							<th scope="cols" style="width: 15%">닉네임</th>
							<th scope="cols" style="width: 15%">이메일</th>
							<th scope="cols" style="width: 15%">가입일</th>
							<th scope="cols" colspan="3" width="30%">회원관리</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ requestScope.userList }" var="userList">
							<tr>
								<c:choose>
									<c:when test="${ loginUser.id eq userList.id }">
										<td><input type="checkbox" name="checkmember" onclick="return false" ></td>
									</c:when>
									<c:otherwise>
										<td><input type="checkbox" name="checkmember" value="${ userList.id }"></td>
									</c:otherwise>
								</c:choose>
								<td>${ userList.type }</td>
								<td>${ userList.id }</td>
								<td>${ userList.nickname }</td>
								<td>${ userList.email_id }@${ userList.email_domain }</td>
								<td>${ userList.reg_date }</td>
								<td>
									<input type="button" value="보기" onclick="doAction('V','${ userList.id }')">
								</td>
								<td>
									<input type="button" value="수정" onclick="doAction('U','${ userList.id }')">
								</td>
								<td>
									<%-- <c:choose>
										<c:when test="${ loginUser.id eq userList.id }">
											<input type="button" value="탈퇴" onclick="return false">
										</c:when>
										<c:otherwise>
											<input type="button" value="탈퇴" onclick="doAction('D','${ userList.id }')">
										</c:otherwise>
									</c:choose> --%>
									<input type="button" value="탈퇴" onclick="doAction('D','${ userList.id }')">
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			<div align="right" style="width: 80%">
				<br>
				<!-- <input type="button" value="값" onclick="checkValues()">&nbsp;&nbsp; -->
				<input type="button" value="삭제" onclick="deleteCheck()">&nbsp;&nbsp;
			</div>
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