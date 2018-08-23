	function checkname(){
		var name = $("#addname").val();
		if(name == ''){
			$("#checkname").html("<font color='red'>名称不能为空</font>");
		}else{
			$("#checkname").html("<font>名称符合规范</font>");
			$("#checkname").val("yes");
		}
	}
	function checkcode(){
		var code = $("#addcode").val();
		if(code.length != 19 || code == ''){
			$("#checkcode").html("<font color='red'>编码必须为19位</font>");
		}else{
			$("#checkcode").html("<font>编码正确</font>");
			$("#checkcode").val("yes");
		}
	}
	function addEqu(){
		if($("#checkcode").val() != "yes" || $("#checkname").val() != "yes"){
			alert("不符合规范,请重新填写！");
		}
	}
	
	
	function upname(){
		var name = $("#name").val();
		if(name == ''){
			$("#upname").html("<font color='red'>名称不能为空</font>");
		}else{
			$("#upname").html("<font>名称符合规范</font>");
			$("#upname").val("yes");
		}
	}
	function upcode(){
		var code = $("#code").val();
		if(code.length != 19 || code == ''){
			$("#upcode").html("<font color='red'>编码必须为19位</font>");
		}else{
			$("#upcode").html("<font>编码正确</font>");
			$("#upcode").val("yes");
		}
	}
	function upEqu(){
		if($("#upcode").val() != "yes" || $("#upkname").val() != "yes"){
			alert("不符合规范,请重新填写！");
		}
	}