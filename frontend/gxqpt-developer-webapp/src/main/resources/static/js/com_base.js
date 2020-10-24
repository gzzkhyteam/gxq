/*获取token*/

function getToken(parent) {
	return $.cookie("_token");
}
function getCurUserId(parent) {
	return $.cookie("_user_id");
}

function getHeaders(parent){
    return {
        "token": getCurToken()
    }
}

function getUrlPrev(gateUrl) {
    return gateUrl+'/api/developer/';//服务器的服务
    // return 'http://192.168.1.54:10003/api/admin/';//厚兵的服务
    //  return 'http://192.168.1.36:10003/api/developer/';//灯波的服务
    // return 'http://192.168.1.124:10003/api/admin/';//王镇的服务
    // return 'http://192.168.1.62:10003/api/admin/';//昌宏的服务
    // return 'http://192.168.1.36:10003/api/admin/';
}

$(function () {
    $("form").find('select option[value="?"]').val(null);//解决angular自动给空的select"?"导致不能验证为空的问题
})


function getCurToken() {
	var token =  $.cookie("_token");
	if(!token){
		token = window.sessionStorage.getItem("_token");
		if(!token){
			$.ajax({
				url: _cp+"/refreshToken",
				async: false,
				method:"post",
				success: function (tokenStr){
					token = tokenStr;
					if(token){
						window.sessionStorage.setItem("_token",token);
					}
				}
			})
		}
	}
	return token;
}