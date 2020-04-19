<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>BLER MOA - Starbucks Tumbler review</title>

  <!-- Bootstrap core CSS -->
  <link href="<%= request.getContextPath() %>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">
</head>
<body>

	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
	    <div class="container">
	      <div class="bg-faded p-4 my-4">
	        <!-- Image Carousel -->
	        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	          <ol class="carousel-indicators">
	            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	          </ol>
	          <div class="carousel-inner" role="listbox">
	            <div class="carousel-item active">
	              <img class="d-block img-fluid w-100" src="img/01.png" alt="">
	              <div class="carousel-caption d-none d-md-block">
	                <h3 class="text-shadow">First Tumbler</h3>
	                <p class="text-shadow">흩날리는 벚꽃잎을 담은 TUMBLER.</p>
	              </div>
	            </div>
	            <div class="carousel-item">
	              <img class="d-block img-fluid w-100" src="img/02.jpg" alt="">
	              <div class="carousel-caption d-none d-md-block">
	                <h3 class="text-shadow">Second Tumbler</h3>
	                <p class="text-shadow">상쾌한 여름을 표현한 TUMBLER.</p>
	              </div>
	            </div>
	            <div class="carousel-item">
	              <img class="d-block img-fluid w-100" src="img/03.png" alt="">
	              <div class="carousel-caption d-none d-md-block">
	                <h3 class="text-shadow">Third Tumbler</h3>
	                <p class="text-shadow">아름다운 여름 밤 하늘을 표현한 TUMBLER.</p>
	              </div>
	            </div>
	          </div>
	          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	            <span class="sr-only">Previous</span>
	          </a>
	          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	            <span class="carousel-control-next-icon" aria-hidden="true"></span>
	            <span class="sr-only">Next</span>
	          </a>
	        </div>
	        <!-- Welcome Message -->
	        <div class="text-center mt-4">
	          <div class="text-heading text-muted text-lg">Welcome To</div>
	          <h1 class="my-2" style="font-family: 'Fredericka the Great'; font-weight: normal;">BLER MOA</h1>
	          <div class="text-heading text-muted text-lg" >By
	            <strong>Team 1.</strong>
	          </div>
	        </div>
	      </div>
	
	      <div class="bg-faded p-4 my-4">
	        <hr class="divider">
	        <h2 class="text-center text-lg text-uppercase my-0">What is
	          <strong>BLER MOA ?</strong>
	        </h2>
	        <hr class="divider">
	        <img class="img-fluid float-left mr-4 d-none d-lg-block" src="img/a1.png" alt="">
	        <p style="font-family: 나눔명조;">블러모아는 스타벅스 텀블러에 관한 정보 그리고 해당 텀블러에 대한 리뷰, 회원 개개인 소유의 텀블러정보,그리고 텀블러 중고 마켓까지 스타벅스 텀블러만을 위한 복합 사이트입니다.</p>
	        <br>
	        <br>
	        <br>
	        <br>
	      </div>
	    </div>
    <!-- /.container -->
    </section>

    <footer class="bg-faded text-center py-5">
    	<jsp:include page="/jsp/include/bottom.jsp"></jsp:include>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="<%= request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%= request.getContextPath() %>/vendor/popper/popper.min.js"></script>
    <script src="<%= request.getContextPath() %>/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>