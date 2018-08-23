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
	<form method="post" action="/region/insert">
		<table align="center" style="margin-top:100px">
			<tr>
				<td>名称：</td>
				<td><input type="text" class="text" name="name"></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><input type="text" class="text" name="remarks"></td>
			</tr>
			<tr>
				<td>父级：</td>
				<td><input type="text" class="text" name="parentId"></td>
			</tr>
			<tr>
				<td>code:</td>
				<td><select name="code" class="checkbox">
						<c:forEach items="${plants}" var="plant">
							<option value="${plant.code}">${plant.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>级别：</td>
				<td><input type="text" class="text" name="regionLevel"></td>
			</tr>
			<tr>
				<td>来源：</td>
				<td><input type="radio" class="radio" name="source" value="1">厂家导入
					<input type="radio" class="radio" name="source" value="0">安防联动</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="button" value="保存"></td>
			</tr>
		</table>
	</form>

</body>
</html>