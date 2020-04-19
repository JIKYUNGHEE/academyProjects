/**
 * 입력할 게시판에서 입력을 하지 않으면 경고창 뜨는 함수 
 */

function inNull(obj, msg){
	
	if(obj.value == ""){
		alert("msg");
		obj.focus();
		return true;
	}
	return false;
}