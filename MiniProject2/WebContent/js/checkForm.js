/**
 * Form에 관련된 메소드 모음
 */

function isNull(obj, msg) {
	if (obj.value == "") {
		alert(msg);
		obj.focus();
		return true;
	}
	return false;
}

