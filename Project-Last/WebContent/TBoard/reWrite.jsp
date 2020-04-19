
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


<script>
		$(document).ready(function() {
			$(':button').click(function() {
				location.href="<%= request.getContextPath() %>/tipList.do";			
			});
		});
		
		function reWrite() {
			if(confirm('정말 수정 하시겠스빈까?')){
				return true;
			}
			else{
				return false;
			}
		}
		
		function backTo(no) {
			if(confirm('목록으로 돌아가시겠습니까?')){
				location.href="<%=request.getContextPath()%>/tipList.do";
			}
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
    <form action="<%=request.getContextPath()%>/reWriteUp.do" method="POST"  onsubmit="reWrite()" enctype="multipart/form-data">
			<table class="table table-bordered">
            	<tr>
                	<th>제목: </th>
                	<td><input type="text" name="title" class="form-control" value="${ tvo.title }"/></td>
            	</tr>
            <tr>
                <th>작성자: </th>
                <td>${ tvo.writer }
	                <input type="hidden" name="no" value="${ tvo.no }"/>
                <input type="hidden" name="writer" value="${ tvo.writer }"/>
                </td>
            </tr>
            <tr>
                <th>첨부파일: </th><!-- 저장된 폴더에서 파일 가져오기  -->
                <td>
                	<c:forEach var="file" items="${ tFileList }">
						<a href="<%=request.getContextPath() %>/upload/${ file.fileSaveName }" target="_blank">
						<img src="<%=request.getContextPath() %>/upload/${ file.fileSaveName }" width="250" >
						${ file.fileOriName }
						</a>
						(${ file.fileSize } bytes) <br>
						<br/>
					</c:forEach>
	                <input type="file" name="addfile1"  size="40"/>
	                <br/>
					<input type="file" name="addfile2"  size="40"/>
                </td>
            </tr>
            <tr>
                <th>내용 </th>
                <td><textarea cols="10" rows="8" name="content" class="form-control">${ tvo.content }</textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정" />
                    <input type="button" value="목록 " onclick="backTo(${tno.no})"/>		<!-- 절대 경로 어케 쓰지 - 실행 되는지 다시 확인!!! -->
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

