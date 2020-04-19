<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>사슴벌레동호회</title>
  </head>
  <body>

   		<jsp:include page="/include/topmenu.jsp"/>


    <!-- Page Header -->
    <header class="masthead" style="background-image: url('<%= request.getContextPath() %>/Resources/img/fields.jpg')">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1><img src ="<%= request.getContextPath() %>/Resources/img/logo.gif"></h1>
              <span class="subheading">사슴벌레를 좋아하는사람들의 모임</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-preview">
            <a href="<%= request.getContextPath() %>/Notice.jsp">
              <h2 class="post-title">
                	Contact Us
              </h2>
              <h3 class="post-subtitle">
                	페이지를 만들기까지...
              </h3>
            </a>
          </div>
          <hr>
          <div class="post-preview">
            <a href="<%= request.getContextPath() %>/tipList.do"">
              <h2 class="post-title">
               	Tip Board 
              </h2>
            </a>
            	<div class="row" align="center">
    <div class="col-md-12">
	<table id="example" class="table table-striped table-bordered" cellspacing="0" style = "width : 100%"  >
		<thead>
			<tr>
				<th width="10%" style="text-align: center">No</th>
				<th width="40%" style="text-align: center">Title</th>
				<th width="20%" style="text-align: center">Writer</th>
				<th width="25%" style="text-align: center">Date</th>
				<th width="5%" style="text-align: center">ViewCnt</th>
			</tr>
		</thead>
		<c:forEach items="${ tboard }" var="board" begin="1" end="3">
				<tr>	
					<td>${ board.no }</td>
					<td>
						${ board.title }
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.viewCnt }</td>
				</tr>
			</c:forEach>
			</table>
				</div>
			</div> 
          </div>
          <hr>
          <div class="post-preview">
            <a href="<%= request.getContextPath() %>/sellList.do">
              <h2 class="post-title">
                Sell Board
              </h2>
              </a>
		                   	<div class="row" align="center">
		    <div class="col-md-12">
			<table id="example" class="table table-striped table-bordered" cellspacing="0" style = "width : 100%"  >
				
			<tr>
				<th width="10%" style="text-align: center">No</th>
				<th width="40%" style="text-align: center">Title</th>
				<th width="20%" style="text-align: center">Writer</th>
				<th width="20%" style="text-align: center">Date</th>
				<th width="10%" style="text-align: center">ViewCnt</th>
			</tr>
			<c:forEach items="${ mboard }" var="board" begin="0" end="2">
				<tr>	
					<td>${ board.no }</td>
					<td>
						${ board.title }
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.viewCnt }</td>
				</tr>
			</c:forEach>
		</table>
					
						</div>
					</div> 
		          </div>
		
              
          </div>
          
        
          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-secondary float-right" href="#">Older Posts &rarr;</a>
          </div>
        </div>
      </div>
    </div>
    <hr>

    <!-- Footer -->
    <footer>
        		<jsp:include page="/include/bottom.jsp"/>

    </footer>
        		<jsp:include page="/include/modal.jsp"/>
  </body>

</html>
