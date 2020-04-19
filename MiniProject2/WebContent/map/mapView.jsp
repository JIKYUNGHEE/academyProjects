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
    <link href="../Resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="../Resources/css/business-casual.css" rel="stylesheet">
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=a656392011c9b8b4e6862eb2b4272b30"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function() {
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new daum.maps.LatLng(37.4946477, 127.0276594), //지도의 중심좌표.
			level: 7 //지도의 레벨(확대, 축소 정도)
		};

		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

		// 버튼을 클릭하면 아래 배열의 좌표들이 모두 보이게 지도 범위를 재설정합니다 
		var positions = [
			{
				content: '<div>비트교육센터</div>',
		    	latlng: new daum.maps.LatLng(37.4946477, 127.0276594)
			},
			{
				content: '<div>도곡공원</div>',
				latlng: new daum.maps.LatLng(37.4903531, 127.0449972)
			},
			{
				content: '<div>양재시민의숲</div>',
				latlng: new daum.maps.LatLng(37.4706007, 127.0350838)
			},
			{
				content: '<div>서리골공원</div>',
				latlng: new daum.maps.LatLng(37.4972652, 127.0072746)
			},
			{
				content: '<div>서리풀공원</div>',
				latlng: new daum.maps.LatLng(37.4904552, 126.9996572)
			},
			{
				content: '<div>몽마르트공원</div>',
				latlng: new daum.maps.LatLng(37.4949669, 127.0035839)
			},
			{
				content: '<div>방배근린공원</div>',
				latlng: new daum.maps.LatLng(37.4760672, 126.9964170)
			},
			{
				content: '<div>반포호수체육공원</div>',
				latlng: new daum.maps.LatLng(37.5004997, 126.9941854)
			},
			{
				content: '<div>문화예술공원</div>',
				latlng: new daum.maps.LatLng(37.4685911, 127.0308566)
			},
			{
				content: '<div>양재근린공원</div>',
				latlng: new daum.maps.LatLng(37.4714692, 127.0428300)
			},
			{
				content: '<div>개포근린공원</div>',
				latlng: new daum.maps.LatLng(37.4889570, 127.0640516)
			},
			{
				content: '<div>개포공원</div>',
				latlng: new daum.maps.LatLng(37.4831338, 127.0649743)
			},
			{
				content: '<div>달터근린공원</div>',
				latlng: new daum.maps.LatLng(37.4775827, 127.0522928)
			},
			{
				content: '<div>학동공원</div>',
				latlng: new daum.maps.LatLng(37.5154788, 127.0253634)
			},
			{
				content: '<div>도산공원</div>',
				latlng: new daum.maps.LatLng(37.5243457, 127.0353627)
			},
			{
				content: '<div>청담공원</div>',
				latlng: new daum.maps.LatLng(37.5211973, 127.0526576)
			},
			{
				content: '<div>봉은공원</div>',
				latlng: new daum.maps.LatLng(37.5153256, 127.0564127)
			},
			{
				content: '<div>말죽거리공원</div>',
				latlng: new daum.maps.LatLng(37.4778041, 127.0315003)
			}
			
		    
		];
		
		var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		   
		var i, marker;
		for (var i = 0; i < positions.length; i ++) {
		    // 마커를 생성합니다
		    var marker = new daum.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng // 마커의 위치
		    });

		    // 마커에 표시할 인포윈도우를 생성합니다 
		    var infowindow = new daum.maps.InfoWindow({
		        content: positions[i].content // 인포윈도우에 표시할 내용
		    });

		    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		 	// 마커에 click 이벤트를 등록합니다
		    daum.maps.event.addListener(marker, 'click', clickListener(infowindow));
		}
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
		function clickListener(infowindow){
			return function(){
				$("#walkLocation").html(infowindow.getContent());
				$("#walkParticipants").html("<span><input type='button' id='showParticipants' value='참가자명단'></span>");
			}
		}

		$(document).on("click","#showParticipants", function(){
			$.ajax({			
				url: "/MiniProject2/meetingView.do",
				type: "POST",
				data: {
					parkName: $("#walkLocation").text()
				},
				success: function(data) {
					//alert("미팅 보기 성공!");
					//alert("미팅 데이터를 가져와서 출력할 거야")
					getParticipants(data); //미팅 등록 후 해당 미팅 리스트를 보여줌
				}		
			});
		});
		
		/* $("#showParticipants").click(function(){
			$.ajax({			
				url: "/MiniProject2/meetingView.do",
				type: "POST",
				data: {
					parkName: $("#walkLocation").text()
				},
				success: function(data) {
					alert("미팅 보기 성공!");
					alert("미팅 데이터를 가져와서 출력할 거야")
					getParticipants(data); //미팅 등록 후 해당 미팅 리스트를 보여줌
				}		
			});
		}); */
		
		$("#walkin").click(function() {
			// t_meeting에 해당 공원과 자기id가 있으면, alert("이미 참가 신청을해서 등록 못 한다고 얘기해줘야 함!")
			var check = checkMeeting1();
			if(check==true){
				alert("이미 참가신청을 하셨습니다!");
				return;
			}
			// ---
			$.ajax({			
				url: "/MiniProject2/meetingInsert.do",
				type: "POST",
				data: {
					meetingTime: $("#timetable1").val(),
					parkName: $("#walkLocation").text(),
					userId: "${sessionScope.userVO.id}",
					userNickname: "${sessionScope.userVO.nickname}",
					fileSaveName: "${sessionScope.file}",
				},
				success: function(data) {
					//alert("미팅 등록하기 성공!");
					//alert("미팅 데이터를 가져와서 출력할 거야");
					getParticipants(data); //미팅 등록 후 해당 미팅 리스트를 보여줌
					
				}		
			});
		});
		
		$("#walkout").click(function() {
			// t_meeting에 해당 공원과 id 참가 신청한 이력이 있어야 발동을 할 수 있음
			var check = checkMeeting2();
			if(check==false){
				alert("참가 신청한 이력이 없습니다!");
				return;
			}
			// ---
			$.ajax({			
				url: "/MiniProject2/meetingDelete.do",
				type: "POST",
				data: {
					meetingTime: $("#timetable2").val(),
					parkName: $("#walkLocation").text(),
					userId: "${sessionScope.userVO.id}",
				},
				success: function(data) {
					//alert("미팅 삭제하기 성공!");
					//alert("미팅 데이터를 가져와서 출력할 거야")
					getParticipants(data); //미팅 등록 후 해당 미팅 리스트를 보여줌
					
				}			
			});
		});
		
		function getParticipants(data){
		 	var list = JSON.parse(data);			
		 	var output = "";
		 	
		 	for (var i = 0; i < list.length; i++) { 			 	 		 		
                output += "<tr>";
                for (var key in list[i]) {
                    output += "<td>&nbsp;";
                    if(key == 'meetingTime'){
     					output += list[i].meetingTime +"&nbsp;&nbsp;</td>"; 
                    }else if(key == 'fileSaveName'){
     					output += "<td><img width='50' height='50' src='/MiniProject2/upload/"+list[i].fileSaveName+"'></td>" ;
     			
                    }else if(key == 'userNickname'){
                    	output += "<td>&nbsp;&nbsp;["+list[i].userNickname+"]" ;
                    	if("${sessionScope.userVO.nickname}"==list[i].userNickname){
     	                	//alert("같군요!");
     	                	output += "&nbsp;<img class='profilepic' src='/MiniProject2/Resources/img/mycheck.png' width='20' height='20'>&nbsp;&nbsp;";
     	                }
                    }output += "</td>";
                   
                    	
                }
                
                output += "</tr>";
               
        	};
          	$("#walkParticipants").html(output); // #walkParticipants 영역에 output 출력
          	$(".profilepic").parent().parent().css("background-color","#F6FAB3");
	 	}
		
		function checkMeeting1(){
			// 해당 공원과 id에 맞는 이력이 있으면 true, 없으면 false
			var check;
			var bool;
			$.ajax({			
				url: "/MiniProject2/meetingCheck.do",
				type: "POST",
				async: false,
				data: {
					meetingTime: $("#timetable1").val(),
					parkName: $("#walkLocation").text(),
					userId: "${sessionScope.userVO.id}",
				},
				success: function(data) {
					check = jQuery.trim(data);
					//alert("미팅 체크하기 성공!");
					//alert("미팅 체크 data에 true false 가져올 것임");
					
					if(check=="true"){
						bool = true;
					}
					else{
						bool= false;
					}
				}			
			});
			return bool;
		}
		
		function checkMeeting2(){
			// 해당 공원과 id에 맞는 이력이 있으면 true, 없으면 false
			var check;
			var bool;
			$.ajax({			
				url: "/MiniProject2/meetingCheck.do",
				type: "POST",
				async: false,
				data: {
					meetingTime: $("#timetable2").val(),
					parkName: $("#walkLocation").text(),
					userId: "${sessionScope.userVO.id}",
				},
				success: function(data) {
					check = jQuery.trim(data);
					//alert("미팅 체크하기 성공!");
					//alert("미팅 체크 data에 true false 가져올 것임");
					
					if(check=="true"){
						bool = true;
					}
					else{
						bool= false;
					}
				}			
			});
			return bool;
		}
		
	});
	

