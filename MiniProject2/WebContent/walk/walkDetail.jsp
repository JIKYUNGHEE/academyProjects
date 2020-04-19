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
	$(document).ready(function() {
		$('#replybutton').click(function() {
			$.ajax({	

				url : "/MiniProject2/walkReply.do",
				type : "GET",
				data : {
					id : $("#walk_id").val(),
					walk_no : $("#walk_no").val(),
					reply_content : $('#replyWord').val(),
				},
				success : getIt,
				error : function() {
					alert('실패');
				}
			});
		});

	});

	$(document).on("click", "#replyDelete", function() {

		if (confirm("정말 삭제하시겠습니까?") == false) {
			return false;

		} else {
			$.ajax({
				url : "/MiniProject2/walkReplyDelete.do",
				type : "GET",
				data : {
					reply_no : $(this).next().val(),
					walk_no : $("#walk_no").val()
				},
				success : getIt
			});
		}

	});

	function getIt(data) {

		var msg = "";
		var list = JSON.parse(data);
		console.log(list);
		
		
		for (var i = 0; i < list.length; i++) {
			msg += "<tr>"
			var reply = list[i];
			var content = reply.reply_content;
			var nickname = reply.nickname;
			var reg_date = reply.reg_date;
			var reply_no = reply.reply_no;
			
			
			var id = reply.id;
			msg += "<td width='15%'><strong>"+nickname+"</strong></td>"+"<td width='65%'>"+content+"</td>"
			+"<td>"+reg_date+"</td>";
			
			if(id == "${sessionScope.userVO.id}" || "${sessionScope.userVO.type}"=='S')
				{
					msg+="<td>"+"<input class='btn btn secondary' id='replyDelete' type='button' value='삭제'/>"+"<input id='reply_no' type='hidden' value="+reply_no+">"+"</td>";
				}
			
		}
		
		msg+= "</tr>";
		$('#replyWord').val("");
		$(".ajax").html(msg);

	}

	
	
	
	function click_btn(data) {

		if (confirm("지울까요?")) {
			location.href = "/MiniProject2/walkDelete.do?walk_no=" + data;
		}
	}
</script>




</head>

<body>

	<jsp:include page="../include/topMenu.jsp" />

	<div class="container">


		<div class="bg-faded p-4 my-4">
			<div class="card card-inverse">

				<img class="card-img img-fluid w-100"
					src="<%=request.getContextPath()%>/upload/${fileVO.savename}"
					alt="">

			</div>
		</div>

		<div class="bg-faded p-4 my-4">
			<div class="card card-inverse">
				<h2 class="card-title text-shadow text-black text-uppercase ">${walk.title }</h2>
				<p class="lead card-text text-shadow text-black ">${walk.content }
				</p>
			</div>
		</div>
		<!--
      <div class="bg-faded p-4 my-4">
        <div class="card card-inverse">
          <img class="card-img img-fluid w-100" src="/Project02/walk/seoulforest2.jpg" alt="">
          <div class="card-img-overlay bg-overlay">
            <h2 class="card-title text-shadow text-white text-uppercase mb-0">Post Title</h2>
            <h4 class="text-shadow text-white">March 1, 2017</h4>
            <p class="lead card-text text-shadow text-white w-50 d-none d-lg-block">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit repellat provident quo aliquam eius ea, animi porro magnam totam dolor nam error quas labore eveniet dicta nostrum inventore veniam. Ipsam?</p>
            <a href="#" class="btn btn-secondary">Read More</a>
          </div>
        </div>
      </div> -->

		<input id="walk_no" type="hidden" value="${walk.walk_no }" /> <input
			id="walk_id" type="hidden" value="${userVO.id }" />
		<div class="bg-faded p-4 my-4">

			<table class="ajax" style="width:100%">
				<c:forEach items="${reply }" var="reply">
					<tr>
						<td width="15%"><strong>${reply.nickname }</strong></td>
						<td width="65%">${reply.reply_content }</td>
						<td>${reply.reg_date }</td>
						<td><c:if test="${(userVO.id eq reply.id) or (sessionScope.userVO.type eq 'S') }">
                     <input class="btn btn secondary" id="replyDelete" type="button" value="삭제" />
							</c:if> 
							<input id="reply_no" type="hidden" value="${reply.reply_no }" />
						</td>
				</c:forEach>
			</table>
			<input id="replyWord" placeholder="댓글쓰기" style="width: 100%;"
				type="text" /> <br />
			<button id="replybutton" class="btn btn-secondary">댓글등록</button>
		</div>



		<div style="text-align: center;">
			<a href="<%=request.getContextPath()%>/walk.do"
				class="btn btn-secondary">목록</a> &nbsp;&nbsp;<a
				href="javascript:click_btn(${walk.walk_no })"
				class="btn btn-secondary">삭제</a>
		</div>

	</div>
	<!-- /.container -->

	<jsp:include page="/include/bottom.jsp" />

<!-- Bootstrap core JavaScript -->
	<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/popper/popper.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
