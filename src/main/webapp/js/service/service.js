/*ajax 刷新设备信息*/
function changeSecInfor(id){
		var d = document.getElementsByName('li');
		for(var p=0;p<d.length;p++){
			if(d[p].value == id){
				d[p].style.backgroundColor="#ebecf3";
			}else{
				d[p].style.backgroundColor="#fff";
			}
		}
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/secService/changeSec",
			data : {"id" : id},
			success : function(secService) {
				sec = eval('(' + secService + ')');
				$("#sec_intro").hide();
				$("#jianjie").hide();
				$("#sec_function").html(sec.info);
				$("#sec_instruction").html(sec.introduction);
				$("#sec_sample").html(sec.demo);
				}
		});
	}
/*返回*/
function uppage(url){
		location.href=url;
	}
/*跳转设备信息页面*/
function secInfor(code,type){
	location.href = "/secService/secInfor?code="+code+"&type="+type;
}

/*ajax 局部刷新 厂商信息*/
function changeFactoryInfor(id){
	var d = document.getElementsByName('li');
	for(var p=0;p<d.length;p++){
		if(d[p].value == id){
			d[p].style.backgroundColor="#ebecf3";
		}else{
			d[p].style.backgroundColor="#fff";
		}
	}
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/standard/plantFactoryDescription",
		data : {"id":id},
		success : function(secStandard) {
			sec = eval('(' + secStandard + ')');
			$("#sec_intro").html(sec.description);
			}
	});
}

/*厂商描述信息*/
function plantFactoryDescription(url){
		location.href=url
}