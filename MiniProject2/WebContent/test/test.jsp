<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function() {
		$('button').click(function() {
			var text = $('#reply').val();
			$.ajax({
				url : "<%= request.getContextPath() %>/ajax.do",
				data : {
					text : text
				},
				success : function(data) {
					var list = JSON.parse(data); //객체화시켜줌 !!
					console.log(list);
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="text" id="reply" />
	<button>등록</button>
	
	<table>
		<tr>
			<td>내용</td>
			<td>시간</td>
		</tr>
	</table>
</body>
</html>