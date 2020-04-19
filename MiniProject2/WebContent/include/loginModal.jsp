 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/MiniProject2/Resources/vendor/jquery/checkForm.js"></script>
<script>
function checkForm(){
	
	var f = document.lform;
	
	if(isNull(f.id, '아이디를 입력해 주세요')){
		return false;
	}
	
	if(isNull(f.password, '패스워드를 입력해 주세요')){
		return false;
	}
}

function goJoin(){
	location="<%= request.getContextPath()%>/join.do";
}
</script>
 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <form role="form" name="lform" action="<%= request.getContextPath()%>/loginProcess.do" onsubmit="return checkForm()" method="post">
            <div class="form-group">
              <label for="id"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="id" name="id" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
            </div>
            <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>회원이 아니십니까? <a href="#" onclick='goJoin()'>회원 가입</a></p>
        </div>
      </div>
    </div>
  </div>