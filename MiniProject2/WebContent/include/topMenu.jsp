<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

	<div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Petting</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Pets provide their owners physical and emotional benefits.</div>
<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/index.jsp">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/freeBoardList.do">자유게시판</a>
            </li>
			<li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/like.do">펫자랑</a>
            </li>
            <c:if test="${ not empty userVO }">
			<li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/map/mapView.jsp">함께산책</a>
            </li>
            </c:if>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/walk.do">산책로정보</a>
            </li> 
             <c:if test="${ not empty userVO }">
               <c:choose>
                  <c:when test="${ userVO.type eq 'U' }">
                     <li class="nav-item px-lg-4">
                     <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/qnaBoard.do">Q&A</a>
                     </li>
                   </c:when>
                   <c:otherwise>
                      <li class="nav-item px-lg-4">
                     <a class="nav-link text-uppercase text-expanded" href="/MiniProject2/qnaBoard_S.do">Q&A</a>
                     </li>
                   </c:otherwise>
               </c:choose>
         	</c:if>            
            <c:if test="${ empty userVO }">
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" data-toggle="modal" href="#myModal">로그인</a>
            </li>   
            </c:if>
            <c:if test="${ not empty userVO }">
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="<%= request.getContextPath()%>/myinfoDetail.do">마이페이지</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="<%= request.getContextPath()%>/logout.do">로그아웃</a>
            </li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
  
  <jsp:include page="loginModal.jsp" />