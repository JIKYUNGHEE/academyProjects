<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath() %>/js/isNull.js"></script>
<script>
	function doList() {
		location.href = "<%= request.getContextPath() %>/maketList.do";
	}
	
	function doWrite() {
		var f = document.wForm;
		
		if(isNull(f.title, '제목을 입력하세요.')) {
			return false;
		}
		
		if(isNull(f.content, '내용을 입력하세요.')) {
			return false;
		}
		return true;
	}
	
	function doAction(){
		history.back();
	}
</script>
<!-- Custom styles for this template -->
<link href="/Project-Web/Resources/css/clean-blog.min.css"
   rel="stylesheet">

</head>
<body>
	
	
			<jsp:include page="/include/topmenu.jsp"/>
	
	
	
		 <header class="masthead" style="background-image: url('<%= request.getContextPath() %>/Resources/img/grass.jpg'); height: 200px;" >
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading" style="padding: 70px 0">
              <h1>Sell Board</h1>
              <span class="subheading"></span>
            </div>
          </div>
        </div>
      </div>
    </header>

	
	
	<section>
		
	<div class="container">
		<form action="<%=request.getContextPath() %>/marketWriteForm.do" method="post" name="wForm" onsubmit="return doWrite()" enctype="multipart/form-data">
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
					<input type="submit" value=" 등록  "  class="btn btn-secondary"/>&nbsp;
					<input type="reset" value="  취소  "  class="btn btn-secondary"/>&nbsp;
					<input type="button" value="  뒤로 가기  " onclick="doAction()" class="btn btn-secondary"/><br/>
                  
                </td>
            </tr>
		</table>
			<br/><br/>
		</form>
	</div>
	</section>
	
		<!-- Footer -->
		<footer>
		   		<jsp:include page="/include/bottom.jsp"/>

		</footer>

        		<jsp:include page="/include/modal.jsp"/>
 	
</body>
</html>