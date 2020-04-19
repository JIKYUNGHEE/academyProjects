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
<link
	href="<%=request.getContextPath()%>/Resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/Resources/css/business-casual.css"
	rel="stylesheet">

<script type="text/javascript">
	function click_btn(data) {
		window
				.open("/MiniProject2/likePopUp.do?like_no=" + data, "popup1",
						"width=1000, height=700, resizable=yes, scrollbars=no, left=100%, top=100%");
	}
</script>
</head>

<body>

	<jsp:include page="../include/topMenu.jsp" />

	<div class="container">

		<!--    <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">About
          <strong>Business Casual</strong>
        </h2>
        <div class="row">
        <hr class="divider">
          <div class="col-lg-6">
            <img class="img-fluid mb-4 mb-lg-0" src="resources/img/slide-2.jpg" alt="">
          </div>
          <div class="col-lg-6">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam soluta dolore voluptatem, deleniti dignissimos excepturi veritatis cum hic sunt perferendis ipsum perspiciatis nam officiis sequi atque enim ut! Velit, consectetur.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam pariatur perspiciatis reprehenderit illo et vitae iste provident debitis quos corporis saepe deserunt ad, officia, minima natus molestias assumenda nisi velit?</p>
          </div>
        </div>
      </div> -->

		<div class="bg-faded p-4 my-4">
			<hr class="divider">
			<h2 class="text-center text-lg text-uppercase my-0">
				<strong>My Lovely Pet</strong>
			</h2>
			<hr class="divider">

			<c:if test="${ userVO.id != null }">
				<a class="btn btn-secondary"
					href="<%=request.getContextPath()%>/likeUpload.do">자랑하기</a>
			</c:if>

			<div style="height: 10px"></div>
			<div class="row">
				<c:forEach items="${orderbyList}" var="pet">
					<c:forEach items="${fileList}" var="file">
						<c:if test="${file.like_no eq pet.like_no}">
							<c:set var="petTitle" value="${pet.title}" scope="page" />
							<c:set var="file_savename" value="${file.savename }" scope="page" />
						</c:if>
					</c:forEach>

					<div class="col-md-4 mb-4 mb-md-0">
						<div class="card h-100">
							<a href="javascript:click_btn(${pet.like_no });"> <img
								class="card-img-top"
								src="<%=request.getContextPath()%>/upload/${file_savename}"
								alt="">
							</a>
							<div class="card-body text-center">
								<h6 class="card-title m-0">${petTitle }</h6>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--  <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <br/>
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <br/>
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <br/>
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4 mb-4 mb-md-0">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card h-100">
              <img class="card-img-top" src="http://placehold.it/750x450" alt="">
              <div class="card-body text-center">
                <h4 class="card-title m-0">John Smith
                  <small class="text-muted">Job Title</small>
                </h4>
              </div>
            </div>
          </div> -->
			</div>
			<div style="height: 10px"></div>
			<!-- 페이징 시작 -->

			<table border="1" width="100%">
				<tr>
					<td colspan="6" align="center"><c:if test="${count >0}">
							<c:if test="${endPage > pageCount }">
								<!-- 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당 -->
								<c:set value="${pageCount }" var="endPage" scope="request" />
							</c:if>
							<!-- 페이지 블록수보다 startPage가 클경우 이전 링크 생성 -->
							<c:if test="${startPage >pageBlock }">
								<a
									href="<%=request.getContextPath()%>/like.do?pageNum=${startPage-4}">[이전]</a>
							</c:if>

							<c:forEach var="i" begin="${startPage }" end="${endPage }">
								<!--페이지 블록 번호 -->
								<c:choose>
									<c:when test="${ i eq currentPage }">
										<!-- 현재 페이지에는 링크를 설정하지 않음 -->
								[${i}]
								</c:when>
									<c:otherwise>
										<!-- 현재 페이지가 아닌 경우 링크 설정 -->
										<a href="<%=request.getContextPath()%>/like.do?pageNum=${i}">[${i}]</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${endPage < pageCount }">
								<!-- 현재 블록의 마지막 페이지보다 페이지 전체 블록수가 클경우 다음 링크 생성 -->
								<a
									href="<%=request.getContextPath()%>/like.do?pageNum=${startPage + 4}">[다음]</a>
							</c:if>


						</c:if></td>
				</tr>
			</table>


			<!-- 페이징 종료 -->






































































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
