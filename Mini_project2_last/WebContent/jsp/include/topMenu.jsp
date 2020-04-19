<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block" 
	style="font-family: 'Fredericka the Great'; font-weight: normal;">BLER MOA</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block" 
    	style="font-family:'Adobe Thai'">Starbucks Tumbler Review</div>
   	<c:if test="${ not empty loginUser }">
	    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block" 
	    	style="font-family:'Adobe Thai'; font-size: 12pt;">[♥${ loginUser.nickname }님 로그인 중..♥]</div>
	</c:if>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="<%=request.getContextPath()%>//FirstPage.jsp">BLER MOA</a>
        <c:if test="${ not empty loginUser }">
        	<a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#"
        		style="color: #9282CD; font-size: 8pt;">[♥${ loginUser.nickname }님 로그인 중..♥]</a>
        	<a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="<%=request.getContextPath()%>/logout.do"
        		style="color: #9282CD; font-size: 8pt;">LOGOUT</a>
        </c:if>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" 
        		aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="<%=request.getContextPath()%>/FirstPage.jsp">HOME
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              	<form action="<%= request.getContextPath() %>/info.do" id="tum" method="post">
				<input type="hidden" name="type" value="a">
				<a class="nav-link text-uppercase text-expanded" 
					onclick="document.getElementById('tum').submit();"
				href="#">TUMBLER</a>
				</form>
            </li>
            <li class="nav-item px-lg-4">
              <form action="<%= request.getContextPath() %>/acc.do" id="acc" method="post">
				<input type="hidden" name="type" value="b">
				<a class="nav-link text-uppercase text-expanded" 
					onclick="document.getElementById('acc').submit();"
				href="#">ACCESSORY</a>
			  </form>
            </li>
            <li class="nav-item px-lg-4">
              <form action="<%= request.getContextPath() %>/BoardList.do" id="board" method="post">
					<input type="hidden" name="type" value="c">
					<a class="nav-link text-uppercase text-expanded" 
					onclick="document.getElementById('board').submit();"
				href="#">BOARD</a>
			  </form>
            </li>
            <li class="nav-item px-lg-4">
              <form action="<%= request.getContextPath() %>/BoardList.do" id="mar" method="post">
					<input type="hidden" name="type" value="d">
					<a class="nav-link text-uppercase text-expanded" 
					onclick="document.getElementById('mar').submit();"
				href="#">MARKET</a>
			  </form>
            </li>
            <%-- <li class="nav-item px-lg-4">
              <form action="<%= request.getContextPath() %>/QnA.do" id="qna" method="post">
					<input type="hidden" name="type" value="e">
					<a class="nav-link text-uppercase text-expanded" 
					onclick="document.getElementById('qna').submit();"
				href="#">QnA</a>
			  </form>
            </li> --%>
             <c:if test="${ loginUser.type eq 'S' }">
	            <li class="nav-item px-lg-4">
	              <a class="nav-link text-uppercase text-expanded" href="<%=request.getContextPath()%>/userlist.do">USER</a>
	            </li>
            </c:if>
            <li id="li_mypage" class="nav-item px-lg-4">
              <a id="a_mypage" class="nav-link text-uppercase text-expanded" href="<%=request.getContextPath()%>/jsp/mypage/mypage.jsp">MYPAGE</a>
            </li>
            <c:if test="${ not empty loginUser }">
	            <li class="nav-item px-lg-4">
	            	 <a class="nav-link text-uppercase text-expanded" href="<%=request.getContextPath()%>/logout.do">LOGOUT</a>
	            </li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>