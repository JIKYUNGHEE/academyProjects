<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

  <head>
<script src ="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
   function doAction(type) {
      
      switch(type){
      
      case 'U':
            location.href="/MiniProject2/modifyForm.do?no=${param.no}";
         break;
         
      case 'D':
         if(confirm("삭제하시겠습니까?")){
            location.href = "/MiniProject2/delete.do?no=${param.no}"; 
         }
         break;
         
      case 'L': 
         location.href = "./freeBoardList.do";
         break;
      
      }
      
   }
   
   
   $(document).ready(function(){
      $("#reply_btn").click(function(){
         
         
         if($("#reply_content").val().trim()==""){
            alert("댓글을 입력하세요.");
            $("#reply_content").val("").focus();
         }else{
            $.ajax({         
               url: "/MiniProject2/ReplyWriteController.do",
               type: "POST",
               data: {
                  no: $("#no").val(),
                  id: "${ sessionScope.userVO.nickname }",
                  reply_content: $("#reply_content").val()
               },
               success: function(data) {
                  alert("댓글이 등록되었습니다.");
                  $("#reply_content").val("");
                  getReply(data); //댓글 등록 후 리스트를 보여줌
                  
               },         
            })
         }
            
      });
      
      
       $(document).on("click", "#deletereply_btn", function(){
          
            if(confirm("정말 삭제하시겠습니까?")==false){
               return false;
               
            }else{
               $.ajax({      
                  url: "/MiniProject2/ReplyDeleteController.do",
                  type: "POST",
                  data: {                        
                     no : $(this).prev().val(),
                     board_no: $("#no").val()                     
                  },
                  success: function(data) {
                     alert("댓글이 삭제되었습니다.");
                     getReply(data);
                     
                  },         
               }); 
            }
               
         });
   
      
       function getReply(data){
             var list = JSON.parse(data);         
             var output = "";
             //alert('${ replylist[0].id}');
             for (var i = 0; i < list.length; i++) {                            
                    output += "<tr>";
                   for (var key in list[i]) {                      
                       var reply_no;
                       if(key == 'reply_no'){
                          reply_no = list[i].reply_no;           
                    }else if(key == 'id'){
                          output += "<td width='10%'><strong>" + list[i].id + "</strong></td>" ;
                       }else if(key == 'reply_content'){
                          output += "<td width='60%'>" + list[i].reply_content + "</td>" ;
                       }else if(key == 'reply_date'){                          
                         output += "<td>" + list[i].reply_date+"</td>";                                    
                       }
                       
      
                   }
                   
                    /* output += "<td><input type='hidden' id='reply_no' value="+reply_no+"><input type='button' id='deletereply_btn' value='삭제'/></td></tr>"; */
                    output += "<td><input type='hidden' id='reply_no' value="+reply_no+">";
                    
                    if(list[i].id == "${sessionScope.userVO.nickname}" || "${ sessionScope.userVO.type}"=='S'){
                          output += "<input type='button' class='btn btn secondary' id='deletereply_btn' value='삭제'/></td></tr>"
                       }
                    else{
                       output += "</td></tr>"
                    }
                
             };
              
                 $("#replyList").html(output); // replyList 영역에 output 출력
                 
       }
   });
   
   

</script>
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
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath()%>/Resources/css/detailTable.css"/><!-- 테이블 css template -->

  </head>

  <body>

   
    <jsp:include page="../include/topMenu.jsp" />


    <div class="container">
    <div class="bg-faded p-4 my-4">
   <div align="center">
       <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong>게시글</strong>
        </h2>
        <hr class="divider">
      
   <table class="type05" style="width:80%">
         <tr>
            <th width="25%">번호</th>
            <td>${ board.no }</td>
         </tr>
         
         <tr>
            <th>제목</th>
            <td><c:out value="${ board.title }"/></td>
         </tr>
         <tr>
            <th>작성자</th>
            <td><c:out value="${ board.writer }"/></td>
         </tr>
         
         <tr>
            <th>내용</th>
            <td><c:out value="${ board.content }"/></td>
         </tr>
         
         <tr>
            <th>조회수</th>
            <td>${ board.viewCnt+1 }</td>
         </tr>
         
         <tr>
            <th>등록일</th>
            <td>${ board.regDate }</td>
         </tr>
         <tr>
            <th>첨부파일</th>
            <td>
            <c:forEach items="${ fileList }" var="file">
               <a href="<%= request.getContextPath() %>/upload/${ file.fileSaveName }" target="_blank"> <!-- eclipse-work폴더에 있는걸로 접근을 해야 한다.. -->
               ${ file.fileOriName }
               </a>
               (${ file.fileSize } byte(s)) <br/> <!-- 파일이 여러개(0~2개) 이므로.. -->
               <img style="width:500px;"src="<%= request.getContextPath() %>/upload/${ file.fileSaveName }" />
               <br/>
            </c:forEach>            
            </td>
         </tr>
   
      </table>
      
      <br/><br/>
      <c:if test="${ (userVO.nickname eq board.writer) or (sessionScope.userVO.type eq 'S') }">
      <button class="btn btn-secondary" onclick="doAction('U')">수정</button> &nbsp;&nbsp;
      <button class="btn btn-secondary" onclick="doAction('D')">삭제</button> &nbsp;&nbsp;
      </c:if>
      <button class="btn btn-secondary" onclick="doAction('L')">목록</button>
      
      
      <!-- 댓글 -->
      <br/><br/>
      <div  class="w3-border w3-padding">[Comments]</div><br/>
         <div class="w3-border w3-padding">
            
            
            
               <i class="fa fa-user w3-padding-16"></i> <%-- ${ content.id } --%>               
               <table id="replyList" style="width:80%">
            
               <c:forEach items="${ replylist }" var="reply" varStatus="loop">
                  <tr>   
                     <td width="10%"><input type="hidden" id="reply_id" value="${ reply.id }"/><strong>${ reply.id }</strong></td>                  
                     <td width="60%">${ reply.reply_content }</td>
                     <td>${ reply.reply_date }</td>
                     <td><input type="hidden" name="reply_no" id="reply_no" value="${ reply.reply_no }">                  
                     &nbsp;&nbsp;&nbsp;
                     <!-- <a href="javascript:click_btn();">삭제</a> -->
                     <c:if test="${ (userVO.nickname eq reply.id) or (sessionScope.userVO.type eq 'S') }">
                     <input type="button" class="btn btn secondary" id="deletereply_btn" value="삭제"/>
                     </c:if>
                     
                     
                     </td>
                     
                  </tr>               
               </c:forEach>   
                        
               </table>   
               
               
               <form>                  
                  <table id="replyList"></table>         
                  <br/>
               <c:if test="${ userVO.id == null }">
                     <textarea rows="2" cols="60" class="w3-input w3-border newLogin" readonly>댓글 작성은 로그인 후에 가능합니다.</textarea>
               </c:if>
               <c:if test="${ userVO.id != null }"> 
                  <input type="hidden" name="no" id="no" value="${ board.no }"> 
                  <textarea rows="2" cols="60" class="w3-input w3-border" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>
                  <input type="button" class="btn btn-secondary" id="reply_btn" value="댓글 등록">
               </c:if>   
               </form>
            
         </div>
               
      
      <br/><br/>
      
   
   </div>
   </div>
   </div>

     <!-- /.container -->
     

    <footer>
           <jsp:include page="../include/bottom.jsp" />      
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="/MiniProject2/Resources/vendor/jquery/jquery.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/popper/popper.min.js"></script>
    <script src="/MiniProject2/Resources/vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>