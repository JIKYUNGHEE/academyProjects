<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>


<  <!-- Modal -->
<div class="modal fade"  id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
		<div class="modal-body" align="center">
			<form name="lform" method="post" action="<%= request.getContextPath() %>/login.do" accept-charset="utf-8">
				
				<input type="text" placeholder="아이디" id="id" name="id" size="30" required=""><Br> 
				<input type="password" placeholder="비밀번호" id="pw" name="pw" size="30" required=""><br>
        </div>
			<div class="modal-footer">
        <input class="btn btn-primary" type="submit" id="loginBtn" value="GO">
        <a href="<%= request.getContextPath() %>/join.do">
	        <button type = "button" class = "btn btn-primary">Join</button>
        </a>
       
        </form>
        
               
             
        <div class="login">
            <div class="panel-body">
               <a id="kakao-login-btn" class="btn wow bounceInRight"
                  data-wow-delay="0.8s"></a> <a
                  href="http://developers.kakao.com/logout"></a>
               <script>
               //<![CDATA[
               // 사용할 앱의 JavaScript 키를 설정해 주세요.
                Kakao.init('d2ea6ae59b35975fe29653904660518b');
               // 카카오 로그인 버튼을 생성합니다.
               Kakao.Auth.createLoginButton({
                  container: '#kakao-login-btn',
                  success: function(authObj) {
                           Kakao.API.request({
                           url: '/v1/user/me',
                           success: function(res) {
                              var id = res.kaccount_email;
                              var password = res.id;
                              var name = res.properties.nickname;
                              var mail = res.kaccount_email;
                              
                     
         		  location.href = "<%= request.getContextPath() %>/kakaoLogin.do?id=" + id + "&password=" + password + "&name=" + name + "&mail=" + mail;
                               
                           }
                              })
                           }
                         });
                       //]]>
               </script>
            </div>
         </div>