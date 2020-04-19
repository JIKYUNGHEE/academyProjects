<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	/* 로그인 */
  	function start(){
		$('div.modal').modal({
    		remote : 'jsp/login/login.jsp'
    	});
    }
  	/* 카카오 회원가입창 */
  	function signupKko(id, password, email_id, email_domain, nickname, sign_type){
		$('div.modal').modal({
    		remote : 'jsp/signup/signupForm_kko.jsp?id=' + id + '&password=' + password
    					+ "&email_id=" + email_id + "&email_domain=" + email_domain 
    					+ "&nickname=" + nickname + "&sign_type=" + sign_type
    	});
    }
  	/* 일반 회원가입창 */
  	function signupModal(){
		$('div.modal').modal({
    		remote : 'jsp/signup/signupForm.jsp'
    	});
    }
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/NewFile.css">
</head>
<c:choose>
	<c:when test="${ param.log eq 'kko' }">
		<body onload="signupKko('${ param.id }', '${ param.password }',
								'${ param.email_id }', '${ param.email_domain }',
								'${ param.nickname }', '${ param.sign_type }');">
	</c:when>
	<c:when test="${ param.log eq 'modal' }">
		<body onload="signupModal();">
	</c:when>
	<c:when test="${ param.sign eq 'modal' }">
		<body onload="start();">
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>
<div id="div1">
        <p id="p1">BLER MOA</p>
        <p id="p2">Starbucks Tumbler Review</p>
        <br>
       <button id="btn" onclick="start()">Start</button><br/>
	<div class="modal fade">
 	 <div class="modal-dialog">
	    <div class="modal-content">
 	   </div>
	  </div>
	</div>
 </div>
</body>
</html>
