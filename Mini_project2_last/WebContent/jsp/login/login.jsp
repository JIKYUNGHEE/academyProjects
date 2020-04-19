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
	font-size: 25px;
	}
	h1{
	font-family:'Adobe Thai';
	}
	td>input{
	border: none;
	border-bottom:1px solid black;
	}
</style>
<script type="text/javascript">

	function checkForm() {
		var f = document.lForm;
		
		if (isNull(f.id, "ERROR : ID를 입력해주세요!")) {
			return false;
		} 
		if (isNull(f.password, "ERROR : PASSWORD를 입력해주세요!")) {
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>             
	<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" onclick="modalClose()">×</button>
		<h1 class="modal-title">Welcome!</h1>
	</div>
	
	<div align="center" >
		<form name="lform"
			action="<%=request.getContextPath()%>/loginProcess.do" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" size="20" /></td>
				</tr>
				<tr>
					<th>PASSWORD &nbsp</th>
					<td><input type="password" name="password" size="20" /></td>
				</tr>
			</table>
			<br> 
			<input TYPE="IMAGE" src="<%=request.getContextPath()%>/img/login_btn.png"
				name="Submit" value="Submit" align="absmiddle"
				style="border-radius: 3px"> 
			<a href="<%=request.getContextPath()%>?log=modal">
				<img src="<%=request.getContextPath()%>/img/signup_btn.png" style="border-radius: 3px" />
			</a>
		</form>
		<br>
	</div>
	
	<div class="modal-footer" style="text-align: center;" >
		<a id="kakao-login-btn"></a>
		<script type='text/javascript'>
			//<![CDATA[
			// 사용할 앱의 JavaScript 키를 설정해 주세요.
			Kakao.init('886b4cf9d386febfb9071686da184752');
			// 카카오 로그인 버튼을 생성합니다.
			Kakao.Auth.createLoginButton({
				container : '#kakao-login-btn',
				success : function(authObj) {
				// 로그인 성공시, API를 호출합니다.
				Kakao.API.request({
					url : '/v1/user/me',
					 success: function(res) {
						 /* 
						 	카카오 메일 id = id / email_id
						 	카카오 id = password
						 	카카오 메일 domain = email_domain
						 	카카오 닉네임 = nickname
						 */
						 var password = res.id;
						 var fullemail = res.kaccount_email;
						 var emailArr = fullemail.split('@');
						 var email_id = emailArr[0];
						 var email_domain = emailArr[1];
						 var nickname = encodeURIComponent(res.properties.nickname);
				         location.href = "<%=request.getContextPath()%>/loginProcessKko.do?id="
				        		 			+ email_id + "&password=" + password
				        		 			+ "&email_id=" + email_id + "&email_domain=" + email_domain 
				        		 			+ "&nickname=" + nickname;
				     },
				     fail: function(error) {
				         alert(JSON.stringify(error));
				     }
				});
			},
				fail: function(err) {
					alert(JSON.stringify(err));
				}
			});
			//]]>
		</script>
	</div>
</body>
</html>