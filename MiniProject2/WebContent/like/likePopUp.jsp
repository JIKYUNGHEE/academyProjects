<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Petting</title>

<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/Resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/Resources/css/business-casual.css" rel="stylesheet">





<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	function click_btn(data){
		
		if(confirm("진짜? ㅠㅠ"))
		{
			location.href= "/MiniProject2/likeDelete.do?like_no="+data;
		}
		
	}
	
	$(document).ready(function(){
		$('#replybutton').click(function(){
			$.ajax({
				
				url : "/MiniProject2/likeReply.do",
				type : "GET",
				data : {
					id : $("#like_id").val(),
					like_no : $("#like_no").val(),
					content: $('#replyWord').val(), 
				},
				success : getIt,
				error : function(){
					alert('실패');
				}
			});
		});
		
	});


	$(document).on("click", "#replyDelete", function(){
		
		if(confirm("정말 삭제하시겠습니까?")==false){
			return false;
			
		}else{
			$.ajax({		
				url: "/MiniProject2/likeReplyDelete.do",
				type: "GET",
				data: {								
					no : $(this).next().val(),
					like_no: $("#like_no").val()							
				},
				success: getIt			
			}); 
		}
			
	});
	
	
	
	function getIt(data){
		
		var msg="";
		
		var list = JSON.parse(data);
		console.log(list);
		
		for(var i =0;i<list.length;i++)
		{
			msg += "<tr>"
			var reply = list[i];
			var content =  reply.content;
			var nickname = reply.nickname;
			var reply_no = reply.no;
			var id = reply.id;
			
			msg += "<td width='15%'><strong>"+nickname+"</strong></td>"+"<td width='65%'>"+content+"</td>"
			
			if( id == "${sessionScope.userVO.id}" || "${sessionScope.userVO.type}"=='S')
			{
				msg+="<td>"+"<input id='replyDelete' class='btn btn secondary' type='button' value='삭제'/>"+"<input id='reply_no' type='hidden' value="+reply_no+">"+"</td>";
			}
		
	
		}
	
		msg+= "</tr>";

		$('#replyWord').val("");
		$(".ajax").html(msg);
		
	}
	
	
	
	
	
	
</script>
</head>

<body>


	<!-- Navigation -->

	<div class="container">


		<div class="bg-faded p-4 my-4">
			<hr class="divider">
			<h2 class="text-center text-lg text-uppercase my-0">
				<strong>${like.title }</strong>
			</h2>

			<hr class="divider">

			<div class="row">
				<div class="col-md-4 mb-4 mb-md-0"
					style="width: 1000px; height: 400px;">
					<div class="card h-100" style="width: 400px; height: 400px;">
						<img class="card-img-top"
							src="<%=request.getContextPath()%>/upload/${fileVO.savename}"
							alt="" width="400px" height="400px">
						<div class="card-body text-center">
							<h6 class="card-title m-0"></h6>
						</div>
					</div>
				</div>

				<div style="position: relative; margin-left: 200px" class="col-md-4">
					<div class="form-group col-lg-12" style="width: 300px; height: 400px; border-style: solid, 1px, black;">
						<div class="card-body text-center" >
							
							<%--  <div class="ajax">
                     <c:forEach items="${reply }" var="reply">
                     ${reply.content}&nbsp;&nbsp;
                     ${reply.no}
                     <c:if test="${ (reply.id eq 'shook88@naver.com')or(userVO.nickname eq reply.id) or (sessionScope.userVO.type eq 'S') }">
                     &nbsp;&nbsp;<input id="replyDelete" type="button" value="삭제"/>
					</c:if>
					
                     <input id="reply_no" type="hidden" value="${reply.no }"/>
                     <br/>
                     
                     </c:forEach> 
		            </div>
                     
                     --%>





							<div style="font-weight: bold;"
								class="tagline-lower text-left text-expanded text-uppercase text-info mb-5 d-none d-lg-block">
								<h4 style="text-align:center;">-content-</h4> <h6>${like.pIntro }</h6></div>




						</div>
					</div>
				</div>




			</div>
			<!-- <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Business Casual</div> -->
			<div
				class="tagline-lower text-left text-expanded text-shadow text-uppercase text-secondary mb-5 d-none d-lg-block">
			</div>
			<div style="height:5px;">
			</div>
			<div class="form-group col-lg-12">

				<table class="ajax" style="width: 100%">
					<c:forEach items="${reply }" var="reply">
						<tr>
							<td width="15%"><strong>${reply.nickname }</strong></td>
							<td width="65%">${reply.content }</td>
							<td><c:if
									test="${ (userVO.id eq reply.id) or (sessionScope.userVO.type eq 'S') }">
									<input class="btn btn secondary" id="replyDelete" type="button" value="삭제" />
								</c:if> <input id="reply_no" type="hidden" value="${reply.no }" /></td>
					</c:forEach>
				</table>


				<input id="like_no" type="hidden" value="${like.like_no }" /> <input
					id="like_id" type="hidden" value="${userVO.id }" /> <input
					id="replyWord" placeholder="댓글쓰기"
					style="width: 100%;" type="text" /> <br /><div style="height:15px"></div>
				<button id="replybutton" class="btn btn-secondary">댓글등록</button>
			</div>

			<div class="form-group col-lg-12">
				<c:if test="${userVO.id eq like.id or userVO.type eq 'S' }">
				<button onclick="click_btn(${like.like_no})"
					class="btn btn-secondary">Delete</button>
        </c:if>
			</div>

		</div>

	</div>
	<!-- /.container -->

	<!--    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0">Copyright &copy; Your Website 2017</p>
      </div>
    </footer> -->

<!-- Bootstrap core JavaScript -->
	<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/popper/popper.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
