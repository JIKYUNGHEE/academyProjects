<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>Petting</title>

    <!-- Bootstrap core CSS -->
    <link href="/MiniProject2/Resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="/MiniProject2/Resources/css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <jsp:include page="include/topMenu.jsp" />
s
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
              <img class="d-block img-fluid w-100" src="/MiniProject2/Resources/img/maindog2.jpg" alt="" style="height:600px">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow">반려동물과 함께하고 계신가요?</h3>
                <p class="text-shadow">Companion animals are our best friends</p>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="/MiniProject2/Resources/img/maindog1.jpg" alt="" style="height:600px">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow">동물과 인간의 특별한 연대</h3>
                <p class="text-shadow">A strong companionship with your pet</p>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="/MiniProject2/Resources/img/maindog5.jpg" alt="" style="height:600px">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow">반려동물과의 소통을 경험하세요</h3>
                <p class="text-shadow">Enjoy an interactive day with your animal friends</p>
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
          <h1 class="my-2">Petting </h1>
          <div class="text-heading text-muted text-lg">By
            <strong>Group 2, Bit Computer Academy </strong>
          </div>
        </div>
      </div>

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Our goal is to <strong>strengthen the bond between people and their pets.</strong>
        </h2>
        <hr class="divider">
        <img class="img-fluid float-left mr-4 d-none d-lg-block" src="/MiniProject2/Resources/img/intro-pic.jpg" alt="">
        <p>현대 사회는 점점 더 핵가족이 많아지고 혼자 사는 사람도 늘어나고 있습니다. 그러면서 사람은 함께 생활하는 강아지나 고양이와 같은 동물을 마치 가족처럼 생각하게 되었습니다.</p>
        <p>예전에는 사람과 같이 생활하는 동물을 사람에게 즐거움을 주기 위해 기르는 동물이라는 뜻으로 ‘애완동물’이라고 불렀습니다. 그러나 요즈음에는 동물이 사람과 함께 더불어 살아가며 심리적으로 안정감과 친밀감을 주는 친구, 가족과 같은 존재라는 뜻에서 ‘반려 동물’이라고 부릅니다. 반려 동물은 전통적인 반려 동물인 개와 고양이뿐만 아니라 앵무새, 고슴도치, 토끼, 햄스터 등으로 종류가 다양해지고 있습니다.</p>
        <p>반려 동물과 함께 생활한 아이는 그렇지 않은 아이에 비해 심리적으로 안정되어 있고, 반려 동물과의 지속적인 관계를 통해 감성이나 사회성, 공감하는 능력이 높게 나타납니다. 또 정신 질환을 앓고 있는 노인도 반려 동물과 함께 생활하면 심리적인 안정감과 자신감이 높아져서 정신 건강에 큰 도움이 됩니다.</p>
      </div>

      <!-- <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Beautiful boxes to
          <strong>showcase your content</strong>
        </h2>
        <hr class="divider">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam soluta dolore voluptatem, deleniti dignissimos excepturi veritatis cum hic sunt perferendis ipsum perspiciatis nam officiis sequi atque enim ut! Velit, consectetur.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam pariatur perspiciatis reprehenderit illo et vitae iste provident debitis quos corporis saepe deserunt ad, officia, minima natus molestias assumenda nisi velit?</p>
      </div> -->

    </div>
    <!-- /.container -->

    <jsp:include page="include/bottom.jsp" />

    <!-- Bootstrap core JavaScript -->
    <script src="/MiniProject2/Resources/vendor/jquery/jquery.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/popper/popper.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>