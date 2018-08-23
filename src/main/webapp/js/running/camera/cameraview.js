//新增
function openAddPage() {
	document.getElementById("addwin").style.display = "";
	document.getElementById("addback").style.display = "";
}
function closeAddPage() {
	document.getElementById("addwin").style.display = "none";
	document.getElementById("addback").style.display = "none";
}
// 修改
function openUpdatePage() {
	var checkboxs = $("input[name='ids']:checked");
	var ids = "";
	checkboxs.each(function() {
		ids += $(this).val() + ",";
	});
	var id = ids.substring(0, ids.length - 1);
	if (checkboxs.length > 1) {
		alert('只能选择一条');
		return;
	} else if (checkboxs.length < 1) {
		alert('选择一条要修改的记录');
		return;
	} else {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/plantPerimeter/updateCameraPage",
			data : {
				"id" : id
			},
			success : function(camera) {
				camera = eval('(' + camera + ')');
				$("#name").val(camera.name);
				$("#code").val(camera.code);
				$("#id").val(camera.id);
				$("#pid").val(camera.pid);
				$("#factory").val(camera.fid)
				$("#region").val(camera.regionId)
				if (camera.status == 0) {
					$("#goodstatus").attr("checked", "checked");
				}
				if (camera.status == 1) {
					$("#badstatus").attr("checked", "checked");
				}
			}
		});
		document.getElementById("updatewin").style.display = "";
		document.getElementById("updateback").style.display = "";
	}
}
function closeUpdatePage() {
	document.getElementById("updatewin").style.display = "none";
	document.getElementById("updateback").style.display = "none";
}

// 删除
function delCamera(code, pageNo) {
	var checkboxs = $("input[name='ids']:checked");
	var ids = "";
	checkboxs.each(function() {
		ids += $(this).val() + ",";
	});
	ids = ids.substring(0, ids.length - 1);
	if (checkboxs.length > 0) {
		if (confirm("确定要删除吗？") == true) {
			location.href = "/plantPerimeter/delCamera?ids=" + ids + "&code="
					+ code + "&pageNo=" + pageNo;
		} else {
			return;
		}
	} else {
		alert('至少选择一条');
	}
}

// 符合查询加分页
function page(pageNo,code) {
	var key = document.getElementById("keys").value;
	if (key == '请输入关键字' || key == null) {
		location.href = "/plantPerimeter/cameraview?pageNo=" + pageNo + "&code=" + code;
	} else {
		var keys = encodeURI(encodeURI(key));
		location.href = "/plantPerimeter/cameraview?pageNo=" + pageNo + "&code="
		+ code + "&key=" + keys;
	}
	
}
function querykeys(code) {
	var key = document.getElementById("keys").value;
	if (key == '请输入关键字' || key == null) {
		location.href = "/plantPerimeter/cameraview?code=" + code;
	} else {
		var keys = encodeURI(encodeURI(key));
		location.href = "/plantPerimeter/cameraview?key=" + keys + "&code="
				+ code;
	}
}

// 显示海康视频预览页
function showStartPreviewHK(prison,code,height,width) {
	var url = '/plantPerimeter/startPreview?code='+code+'&prison='+prison+'&height='+height+'&width='+width;
	var iWidth = 600;
	var iHeight = 500;
	// 获得窗口的垂直位置
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	// 获得窗口的水平位置
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window
			.open(
					url,'new'+code,'height=' + iHeight + ',innerHeight=' + iHeight + 
					',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + 
					 ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
	return false;
}


// 显示海康视频回放页
function showPlayBackHK(prison,code){
	var url = '/plantPerimeter/playBack?code='+code+"&prison="+prison;
	var iWidth = 600;
	var iHeight = 500;
	// 获得窗口的垂直位置
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	// 获得窗口的水平位置
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window
			.open(
					url,
					'new',
					'height='
							+ iHeight
							+ ',innerHeight='
							+ iHeight
							+ ',width='
							+ iWidth
							+ ',innerWidth='
							+ iWidth
							+ ',top='
							+ iTop
							+ ',left='
							+ iLeft
							+ ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
	return false;
}
//显示大华视频预览页
function showStartPreviewDH(code) {
	var url = '/plantPerimeter/startPreviewDH?code='+code;
	var iWidth = 620;
	var iHeight = 520;
	// 获得窗口的垂直位置
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	// 获得窗口的水平位置
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window
			.open(
					url,'new','height=' + iHeight + ',innerHeight=' + iHeight + 
					',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + 
					',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
	return false;
}
//显示大华视频回放页
function showPlayBackDH(code){
	var url = '/plantPerimeter/playBackDH?code='+code;
	var iWidth = 620;
	var iHeight = 520;
	// 获得窗口的垂直位置
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	// 获得窗口的水平位置
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window
			.open(
					url,'new','height=' + iHeight + ',innerHeight=' + iHeight + 
					',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + 
					',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
	return false;
}
