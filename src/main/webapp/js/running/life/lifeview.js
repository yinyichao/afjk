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
			url : "/plantLife/updateLifePage",
			data : {
				"id" : id
			},
			success : function(life) {
				life = eval('(' + life + ')');
				$("#name").val(life.name);
				$("#code").val(life.code);
				$("#id").val(life.id);
				$("#pid").val(life.pid);
				$("#factory").val(life.fid)
				$("#region").val(life.regionId)
				if (life.status == 0) {
					$("#goodstatus").attr("checked", "checked");
				}
				if (life.status == 1) {
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
function delLife(code, pageNo) {
	var checkboxs = $("input[name='ids']:checked");
	var ids = "";
	checkboxs.each(function() {
		ids += $(this).val() + ",";
	});
	ids = ids.substring(0, ids.length - 1);
	if (checkboxs.length > 0) {
		if (confirm("确定要删除吗？") == true) {
			location.href = "/plantLife/delLife?ids=" + ids + "&code="
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
	location.href = "/plantLife/lifeview?pageNo=" + pageNo + "&code="
			+ code;
}
function querykeys(code) {
	var key = document.getElementById("keys").value;
	if (key == '请输入关键字' || key == null) {
		location.href = "/plantLife/lifeview?code=" + code;
	} else {
		var keys = encodeURI(encodeURI(key));
		location.href = "/plantLife/lifeview?key=" + keys + "&code="
				+ code;
	}
}
