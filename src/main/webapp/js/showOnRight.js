 var second = 0;
var secondg = 0;
	$(function(){
	setTimeout("showaa()",1000);
	});
  var jsj = setInterval("aa()", 1000);
function aa() {
	if ($("#showa").html() == "") {
		second += 1;
	}
	if ($("#showa").html() != "") {
		secondg += 1;
	}
	if (secondg == 15) {
		$("#showa").html("");
		second = 0;
		secondg = 0;
	}
	if (second == 60) {
		showaa();
		second = 0;
		secondg = 0;
	}
}
function gb(){
	$("#showa").html("");
	second = 0;
	secondg = 0;
}
function showaa() {
	var div = "";
	div = div + "<div style=\'z-index: 9999\' id=\'yins\' ><table style='background-color:white;'><tr>消息提醒<a style='position:absolute; right:0px; ; top:0px;' href='javascript:void(0)' onclick='gb()'>关闭</a></tr><tr class='bj1'><td>姓名</td><td>手机号</td><td>操作</td></tr>";
	$.ajax({
		url : "/platform/remind",
		data : {},
		type : "get",
		success : function(data) {
			if(data!="[]"){
			$.each(eval(data), function(i, d) {
				div = div + "<tr><td>" + d.name + "</td><td style='width:8%'>" + d.mobile + "</td><td><input type='button' value='处理' class='btn10' onclick='readcL("+d.code+")'></td></tr>";
			});
			div = div + "</table></div>";
			$("#showa").html(div);
			}else{
				$("#showa").html("");
			}
		}
	});
}
function readcL(code) {
	$.ajax({
		url : " /platform/cl",
		data : {
			"code" : code
		},
		type : "get",
		success : function(data) {
			showaa();
			second = 0;
			secondg = 0;
		}
	});
}
