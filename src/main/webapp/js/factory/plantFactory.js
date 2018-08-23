//分页
function page(pageNo){
	location.href = "/factory/toPlantFactory?pageNo=" + pageNo;
}
//新增
function openAddPage() {
	document.getElementById("addwin").style.display = "";
	document.getElementById("addback").style.display = "";
}
function closeAddPage() {
	document.getElementById("addwin").style.display = "none";
	document.getElementById("addback").style.display = "none";
}
//修改
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
			url : "/factory/updateFactoryView",
			data : {
				"id" : id
			},
			success : function(factory) {
				factory = eval('(' + factory + ')');
				$("#id").val(factory.id);
				$("#name").val(factory.name);
				$("#url").val(factory.url);
				$("#username").val(factory.username);
				$("#password").val(factory.password);
				$("#prison").val(factory.prison);
				$("#tName").val(factory.type);
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
function delFactory(pageNo) {
	var checkboxs = $("input[name='ids']:checked");
	var ids = "";
	checkboxs.each(function() {
		ids += $(this).val() + ",";
	});
	ids = ids.substring(0, ids.length - 1);
	if (checkboxs.length >= 1) {
		if (confirm("确定要删除吗？") == true) {
			location.href = "/factory/delFactory?ids=" + ids + "&pageNo=" + pageNo;
		} else {
			return;
		}
	} else {
		alert('至少选择一条');
	}
}