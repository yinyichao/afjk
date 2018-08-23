<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<%--自己的css文件 --%>
<link rel="stylesheet" href="/css/cameraview.css" />
<%-- 此处不得写js --%>
<jsp:include page="/include/jsLib.jsp" />
</head>
<body>
	<form method="post" action="/secIn/insert">
		<table align="center" style="margin-top:100px">
			<tr>
				<td>数量：</td>
				<td><input type="text" class="text" name="count"></td>
			</tr>
			<tr>
				<td>code:</td>
				<td><select class="checkbox" name="code"
					onchange="selectRegion()">
						<c:forEach items="${plantCode}" var="plant">
							<option value="${plant.code}">${plant.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>区域：</td>
				<td><select name="regionId" class="checkbox" id="regionId">
				</select></td>
			</tr>
			<tr>
				<td>类型:</td>
				<td><select name="type" class="checkbox">
						<c:forEach items="${plantType}" var="plant">
							<option value="${plant.code}">${plant.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><input type="text" name="remarks" class="text"></td>
			</tr>
			<tr>
				<td>来源：</td>
				<td><input type="radio" class="radio" name="status" value="1"
					checked="checked">接入 <input type="radio" class="radio"
					name="status" value="0">未接入</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="button" value="保存"></td>
			</tr>
			</form>
		</table>
		<script>
			function selectRegion() {
				//获取事件
				var e = window.event;
				//获取元素
				obj = e.target || e.srcElement;
				$.ajax({
					url : "/region/selectByCode",
					type : "get",
					data : {
						"code" : $(obj).val()
					},
					success : function(data) {
						data = eval(data);
						var regions = $("#regionId");
						regions.empty();
						var options;
						for (var i = 0; i < data.length; i++) {
							options += "<option value=\""+data[i].id+"\">"
									+ data[i].name + "</option>";
						}
						regions.append(options);
					}
				});
			}
		</script>
</body>
</html>