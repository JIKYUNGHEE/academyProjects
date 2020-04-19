
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <script>
    
    alert("게시물을 등록 하였습니다");
    <%-- String type = <%=request.getAttribute("type")%>; --%>
    switch("<%=request.getAttribute("type")%>"){
    case "a":
    	location.href = "<%= request.getContextPath() %>/info.do?type=a";
    	break;
    case "b":
    	location.href = "<%= request.getContextPath() %>/acc.do?type=b";
    	break;
    case "c":
    	location.href = "<%= request.getContextPath() %>/BoardList.do?type=c";
    	break;
    case "d":
    	location.href = "<%= request.getContextPath() %>/BoardList.do?type=d";
    	break;
    
    }
    </script>
    