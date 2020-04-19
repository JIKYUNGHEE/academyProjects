<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">

  <head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>

$(function() {
    $("#imgInp").on('change', function(){
        readURL(this);
    });
});


function readURL(input) {
    if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

      reader.readAsDataURL(input.files[0]);
    }
}



function doWrite() {
	
	var f = document.mform;
	
	if(f.name.value == ""){
		alert("이름을 입력하세요");
		f.name.focus(); 
		return false;
		
	}
	
	
	
	if(f.password.value ==""){
		alert("비밀번호를 입력하세요");
		f.password.focus();
		return false;		
	}
	
	
	if(f.nickname.value ==""){
		alert("닉네임을 입력하세요");
		f.nickname.focus();
		return false;
		
	}
	

	
	if(f.tel.value ==""){
		alert("전화번호를 입력하세요");
		f.tel.focus();
		return false;
		
	}
	
	if(f.address.value ==""){
		alert("주소를 입력하세요");
		f.address.focus();
		return false;
		
	}	
		
	return true;
	
}

</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Petting</title>

    <!-- Bootstrap core CSS -->
    <link href="/MiniProject2/Resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="/MiniProject2/Resources/css/business-casual.css" rel="stylesheet">


  </head>

  <body>
  	<jsp:include page="../include/topMenu.jsp" />
    <div class="container">

      <div class="bg-faded p-4 my-4">
        <hr class="divider">        
        <h2 class="text-center text-lg text-uppercase my-0">M y
          <strong>&nbsp; I n f o</strong>
        </h2>
        <hr class="divider">
        <div align="center">
		<br/>
		
		
		<form name="mform" action="<%= request.getContextPath()%>/myinfoModify.do" onsubmit="return doWrite()" enctype="multipart/form-data" method="post">
				<table style="width:65%">
					<tr>
						<th><label class="text-heading">P R O F I L E</label></th>
						<td>
							<img id="blah" style="width:150px; height:200px"><br/>						
							<label class="text-heading"><input type="file" id="imgInp" name="upload" value="upload"/></label>
						</td>
					</tr>
					
					<tr>
						<th width="30%"><label class="text-heading">  E M A I L (ID) </label></th>
						<td><span class="form-control" name="id" size ="20px">${ info.id } (변경 불가능)</span></td>
					
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type="text" class="form-control" name="name" value="${ info.name }" size ="20px"/></td>
					
						<td><img style="width:200px;"src="<%= request.getContextPath() %>/upload/${ pimg.fileSaveName }" /></td>
					</tr>
					
					<tr>
						<th width="30%"><label class="text-heading">PASSWORD</label></th>
						<td><input type="text" class="form-control" name="password" value="${ info.password }" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">NICKNAME</label></th>
						<td><input type="text" class="form-control" name="nickname" value="${ info.nickname }" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex" value="M"/>&nbsp;&nbsp;MEN&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="W" size ="20px"/>&nbsp;&nbsp;WOMEN
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  P E T N O </label></th>
						<td>
						<select name="petNO" style="width: 175px">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						<td/>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading"> T E L </label></th>
						<td>
							<input type="text" class="form-control" name="tel" value="${ info.tel }" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading"> A D D R E S S </label></th>
						<td><textArea name="basic_addr" class="form-control" rows="3" cols="40"> ${ info.basic_addr } </textarea></td>
					</tr>
				</table>
				<br/><br/>
				<button type="submit" class="btn btn-secondary">수정완료</button> &nbsp;&nbsp;				
			</form>
		

		<br/><br/>		
	
				
	</div>
      </div>

    </div>
    <!-- /.container -->

    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0">Copyright &copy; Your Website 2017</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="/MiniProject2/Resources/vendor/jquery/jquery.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/popper/popper.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>