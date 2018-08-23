//新增
function openAddPage() {
	document.getElementById("addwin").style.display = "";
	document.getElementById("addback").style.display = "";
}
function closeAddPage() {
	document.getElementById("addwin").style.display = "none";
	document.getElementById("addback").style.display = "none";
}
//拨打
function openCallPage(){
	document.getElementById("call").style.display = "";
	document.getElementById("callBack").style.display = "";
}
function closeCallPage(){
	document.getElementById("call").style.display = "none";
	document.getElementById("callBack").style.display = "none";
}
var dial = "false";
//拨通
function call(){
	var from = document.getElementById("from").value;
	var to = document.getElementById("to").value;
	if(to==""||to==null||from==""||from==null){
		alert("请输入号码");
	}else{
		$.ajax({
			type : "get",
			url :"/plantTel/callMDBE",
			data : {
				"from" :from,
				"to" :to
  			},
			success : function() {
				dial="true";
			}
		});
		/*location.href="/plantTel/callMDBE?from="+from+"&to="+to;
		dial="true";*/
	}
}
//挂断
function hangUp(){
	var from = document.getElementById("from").value;
	if(dial=="false"){
		alert("请先拨通电话");
	}else{
		$.ajax({
			type : "get",
			url :"/plantTel/callMDBE",
			data : {
				"from" :from,
  			},
			success : function() {
				alert("以挂断");
			}
		});
		/*location.href="/plantTel/callMDBE?from="+from;*/
	}
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
			url : "/plantTel/updateTelPage",
			data : {
				"id" : id
			},
			success : function(tel) {
				tel = eval('(' + tel + ')');
				$("#name").val(tel.name);
				$("#code").val(tel.code);
				$("#id").val(tel.id);
				$("#pid").val(tel.pid);
				$("#factory").val(tel.fid)
				$("#region").val(tel.regionId)
				if (tel.status == 0) {
					$("#goodstatus").attr("checked", "checked");
				}
				if (tel.status == 1) {
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
function delTel(code, pageNo) {
	var checkboxs = $("input[name='ids']:checked");
	var ids = "";
	checkboxs.each(function() {
		ids += $(this).val() + ",";
	});
	ids = ids.substring(0, ids.length - 1);
	if (checkboxs.length > 0) {
		if (confirm("确定要删除吗？") == true) {
			location.href = "/plantTel/delTel?ids=" + ids + "&code="
					+ code + "&pageNo=" + pageNo;
		} else {
			return;
		}
	} else {
		alert('至少选择一条');
	}
}

// 符合查询加分页
function page(pageNo, code) {
	var key = document.getElementById("keys").value;
	if (key == '请输入关键字' || key == null) {
		location.href = "/plantTel/telview?pageNo=" + pageNo + "&code=" + code;
	} else {
		var keys = encodeURI(encodeURI(key));
		location.href = "/plantTel/telview?pageNo=" + pageNo + "&code="
			+ code + "&key=" + keys;
	}
}
function querykeys(code) {
	var key = document.getElementById("keys").value;
	if (key == '请输入关键字' || key == null) {
		location.href = "/plantTel/telview?code=" + code;
	} else {
		var keys = encodeURI(encodeURI(key));
		location.href = "/plantTel/telview?key=" + keys + "&code="
				+ code;
	}
}
