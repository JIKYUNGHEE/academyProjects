<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("해당 게시글이 수정 되었습니다.");
	location.href="<%= request.getContextPath()%>/sellList.do";
</script>