</script>
  </head>

  <body>
  
    <jsp:include page="../include/topMenu.jsp" />

    <div class="container">

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">함께
          <strong>산책 가기</strong>
        </h2>
        <hr class="divider">
        <div class="row">
          <div class="col-lg-8">
              <div id="map" style="width:650px;height:400px;"></div>
          </div>
          <div class="col-lg-4">
            <h5 class="mb-0"><strong>산책 장소</strong></h5>
            <div class="mb-4" id="walkLocation">마커를 클릭하세요</div>
            <h5 class="mb-0"><strong>참가자 명단</strong></h5>
            <div class="mb-4" id="walkParticipants"><span></span></div>
            <h5 class="mb-0"><strong>참가 신청</strong></h5>
            <div class="mb-4">
            <form>
            <select id="timetable1">
            	<option value="오전 05시">오전 05시</option>
            	<option value="오전 06시">오전 06시</option>
            	<option value="오전 07시">오전 07시</option>
            	<option value="오전 08시">오전 08시</option>
            	<option value="오전 09시">오전 09시</option>
            	<option value="오전 10시">오전 10시</option>
            	<option value="오전 11시">오전 11시</option>
            	<option value="오후 12시">오후 12시</option>
            	<option value="오후 01시">오후 01시</option>
            	<option value="오후 02시">오후 02시</option>
            	<option value="오후 03시">오후 03시</option>
            	<option value="오후 04시">오후 04시</option>
            	<option value="오후 05시">오후 05시</option>
            	<option value="오후 06시">오후 06시</option>
            	<option value="오후 07시">오후 07시</option>
            	<option value="오후 08시">오후 08시</option>
            	<option value="오후 09시">오후 09시</option>
            	<option value="오후 10시">오후 10시</option>
            	<option value="오후 11시">오후 11시</option>
            </select><br>
            <input type="button" id="walkin" value="참가신청">
            </form>
            </div>
            <h5 class="mb-0"><strong>참가 취소</strong></h5>
            <div class="mb-4">
            <form>
           	<select id="timetable2">
            	<option value="오전 05시">오전 05시</option>
            	<option value="오전 06시">오전 06시</option>
            	<option value="오전 07시">오전 07시</option>
            	<option value="오전 08시">오전 08시</option>
            	<option value="오전 09시">오전 09시</option>
            	<option value="오전 10시">오전 10시</option>
            	<option value="오전 11시">오전 11시</option>
            	<option value="오후 12시">오후 12시</option>
            	<option value="오후 01시">오후 01시</option>
            	<option value="오후 02시">오후 02시</option>
            	<option value="오후 03시">오후 03시</option>
            	<option value="오후 04시">오후 04시</option>
            	<option value="오후 05시">오후 05시</option>
            	<option value="오후 06시">오후 06시</option>
            	<option value="오후 07시">오후 07시</option>
            	<option value="오후 08시">오후 08시</option>
            	<option value="오후 09시">오후 09시</option>
            	<option value="오후 10시">오후 10시</option>
            	<option value="오후 11시">오후 11시</option>
            </select><br>
            <input type="button" id="walkout" value="참가취소">
            </form>
            </div>
          </div>
        </div>
      </div>


    </div>
    <!-- /.container -->

    <jsp:include page="../include/bottom.jsp" />

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

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