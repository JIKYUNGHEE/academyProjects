<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	
	alert("${ msg }");
	
	<c:if test="${ empty loginUser }">
		location.href = "${ url }";
	</c:if>
	
	<c:if test="${ not empty loginUser and loginUser.type eq 'S' }">
		location.href = "<%= request.getContextPath() %>/userlist.do";
	</c:if>
</script>