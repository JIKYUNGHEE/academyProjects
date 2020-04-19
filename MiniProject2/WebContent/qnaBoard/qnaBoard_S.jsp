<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<style id="style-1-cropbar-clipper">
.en-markup-crop-options {
	top: 18px !important;
	left: 50% !important;
	margin-left: -100px !important;
	width: 200px !important;
	border: 2px rgba(255, 255, 255, .38) solid !important;
	border-radius: 4px !important;
}

.en-markup-crop-options div div:first-of-type {
	margin-left: 0px !important;
}
</style>
<script src=http://code.jquery.com/jquery-latest.min.js></script>
<script src="<%= request.getContextPath() %>/qnaBoard/httpRequest.js"></script>
<script>
	$(document).ready(function() {
		
		function getList(data) {
			var list = JSON.parse(data);
			var output = "";
		
			for (var i = 0; i < list.length; i++) {
				output += '<form id="AnswerForm" method="post">';
				output += '<div class="row"><div class="form-group col-lg-4"><label class="text-heading"> Writer </label>';
				for ( var key in list[i]) {		
					if (key == 'writer') {
						output += '<input type="email" name="writer" id="writer" class="form-control" value="'+ list[i].writer+'" readonly>';
						output += '</div><div class="form-group col-lg-4"><label class="text-heading"> T I T L E </label>'
					} else if (key == 'title') {
						output += '<input type="text" name="title" id="title" class="form-control" value="'+ list[i].title+'" readonly>';
							output += '</div><div class="clearfix"></div><div class="form-group col-lg-12"><label class="text-heading">Question</label>'
					} else if (key == 'content1') {
						output += '<textarea class="form-control" name="content1" id="content1" rows="6" readonly>'+ list[i].content1+ '</textarea>';
						output += '</div><div class="clearfix"></div><div class="form-group col-lg-12"><label class="text-heading">Answer</label>'
					} else if(key=='content2'){
						if(!list[i].content2){							
							output += '<input class="form-control" name="content2" id="content2"></div><input type="hidden" id="no" value='+ list[i].no +'>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-secondary" id="answer" value="Submit"></div>';							
						}else if(list[i].content2 == "조금만 기다려 주세요. 곧 답변드리겠습니다."){
							output += '<input class="form-control" name="content2" id="content2"></div><input type="hidden" id="no" value='+ list[i].no +'>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-secondary" id="answer" value="Submit"></div>';
						}else if(list[i].content2=="null"){
							output += '<input class="form-control" name="content2" id="content2"></div><input type="hidden" id="no" value='+ list[i].no +'>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-secondary" id="answer" value="Submit"></div>';
						}
						else{
							output += '<input class="form-control" name="content2" id="content2" value="'+ list[i].content2 +'" readonly></div><div class="form-group col-lg-12"><input type="hidden" id="no" value='+ list[i].no +'>';
						}
					}
				}
				output += '</div></div><hr/></form>';
			};
			$("#qnaList").html(output); 
		}
					
			$(document).on("click", "#answer", function(){
				
				var writer = document.getElementById( "writer" );
				var title = document.getElementById( "title" );
				var content1 = document.getElementById( "content1" );
				var content2 = document.getElementById( "content2" );
				//alert("답변하러 가야지");
				//alert($(this).parent().prev().children().eq(1).val());

				$.ajax({	
					
					url: "/MiniProject2/qnaAnswer.do",
					type: "POST",
					data: {	
						no : $(this).prev().val(),
						writer : $(this).parent().prev().parent().prev().prev().prev().prev().children().eq(1).val(),
						title : $(this).parent().prev().parent().prev().prev().prev().children().eq(1).val(),
						content1 : $(this).parent().prev().parent().prev().prev().children().eq(1).val(),
						content2 : $(this).parent().prev().val()
					},
					success: function(data) {
						alert("답변이 등록되었습니다.");
						getList(data);
					},
				});
			
			});
	});
	
</script>
</head>
<body>
	<jsp:include page="/include/topMenu.jsp" />

	<div class="container">

		<div class="bg-faded p-4 my-4">
			<hr class="divider">
			<h2 class="text-center text-lg text-uppercase my-0">
				Q & A <strong>Form</strong>
			</h2>
			<hr class="divider">
		</div>

		<div class="bg-faded p-4 my-4" id="qnaList">
			<c:forEach items="${ list }" var="question" varStatus="loop">
			<form id="AnswerForm" method="post">
				<div class="row">
					<div class="form-group col-lg-4">
						<label class="text-heading"> Writer </label>
						<input type="text" name="writer" id="writer" class="form-control" value="${question.writer}" readonly>
					</div>
					<div class="form-group col-lg-4">
						<label class="text-heading"> T I T L E </label>
						<input type="text" name="title" id="title" class="form-control" value="${question.title}" readonly>
					</div>
					<div class="form-group col-lg-12">
						<label class="text-heading"> Question </label>
						<textarea class="form-control" name="content1" id="content1" rows="6" readonly>${question.content1}</textarea>
					</div>
					<div class="clearfix"></div>
						<div class="form-group col-lg-12">
							<label class="text-heading"> Answer </label>
					<c:choose>
						<c:when test="${ question.content2 eq null}">
							<!-- <textarea class="form-control" name="content2" id="content2" rows="6"></textarea></div> -->
							<input class="form-control" name="content2" id="content2">
							<div class="form-group col-lg-12">
								<br/>
								<input type='hidden' id='no' value="${question.no }">
								<input type="button" class="btn btn-secondary" id="answer" value="Submit">
							</div>
						</c:when>
						<c:when test="${ question.content2 eq '조금만 기다려 주세요. 곧 답변드리겠습니다.' }">
							<!-- <textarea class="form-control" name="content2" id="content2" rows="6"></textarea></div> -->
							<input class="form-control" name="content2" id="content2">
							<div class="form-group col-lg-12">
								<br/>
								<input type='hidden' id='no' value="${question.no }">
								<input type="button" class="btn btn-secondary" id="answer" value="Submit">
							</div>
						</c:when>
						<c:otherwise>
							<input type='hidden' id='no' value="${question.no }">
							<input class="form-control" name="content2" id="content2" value="${question.content2}" readonly>
						</c:otherwise>
						</c:choose>
					</div>
					</div>
					<hr/>
				</form>
			</c:forEach>
		</div>
	<!-- /.이전 등록 글 목록 -->
	
	</div>
	<!-- /.container -->

	<jsp:include page="/include/bottom.jsp" />

	<!-- Bootstrap core JavaScript -->
	<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/popper/popper.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>