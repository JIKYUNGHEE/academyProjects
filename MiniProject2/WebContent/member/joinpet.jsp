<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<script>	
	function goLogin(){
			location.href = "/MiniProject2/login/login.jsp";
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
          <strong> P E T </strong>
        </h2>
        <hr class="divider">
        <br/><br/>
        <div align="center">
        	<form name="lform" action="<%= request.getContextPath()%>/joinPetProcess.do" method="post">
        	<input type="hidden" name="petNo" value="${ requestScope.petNo }"/>
				<table style="width:50%">
					<tr>
						<th width="30%"><label class="text-heading">Member ID</label></th>
						<td><input type = "text" class="form-control" name = "MemberId" size ="20px"
						     value="${requestScope.id}" readonly /></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type = "text" class="form-control" name = "name" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
						<input type="text" name="age" class="form-control" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex1" value="M"/>&nbsp;&nbsp;male&nbsp;&nbsp;
						<input type="radio" name="sex1" value="F" size ="20px"/>&nbsp;&nbsp;female
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<input type="text" name="species" class="form-control" size ="20px"/>
						<td/>
					</tr>
				</table>
				<c:if test="${requestScope.petNo gt 1}">
				<br/><br/>
				<table style="width:50%">
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type = "text" class="form-control" name = "name" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
						<input type="text" name="age" class="form-control" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex2" value="M"/>&nbsp;&nbsp;male&nbsp;&nbsp;
						<input type="radio" name="sex2" value="F" size ="20px"/>&nbsp;&nbsp;female
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<input type="text" name="species" class="form-control" size ="20px"/>
						<td/>
					</tr>
				</table>
			 	</c:if>
				<c:if test="${requestScope.petNo gt 2}">
				<br/><br/>
				<table style="width:50%">
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type = "text" class="form-control" name = "name" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
						<input type="text" name="age" class="form-control" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex3" value="M"/>&nbsp;&nbsp;male&nbsp;&nbsp;
						<input type="radio" name="sex3" value="F" size ="20px"/>&nbsp;&nbsp;female
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<input type="text" name="species" class="form-control" size ="20px"/>
						<td/>
					</tr>
				</table>
				</c:if>
				<c:if test="${requestScope.petNo gt 3}">
				<br/><br/>
				<table style="width:50%">
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type = "text" class="form-control" name = "name" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
						<input type="text" name="age" class="form-control" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex4" value="M"/>&nbsp;&nbsp;male&nbsp;&nbsp;
						<input type="radio" name="sex4" value="F" size ="20px"/>&nbsp;&nbsp;female
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<input type="text" name="species" class="form-control" size ="20px"/>
						<td/>
					</tr>
				</table>
			 	</c:if>
			 	<c:if test="${requestScope.petNo gt 4}">
				<br/><br/>
				<table style="width:50%">
					<tr>
						<th width="30%"><label class="text-heading">Name</label></th>
						<td><input type = "text" class="form-control" name = "name" size ="20px"/></td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  A G E  </label></th>
						<td>
						<input type="text" name="age" class="form-control" size ="20px"/>
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S E X  </label></th>
						<td>
						<input type="radio" name="sex5" value="M"/>&nbsp;&nbsp;male&nbsp;&nbsp;
						<input type="radio" name="sex5" value="F" size ="20px"/>&nbsp;&nbsp;female
						</td>
					</tr>
					<tr>
						<th width="30%"><label class="text-heading">  S P E C I E S  </label></th>
						<td>
						<input type="text" name="species" class="form-control" size ="20px"/>
						<td/>
					</tr>
				</table>
			 	</c:if>
				<br/><br/>
				<button type="button" class="btn btn-secondary" onclick='goLogin()'> CANCLE </button>
				<button type="submit" class="btn btn-secondary"> CONFIRM </button>
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