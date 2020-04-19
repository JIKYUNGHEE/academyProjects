<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
   function goBack(){
      location.href="index.jsp";
   }
</script>

</head>
<body>

		<jsp:include page="/include/topmenu.jsp"/>
 <header style="margin-bottom:200px;">
     
   </header>
   <section>
   <div class="page-header-wrapper">
         <div class="container">
            <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
            <h2>KAKAO JOIN</h2>
            <div class="devider"></div>
            <p class="subtitle">추가 항목을 입력해주세요</p>
             </div>
         </div>
      </div>
      <div class="container" align="center">
         <form action="<%= request.getContextPath() %>/joinForm.do" method="post" name="form" >
           <input type="hidden" name="id" " value="${ param.id }"/>
           <input type="hidden" name="pw" value="${ param.password }"/>
           <input type="hidden" name="name" value="${ param.name }"/>
         
         <table border="1" class="join">
              
               <tr>
                  <th>Addr</th>
                  <td colspan="3">
                     <input type="text" name="addr" class="putInfo" size="70">
                  </td>
               </tr>
               <tr>
                  <th>Phone</th>
                  <td colspan="3">
                     <input type="text" size = "20" name ="tel">
                  </td>
               </tr>
               
            </table>
            <br><br>
         <input type="submit"  class="btn wow bounceInRight" data-wow-delay="0.8s" value="가입">
         <input type="button"  class="btn wow bounceInRight" data-wow-delay="0.8s" value="취소">
      </form>
      </div>
   </section>
   
     <!-- Footer -->
    <footer>
        		<jsp:include page="/include/bottom.jsp"/>

    </footer>
        		<jsp:include page="/include/modal.jsp"/>
   
</body>

</html>