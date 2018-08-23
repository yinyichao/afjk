function changeTab(url){
	parent.main.location.href=url;
	$("#bgimg").remove();
	$(".click").removeClass("click");
	//获取事件
	var e = window.event;
	//获取元素
	obj = e.target || e.srcElement;
	$(obj).addClass("click");
	$(obj).append("<img src='/images/title_press.png' style='margin-top: 20px;' id='bgimg'>");
}
