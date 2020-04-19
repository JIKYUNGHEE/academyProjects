<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
    
    
    
<script src="/MiniProject2/js/checkForm.js"></script>
<script type="text/javascript">

function doUpload(){
	
	var f = document.parent;
	if(confirm("업로드할까요?"))
	{
		if(isNull(f.pName,"펫이름을 입력하세용"))
		{
			return false;	
		}
		if(isNull(f.pIntro,"마이펫을 자랑해주세요"))
		{
			return false;	
		}
		return true;
	}
	else
		return false;
	
}

</script>
  </head>

  <body>

    <jsp:include page="../include/topMenu.jsp" />

    <div class="container">

      <!-- <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Contact
          <strong>Business Casual</strong>
        </h2>
        <hr class="divider">
        <div class="row">
          <div class="col-lg-8">
            <div class="embed-responsive embed-responsive-16by9 map-container mb-4 mb-lg-0">
              <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?hl=en&amp;ie=UTF8&amp;ll=37.0625,-95.677068&amp;spn=56.506174,79.013672&amp;t=m&amp;z=4&amp;output=embed"></iframe>
            </div>
          </div>
          <div class="col-lg-4">
            <h5 class="mb-0">Phone:</h5>
            <div class="mb-4">123.456.7890</div>
            <h5 class="mb-0">Email:</h5>
            <div class="mb-4">
              <a href="mailto:name@example.com">name@example.com</a>
            </div>
            <h5 class="mb-0">Address:</h5>
            <div class="mb-4">
              3481 Melrose Place
              <br>
              Beverly Hills, CA 90210
            </div>
          </div>
        </div>
      </div> -->

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong>마이펫 자랑거리</strong>
        </h2>
        <hr class="divider">
        <form action="<%=request.getContextPath()%>/likeUploadProcess.do" onsubmit="return doUpload()" method="post" name="parent" enctype="multipart/form-data">
          <div class="row">
            
            <div class="form-group col-lg-12">
              <label class="text-heading font-weight-bold">Title</label>
              <textarea name="title" class="form-control" rows="1"></textarea>
            </div>
            
            <div class="clearfix"></div>
            <div class="form-group col-lg-4">
              <label class="text-heading font-weight-bold">UserId</label>
              <input name="id" type="text" class="form-control" value="${ userVO.id }" readonly>
            </div>
            <div class="form-group col-lg-4">
              <label class="text-heading font-weight-bold">Pet Name</label>
              <input name="pName"type="text" class="form-control">
            </div>
            <div class="form-group col-lg-4">
              <label class="text-heading font-weight-bold">사진업로드</label>
              <input type="file" name="attachfile1" class="form-control">
            </div>
            <div class="clearfix"></div>
            <div class="form-group col-lg-12">
              <label class="text-heading font-weight-bold">Pet Brag</label>
              <textarea name="pIntro" class="form-control" rows="6"></textarea>
            </div>
            <div class="form-group col-lg-12">
              <button type="submit" class="btn btn-secondary">Submit</button>
            </div>
          </div>
        </form>
      </div>

    </div>
    <!-- /.container -->

 <jsp:include page="/include/bottom.jsp" />

  <!-- Bootstrap core JavaScript -->
	<script src="<%= request.getContextPath() %>/Resources/vendor/jquery/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/popper/popper.min.js"></script>
	<script src="<%= request.getContextPath() %>/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Zoom when clicked function for Google Map -->
    <script>
      $('.map-container').click(function () {
        $(this).find('iframe').addClass('clicked')
      }).mouseleave(function () {
        $(this).find('iframe').removeClass('clicked')
      });
    </script>

  </body>

</html>
