<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">

  <head>
<script src ="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

	

	function doAction(type) {
		switch(type){
		case 'U':
			location.href="/MiniProject2/myinfoModifyForm.do";
			break;	
		
		
		case 'P':			
			location.href = "/MiniProject2/mypetinfoModifyForm.do"; 
			
			break;
		
			
			
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
        <h2 class="text-center text-lg text-uppercase my-0">M y
          <strong>&nbsp; I n f o</strong>
        </h2>
        <hr class="divider">
        <div align="center">
		<br/>
		
		
		<form name="mform"  enctype="multipart/form-data" method="post">
				<table style="width:65%">
					<tr>
						<th><label class="text-heading">P R O F I L E</label></th>
						<td>
							<img style="width:150px;"src="<%= request.getContextPath() %>/upload/${ pimg.fileSaveName }" />
						</td>
					</tr>
					
					<tr>
						<th width="30%"><label class="text-heading">  E M A I L  </label></th>
						<td><span class="form-control" size ="20px">${ member.id }</span></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><span class="form-control" size ="20px">${ member.name }</span></td>
					
					
					</tr>
					
					<tr>
						<th width="30%"><label class="text-heading">PASSWORD</label></th>
						<td><span class="form-control" size ="20px">${ member.password }</span></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">NICKNAME</label></th>
						<td><span class="form-control" size ="20px">${ member.nickname }</span></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td><span class="form-control" size ="20px">${ member.sex }</span></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  P E T N O  </label></th>
						<td><span class="form-control" size ="20px">${ member.petNo }</span><td/>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading"> T E L </label></th>
						<td>
							<span class="form-control" size ="20px">${ member.tel }</span>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading"> A D D R E S S </label></th>
						<td><span class="form-control" size ="20px">${ member.basic_addr }</span></td>
					</tr>
				</table>
				<br/><br/>
				<input type="button" class="btn btn-secondary" onclick="doAction('U')" value="나의정보수정"/>&nbsp;&nbsp;				
						
			</form>
		<br/><br/>		
	
	</div>
      </div>
	</div>
	
	
	
	<%-- <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">P E T 
          <strong>&nbsp; I n f o</strong>
        </h2>
        <hr class="divider">
        <br/><br/>
        <div align="center">
        	<form name="pform" method="post">        	
				<table style="width:50%">	
				<c:forEach items="${ petlist }" var="pet" varStatus="loop">	
				<h2 class="text-center text-lg text-uppercase my-0">P E T &nbsp; N o &nbsp;  <strong> ${ loop.count }</strong></h2>			
					<tr>
						<th width="30%"><label class="text-heading">N A M E</label></th>
						<td><span class="form-control" size ="20px">${ pet.name }</span></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
						<span class="form-control" size ="20px">${ pet.age }</span>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<span class="form-control" size ="20px">${ pet.sex }</span>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<span class="form-control" size ="20px">${ pet.species }</span>
						<td/>
					</tr>	
					<br/><br/>		
					</c:forEach>
				</table>				
				<br/><br/>
				<input type="button" class="btn btn-secondary"  onclick="doAction('P')" value="펫정보수정"/>			
									
			</form>
		</div>
        <hr class="divider">
        <!-- <img class="img-fluid float-left mr-4 d-none d-lg-block" src="/miniProject_02/Resources/img/intro-pic.jpg" alt=""> -->
      </div>
	</div>			 --%>
	
	
	
	
	<div class="container">

      	<div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">P E T 
          <strong>&nbsp; I n f o</strong>
        </h2>
        <hr class="divider">
        <br/><br/>
        
        <div align="center">	
        	<form name="pform" method="post">
        	<c:forEach items="${ petlist }" var="pet" varStatus="loop">
        	<h2 class="text-center text-lg text-uppercase my-0">P E T &nbsp; N o &nbsp;  <strong> ${ loop.count }</strong></h2>
        	<br/>
        	<input type="hidden" name="no" value="${ pet.no }"/>
				<table style="width:50%">								
					<tr>
						<th width="30%"><label class="text-heading">N A M E</label></th>
						<td><span class="form-control" size ="20px">${ pet.name }</span></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
							<span class="form-control" size ="20px">${ pet.age }</span>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X (M/W) </label></th>
						<td>
						 <span class="form-control" size ="20px">${ pet.sex }</span>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<span class="form-control" size ="20px">${ pet.species }</span>
						<td/>
					</tr>
					
				</table>	
				<br/><br/><br/>
				</c:forEach>
				<input type="button" class="btn btn-secondary"  onclick="doAction('P')" value="펫정보수정"/>			
				<!-- <input type="button" class="btn btn-secondary"  onclick="doAction()" value="수정완료"/> -->										
			</form>
		</div>        
        <!-- <img class="img-fluid float-left mr-4 d-none d-lg-block" src="/miniProject_02/Resources/img/intro-pic.jpg" alt=""> -->
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