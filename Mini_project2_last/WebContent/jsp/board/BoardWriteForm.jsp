<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">
<script src ="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   function doList() {
      location.href = "<%= request.getContextPath() %>/BoardList.do"
   } 

   function dowrite(){
         var f = document.wForm;
      if(f.title.value == ""){
         alert('제목을 입력하세요');
         f.title.focus();
         return false;
      }
   
      if(f.content.value == "") {
         alert('내용을 입력하세요');
         f.content.focus();
         return false;
      }
         
      return true;
   }
   
   $(document).ready(function(){
      $(':button').click(function(){
    	  switch("${param.type}"){
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
         });
         
      });
          
</script>
<style type="text/css">
th{
background-color: #C0BCD7;
color: white;
text-align: center;
}
.btn{
border: none;
background: #F4D0D4;
color: white;
}

h2{
color: #C1C2C6;
}
</style>
</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
<div class="container">
    <div class="bg-faded p-4 my-4">
        <hr class="divider" style="border:1px solid #C1C2C6">
        <h2 class="text-center text-lg text-uppercase my-0" >
      W R I T E</h2>
      <hr class="divider" style="border:1px solid #C1C2C6">
        <div align="center" >
      	<form action="<%= request.getContextPath() %>/BoardWrite.do" method="post" name="wForm" onsubmit = "return dowrite()" enctype="multipart/form-data">
         <input type="hidden" name="writer" value="${ loginUser.id }"/>
         <table  style="border:1PX splid white; width:40% ; " >
         <tr>
         <th width="23%">CATEGORY</th>
         <td>
         <select name="type">
         <c:if test="${ loginUser.type eq 'S' }">
         	<c:if test="${ param.type eq 'a' }">
         	<option value="a" selected="selected">TUMBLER</option>
         	</c:if>
         	<c:if test="${ param.type ne 'a' }">
        	 <option value="a">TUMBLER</option>
         	</c:if>
         </c:if>
         	
         <c:if test="${ param.type eq 'b' }">
         <option value="b" selected="selected">ACCESSORY</option>
         </c:if>
         <c:if test="${ param.type ne 'b' }">
         <option value="b">ACCESSORY</option>
         </c:if>
         <c:if test="${ param.type eq 'c' }">
         <option value="c" selected="selected">BOARD</option>
         </c:if>
         <c:if test="${ param.type ne 'c' }">
         <option value="c">BOARD</option>
         </c:if>
         <c:if test="${ param.type eq 'd' }">
         <option value="d" selected="selected">MARKET</option>
         </c:if>
         <c:if test="${ param.type ne 'd' }">
         <option value="d">MARKET</option>
         </c:if>
         </select>
         </td>
         </tr>
            <tr>
               <th width="23%">TITLE</th>
               <td>
                  <input type="text" name="title" size="60"/>
               </td>
            </tr>
           
            <tr>
               <th width="23%">CONTENT</th>
               <td>
                  <textarea name="content" rows="7" cols="60"></textarea>
               </td>
            </tr>
            <tr>
            <th>FILE</th>
            <td>
            <input type="file" name="attachfile1" size="40"/><br/>
            <input type="file" name="attachfile2" size="40"/>
            </td>
            </tr>
         </table>
         <br/><br/>
         <div align="center">
         <input class="btn" type="submit" value="등록" />
         <input class="btn" type="button" value="목록" />
		</div>
      </form>
	</div>
</div>
</div>
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
