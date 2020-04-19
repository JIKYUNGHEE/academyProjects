/**
 * Ajax 통신을 위한 함수 구현
 */

var httpReqeust = null;

function getXMLHttpRequest(){
	if(window.XMLHttpRequest){
		httpRequest = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		httpRequest = new ActiveXObject("Microsoft.XMLHttp");
	}else{
		httpRequest = null;
	}
	return httpRequest;
}

function sendRequest(method, url, params, callback){
	httpRequest = getXMLHttpRequest();
	
	httpRequest.onreadystatechange = callback;
	
	/* get or post 기억 변수 */
	var httpMethod = method;
	if(method!='GET' && method!='POST'){		//대소문자 구분 X(일단)
		httpMethod = 'GET';
	}
	
	//var httpParams = params;		// module.jsp에서 params가 한번에 날라오는 경우 -> if 조건 해 줄 필요 X
	var httpParams = '';	// module.jsp에서 JSON 형태로 날라오는 경우
	
	/* JSON 형태로 날아오는 경우 처리 */
	if(params != null && params !=''){
		for(var key in params){	// forEach문으로
			if(httpParams != ''){
				httpParams += "&";
			}
				httpParams += key+ '=' +	encodeURIComponent(params[key]);
		}
	}
	
	var httpUrl = url;
	
	if(httpMethod=='GET' && httpParams !='' && httpParams !=null ){
		httpUrl = httpUrl + '?' + httpParams;
	}
	
	
	httpRequest.open(httpMethod, httpUrl, true);
	
	if(httpMethod=='POST'){
		httpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');		// post는 form태그 적용 시 전송가능하므로
	}
	
	httpRequest.send(httpMethod=='GET' ? null : httpParams);
}