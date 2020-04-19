<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">

  <head>

<script>


function doWrite() {
	
	var f = document.pform;
	
	for(var i = 0; i < f.name.length; i++){
	
	if(f.name.value[i] == ""){
		alert("이름을 입력하세요");
		f.name[i].focus(); 
		return false;
		
	}
	
	if(f.age[i].value ==""){
		alert("나이를 입력하세요");
		f.age[i].focus();
		return false;
		
	}
	
	if(f.sex[i].value ==""){
		alert("성별을 입력하세요");
		f.sex[i].focus();
		return false;
		
	}else if(!(f.sex[i].value == "M" || f.sex[i].value == "F")){
		
		alert("성별은 M(수컷) 또는 F(암컷)로 입력하세요");
		f.sex[i].focus();
		return false;	
		
	}
	

	
	if(f.species[i].value ==""){
		alert("전화번호를 입력하세요");
		f.species[i].focus();
		return false;
		
	}
	

		
	return true;
	
	}
	
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
        <h2 class="text-center text-lg text-uppercase my-0">P E T 
          <strong>&nbsp; I n f o</strong>
        </h2>
        <hr class="divider">
        <br/><br/>
        
        <div align="center">	
        	<form name="pform" action="/MiniProject2/mypetinfoModify.do" onsubmit="return doWrite()" method="post">
        	<c:forEach items="${ petlist }" var="pet" varStatus="loop">
        	<h2 class="text-center text-lg text-uppercase my-0">P E T &nbsp; N o &nbsp;  <strong> ${ loop.count }</strong></h2>
        	<br/>
        	<input type="hidden" name="no" value="${ pet.no }"/>
				<table style="width:50%">								
					<tr>
						<th width="30%"><label class="text-heading">N A M E</label></th>
						<td><input type="text" class="form-control" name="name" value="${ pet.name }" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
							<input type="text" class="form-control" name="age" value="${ pet.age }" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X (M/W) </label></th>
						<td>
						<input type="text" class="form-control" name="sex" value="${ pet.sex }" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<input type="text" class="form-control" name="species" value="${ pet.species }" size ="20px"/>
						<td/>
					</tr>
					
				</table>	
				<br/><br/><br/>
				</c:forEach>
				<button type="submit" class="btn btn-secondary">수정완료</button>			
				<!-- <input type="button" class="btn btn-secondary"  onclick="doAction()" value="수정완료"/> -->										
			</form>
		</div>
        <hr class="divider">
        <!-- <img class="img-fluid float-left mr-4 d-none d-lg-block" src="/miniProject_02/Resources/img/intro-pic.jpg" alt=""> -->
      </div>
	</div>	
	
	<br/><br/>
		
			
			
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