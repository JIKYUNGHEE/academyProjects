<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<script>	
	function goLogin(){
		location.href = "/MiniProject2/login/login.jsp";
	}
	function upload(){
		location.href = "/MiniProject2/member/upload.jsp";
	}
</script>
  <head>

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
   	<hr class="divider">

      <div class="bg-faded p-4 my-4">
        <!-- Welcome Message -->
        <div class="text-center mt-4">
          <div class="text-heading text-muted text-lg">Welcome To</div>
          <h1 class="my-2"> J O I N </h1>
          <div class="text-heading text-muted text-lg">By
            <strong>팀 명</strong>
          </div>
        </div>
      </div>

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong> U S E R </strong>
        </h2>
        <hr class="divider">
        <div align="center" float="left">
        	<form name="lform" action="<%= request.getContextPath()%>/joinProcess.do" enctype="multipart/form-data" method="post">
				<table style="width:65%">
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type = "text" class="form-control" name = "name" size ="20px"/></td>
						<th><label class="text-heading">&nbsp;&nbsp;&nbsp;Picture</label><input type="file" name="upload" value="upload"/></th>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  E M A I L  </label></th>
						<td><input type = "email" class="form-control" name = "id" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">PASSWORD</label></th>
						<td><input type ="password" class="form-control" name = "password" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">NICKNAME</label></th>
						<td><input type ="text" class="form-control" name = "nickname" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex" value="M"/>&nbsp;&nbsp;MEN&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="W" size ="20px"/>&nbsp;&nbsp;WOMEN
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  P E T N O  </label></th>
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
							<input type = "text" class="form-control" name = "tel" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading"> A D D R E S S </label></th>
						<td><textArea name="basic_addr" class="form-control" rows="3" cols="40"></textArea></td>
					</tr>
				</table>
				<br/><br/>
				<button type="button" class="btn btn-secondary" onclick='goLogin()'>CANCLE</button>
				<button type="submit" class="btn btn-secondary"> N  E  X  T </button>
			</form>
		</div>
        <hr class="divider">
        <!-- <img class="img-fluid float-left mr-4 d-none d-lg-block" src="/miniProject_02/Resources/img/intro-pic.jpg" alt=""> -->
      </div>
	</div>
    <!-- /.container -->
    
    <jsp:include page="../include/bottom.jsp" />

    <!-- Bootstrap core JavaScript -->
    <script src="/MiniProject2/Resources/vendor/jquery/jquery.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/popper/popper.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>