<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>
<script>

function goWriteForm() {
	location.href = "<%= request.getContextPath() %>/marketWrite.do";
}

</script>
<style>
	.row {
		display: inherit !important;
	}
	#div{
		align : center !important ;
	}


	 .jb-center {
        
        display:table; 
        margin-left:auto; margin-right:auto;
      }
</style>   

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   
<!-- table css link -->

<link
	href='https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css'
	rel='stylesheet' type='text/css'>
	
   
  </head>
  <body>

      		<jsp:include page="/include/topmenu.jsp"/>

    <!-- Page Header -->
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

	<!-- section -->
<div class="row" align="center">
    <div class="col-md-12">
	<table id="example" class="table table-striped table-bordered" cellspacing="0" style = "width : 70%"  >
		<thead>
			<tr>
				<th width="10%" style="text-align: center">No</th>
				<th width="40%" style="text-align: center">Title</th>
				<th width="20%" style="text-align: center">Writer</th>
				<th width="20%" style="text-align: center">Date</th>
				<th width="10%" style="text-align: center">ViewCnt</th>
			</tr>
		</thead>
		
		<c:forEach items="${ marketList }" var="board" varStatus="loop">
				<tr>	
					<td>${ board.no }</td>
					<td>
					
						<a href="<%= request.getContextPath() %>/marketDetail.do?no=${ board.no }"><c:out value="${ board.title }" /></a><br/>
							<c:if test="${ not empty marketComlist }">
								<c:forEach items="${ marketComlist }" var="comment">
									<c:if test="${ comment.commentNo eq board.no }">
									&nbsp;&nbsp;<a href="<%= request.getContextPath()%>/marketCommentDetail.do?no=${ comment.no }"><c:out  value="${ comment.title  }"/></a>
									</c:if>
									<br/>
								</c:forEach>
							</c:if>
						<!-- </a> -->
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.viewCnt }</td>
				</tr>
			</c:forEach>
	</table>
		</div>
	</div>
	
	
	<br/><br/>

				<div class="jb-center">
			 		 <ul class="pagination">
						<c:choose>
							<c:when test="${pageNo == 1}" >
			    				<li>
			     					 <a href="<%= request.getContextPath() %>/sellList.do" aria-label="Previous">
			        				<span aria-hidden="true">&laquo;</span>
			      					</a>
			    				</li>
					
							</c:when>
							<c:otherwise>
								<li>
									<a href="<%= request.getContextPath() %>/sellList.do?pageNo=1" aria-label="Previous">
									 <span aria-hidden="true">&laquo;</span>
									</a>
								</li>	
							</c:otherwise>
						</c:choose>
	
						<c:forEach var="i" begin="1" end="${lastPage}">
							<c:if test="${i eq pageNo}">
								<li><a>${i}</a></li>
							</c:if>
					
							<c:if test="${i ne pageNo}">
								<li><a href="<%= request.getContextPath() %>/sellList.do?pageNo=${i}">${i}</a></li>
							</c:if>
		
						</c:forEach>	
	
						<c:choose>
							<c:when test="${pageNo == lastPage}" >
								<li>
			      					<a href="<%= request.getContextPath() %>/sellList.do?pageNo=${lastPage}" aria-label="Next">
			      					  <span aria-hidden="true">&raquo;</span>
			      					</a>
			   	 				</li>
							</c:when>
				
							<c:otherwise>
								<li>
			      					<a href="<%= request.getContextPath() %>/sellList.do?pageNo=${lastPage}" aria-label="Next">
			       					 <span aria-hidden="true">&raquo;</span>
			      					</a>
							   	 </li>
							</c:otherwise>
						</c:choose>
					</ul>
		 		</div>
		 		
	<br />
	<br />
	<c:if test="${ not empty userVO }">
	
		<div class="row" align="center">
    		<div class="col-md-12">
				<form name="search" action="tSearch.do" method="POST">
					<input type="button" class="btn btn-primary" value="Write"
					onclick="goWriteForm()" />
					<input type="submit" class="btn btn-primary" value="Search" />
					<input type="text" name="writer" size="25"
						placeholder="검색어를 입력해주세요" /> 
				</form>
		
			</div>
		</div>
	</c:if>



<!-- section -->

    <hr>

    <!-- Footer -->
    <footer>
         		<jsp:include page="/include/bottom.jsp"/>

    </footer>

			<jsp:include page="/include/modal.jsp"/>



  </body>

</html>
