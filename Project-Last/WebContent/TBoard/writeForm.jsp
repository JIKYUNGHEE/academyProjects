<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" lang="ko">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Write something else you want</title>

<!-- Custom styles for this template -->
<link href="/Project-Web/Resources/css/clean-blog.min.css"
   rel="stylesheet">


<script>
	$(document).ready(function() {
		$(':button').click(function() {
			location.href="writeForm.do";			
		});
	});
	
	function checkWrite(){
		var f = document.wForm;
		
		if(f.title.value="") {
			alert('제목을 입력해주세요!');
			f.title.focus();
			return false;
		} 
		
		if(f.content.value="") {
			alert('내용을 입력해주세요!');
			f.content.focus();
			return false;
		}
		return true;
	}

</script>

</head>

<body>

		
   		<jsp:include page="/include/topmenu.jsp"/>

   <!-- Page Header -->
   <header class="masthead"
      style="background-image: url('<%= request.getContextPath() %>/Resources/img/mindle.jpg'); height: 200px;">
      <div class="container">
         <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
               <div class="page-heading" style="padding: 70px 0">
                  <h1>Tip Board</h1>
                  <span class="subheading">How To Grow ?</span>
               </div>
            </div>
         </div>
      </div>
   </header>


<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<div class="container">
     <form action="<%=request.getContextPath()%>/wRegis.do" method="POST"  onsubmit="return true" enctype="multipart/form-data">
		<table class="table table-bordered">
            <tr>
                <th>제목: </th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="title" class="form-control"/></td>
            </tr>
            <tr>
                <th>작성자: </th>
                <td>
                ${ userVO.id }
                <input type="hidden" name="writer" value="${ userVO.id }" />
                </td>
            </tr>
            <tr>
                <th>첨부파일: </th>
                
                <td>
	                <input type="file" name="addfile1"  size="40"/>
                <br/>
	                <input type="file" name="addfile2"  size="40"/>
                </td>
            </tr>
            <tr>
                <th>내용 </th>
                <td><textarea cols="10" rows="8" placeholder="내용을 입력하세요. " name="content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="글 등록" class="btn btn-secondary" />
                    <input type="button" value="돌아가기 " onclick="" class="btn btn-secondary"/>
                </td>
            </tr>
		</table>
      </form>
</div>

		<!-- Footer -->
		<footer>
		   		<jsp:include page="/include/bottom.jsp"/>

		</footer>

        		<jsp:include page="/include/modal.jsp"/>
 	
</body>
</html>
