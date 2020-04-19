<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function doUpdate(){
		var f = document.uForm;
		
		if(f.title.value == "") {
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
			switch("${board.type}"){
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
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
	<section>
<div class="container">
    <div class="bg-faded p-4 my-4">
        <hr class="divider" style="border:1px solid #C1C2C6">
        <h2 class="text-center text-lg text-uppercase my-0" >
     U P D A T E</h2>
      <hr class="divider" style="border:1px solid #C1C2C6">
        <div align="center" >
		<form action="<%= request.getContextPath() %>/BoardUpdate.do" method="post" name="uForm" onsubmit="return doUpdate()" enctype="multipart/form-data">
				<input type="hidden" name="writer" value="${ board.writer }" />
				<input type="hidden" name="no" value="${ board.no }" />
			<table style="border:1PX splid white; width:40% ; ">
				<tr>
					<th width="23%">TITLE</th>
					<td>
						<input type="text" name="title" size="40" value="${ board.title }"/>
					</td>				
				</tr>
				<tr>
					<th width="23%">CONTENT</th>
					<td>
						<textarea name="content" rows="7" cols="40" >${ board.content }</textarea>
					</td>				
				</tr>
				<tr>
				<th>FILE</th>
				<td>
					<input type="file" name="attachfile1" size="40" /><br/>
					<input type="file" name="attachfile2" size="40" />
				</td>
				</tr>
				
			</table>
			<br/><br/>
			<div align="center">
			<input class="btn" type="submit"value="   등록   " />
			<input class="btn" type="button"value="   돌아가기   " />
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