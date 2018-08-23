<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<%--自己的css文件 --%>
<link rel="stylesheet" href="/css/cameraview.css" />
<link rel="stylesheet" href="/css/main.css" />
<title>My JSP 'cameraview.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body>
	<div class="frame-div1">
		<div class="frame-div2">
			<div class="title-div">
				<img src="/images/1.png" class="frame-img" /><font color="#333333"><b>安防设备厂商管理</b></font>
			</div>
		</div>
		<div class="camera-div">
			<div class="fun-div" style="margin-right:38px;">
				<input type="button" value="修改" onclick="javascript:openUpdatePage();"/>
			</div>
			<div class="fun-div">
				<input type="button" value="删除"
				onclick="delFactory(${page.pageNo});"/>
			</div>
			<div class="fun-div">
				<input type="button" value="新增" onclick="javascript:openAddPage();"/>
			</div>
		</div>
		<div class="table-div" align="center" style="margin-top:20px;">
			<table width="98%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td2" style="width:4%;height:49px">序号</td>
					<td style="width:14%" class="td2">厂商名称</td>
					<td style="width:18%" class="td2">访问地址</td>
					<td style="width:14%" class="td2">用户名</td>
					<td style="width:14%" class="td2">设备类型</td>
					<td style="width:18%" class="td2">录入时间</td>
					<td style="width:14%" class="td1">所属监狱</td>										
				</tr>
					<c:forEach items="${page.results}" var="page" varStatus="vs">
					<tr>
						<td class="td3"><input type="checkbox" id="ids" name="ids"
							value="${page.id}">&nbsp;&nbsp;${vs.count}</td>
						<td class="td3">${page.name }</td>
						<td class="td3">${page.url }</td>
						<td class="td3">${page.username }</td>
						<td class="td3">${page.tName }</td>
						<td class="td3"><fmt:formatDate value="${page.in_time }" type="both" /></td>							
						<td class="td4">${page.prison }</td>					
					</tr>	
					</c:forEach>								
			</table>
			<!--分页显示 -->
			<div class="bottom-div" style="margin-top:40px;height:50px;">
				<div style="float:left;margin-top:-10px;margin-left:40px;background-color:#fff;font-size:24px;">
					共${page.totalRecord}记录,${page.totalPage}页
				</div>
				<ul style="cursor:pointer">
					<c:if test="${page.pageNo>1}">
						<li onclick="page(1)">首页</li>
						<li onclick="page(${page.pageNo}-1)">&lt;</li>
					</c:if>
					<c:if test="${page.pageNo<=1}">
						<li>&lt;</li>
					</c:if>
					<li style="background-color:#0488ff;">${page.pageNo}</li>
					<c:if test="${page.pageNo<page.totalPage}">
						<li onclick="page(${page.pageNo}+1)">&gt;</li>
						<li onclick="page(${page.totalPage})">尾页</li>
					</c:if>
					<c:if test="${page.pageNo>=page.totalPage}">
						<li>&gt;</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- -----------   新增      ------------ -->

	<div id="addback"
		style="display:none; position:absolute;width:100%; height:100%;background-color:#777;opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50);"></div>
	<div id="addwin"
		style="display:none; position:absolute;left:50%; top:50%; width:450px; height:450px; margin-left:-200px; margin-top:-200px; background-color:#fff; text-align:center">
		<div style="margin-top:20px;">请输入信息</div>
		<form action="/factory/insertFactory" method="post">
			<table align="center">
				<tr>
					<td align="right" width="80px">厂商名称：</td>
					<td align="left" width="240px"><input type="text" name="name"
						class="text" /></td>
				</tr>
				<tr>
					<td align="right">访问地址：</td>
					<td align="left"><input type="text" name="url" class="text" /></td>
				</tr>
				<tr>
					<td align="right">端口：</td>
					<td align="left"><input type="text" name="port" class="text" /></td>
				</tr>
				<tr>
				    <td align="right">用户名：</td>
					<td align="left"><input type="text" name="username"  class="text" /></td>
				</tr>
				<tr>
				    <td align="right">密码：</td>
					<td align="left"><input type="text" name="password"  class="text" /></td>
				</tr>
				<tr>
					<td align="right">所属监狱：</td>
					<td align="left"><select name="prison" class="checkbox">
							<c:forEach items="${prison}" var="pri">
								<option value="${pri.code}">${pri.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">设备类型：</td>
					<td align="left"><select name="type" class="checkbox">							
							<c:forEach items="${type}" var="t">
								<option value="${t.code}">${t.name}</option>
							</c:forEach>
					</select></td>
				<tr>
					<td></td>
					<td><input type="button" value="关闭"
						onclick="javascript:closeAddPage();" class="button" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="提交" class="button" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!-------------   修改      -------------->

	<div id="updateback"
		style="display:none; position:absolute;width:100%; height:100%;background-color:#777;opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50);"></div>
	<div id="updatewin"
		style="display:none; position:absolute;left:50%; top:50%; width:450px; height:450px; margin-left:-200px; margin-top:-200px; background-color:#fff; text-align:center">
		<div style="margin-top:20px;">请输入信息</div>
		<form action="/factory/updateFactory" method="post">
			<table align="center">
				<tr>
					<td align="right">厂商名称：</td>
					<td align="left"><input type="text" id="name" class="text"
						name="name" value="" /></td>
				</tr>
				<tr>
					<td align="right">访问地址：</td>
					<td align="left"><input type="text" id="url" class="text"
						name="url" value="" /></td>
				</tr>
				<tr>
					<td align="right">端口：</td>
					<td align="left"><input type="text" name="port" class="text" /></td>
				</tr>
				<tr>
					<td align="right">用户名：</td>
					<td align="left">
						<input type="text" id="username" class="text" name="username" value="">
					</td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td align="left"><input type="password" id="password" class="text"
						name="password" value="" /></td>
				</tr>
				<tr>
					<td align="right">设备类型：</td>
					<td align="left"><select name="type" id="tName"
						class="checkbox">
							<c:forEach items="${type}" var="t">
								<option value="${t.code}" selected="selected">${t.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">所属监狱：</td>
					<td align="left"><select name="prison" id="prison"
						class="checkbox">
							<c:forEach items="${prison}" var="pri">
								<option value="${pri.code}" selected="selected">${pri.name}</option>
							</c:forEach>
					</select></td>
				
				<input type="hidden" id="id" name="id" value="" />
				<input type="hidden" name="pageNo" value="${page.pageNo}" />
				<tr>
					<td></td>
					<td><input type="button" value="关闭"
						onclick="javascript:closeUpdatePage();" class="button" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="提交" class="button" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<jsp:include page="/include/jsLib.jsp"/>
<script type="text/javascript"></script>
<script src="/js/factory/plantFactory.js"></script>
</html>
