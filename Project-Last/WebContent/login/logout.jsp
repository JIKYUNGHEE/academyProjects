<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src='https://developers.kakao.com/sdk/js/kakao.min.js'></script>
<script>
	alert('로그아웃 되었습니다.');
	location.href = "<%=request.getContextPath()%>/index.do";

	
	
	   Kakao.init('d2ea6ae59b35975fe29653904660518b');
	   Kakao.Auth.logout(
	      function(obj) {
	         if(obj==true){}
	         location.href="${ url }";
	       }
	   );

	
	</script>