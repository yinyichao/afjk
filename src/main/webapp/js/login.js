$(function(){
	$("[name=username]").focus();
});
function login(){
	if($.trim($("[name=username]").val())==""){
		alert("请输入账号");
		return false;
	}else if($.trim($("[name=password]").val())==""){
		alert("请输入密码");
		return false;
	}else{
	return true;
	}
}
$(function(){
	$('#form1').ajaxForm(function(data) {
		if ("000" == data) {
			location.href = "/platform/frame";
		} else {
			alert(data);
		}
	});
});