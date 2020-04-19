<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <script>
    alert("게시물을 등록 하였습니다");
    switch("<%=request.getAttribute("type")%>"){
    case "a":
    	location.href = "<%= request.getContextPath() %>/info.do";
    	break;
    case "b":
    	location.href = "<%= request.getContextPath() %>/acc.do";
    	break;
    case "c":
    	location.href = "<%= request.getContextPath() %>/BoardList.do?type=c";
    	break;
    case "d":
    	location.href = "<%= request.getContextPath() %>/BoardList.do?type=d";
    	break;
    
    }
    </script>
    