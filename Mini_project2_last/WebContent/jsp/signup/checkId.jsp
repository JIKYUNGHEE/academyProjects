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

	function goOpener(){
		
		var f = document.sForm;
		
		if (f.id.value == "") {
			alert("ERROR : 아이디를 입력하세요!");
			f.id.focus();
			return false;
		} 
		
		var name = opener.name;
		name = "오프너";
		f.target = name;
		f.action = "<%= request.getContextPath() %>/checkid.do?id=" + f.id.value;
		f.submit();
		
		return true;
	}

</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/board.css">
</head>
<body>             
	
	<div class="bg-faded p-4 my-4" align="center">
	        <hr class="divider">
	        <h2 class="text-center text-lg text-uppercase my-0">
	          <strong>♥ ID 중복체크 ♥</strong>
	        </h2>
	        <hr class="divider">
	        <form action="<%= request.getContextPath() %>/checkid.do" method="post" name="sForm" >
				<table style="width: 70%" class="type11">
					<tr>
						<th scope="cols" width="25%"  height="30px">아이디</th>
						<td colspan="2">
							<input type="text" name="id" size="40" style="width: 99%;">
						</td>
						<td>
							<input id="checkid_btn" type="button" style="width: 90%;"value="중복체크"  onclick="return goOpener()">
						</td>
					</tr>
				</table>
				<br>
			</form>
			<br><br>
		</div>
	
</body>
</html>