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
				<img src="/images/1.png" class="frame-img" /><font color="#333333"><b>${prisonName}监狱-仓讲</b></font>
			</div>
			<div class="check-img">
				<input type="button" value="" onclick="querykeys('${code}');" />
			</div>
			<div class="check-div">
				<c:if test="${empty key}">
				<input name="search" id="keys" value="请输入关键字"
					style="width:260px;height:26px;" type="text"
					onfocus="if(this.value=='请输入关键字'){this.value='';}"
					onblur="if(this.value==''){this.value='请输入关键字';}"/>
			</c:if>
			<c:if test="${!empty key}">
				<input name="search" id="keys" value="${key}"
					style="width:260px;height:26px;" type="text"/>
			</c:if>
			</div>
		</div>
		<div class="camera-div">
			<div class="camera-text">
				仓讲概览:共<font color="#0488ff">${page.totalRecord}</font>部,在线<font
					color="#0488ff">${goodCount}</font>部,离线<font color="#0488ff">${page.totalRecord-goodCount}</font>部
			</div>
			<div class="fun-div" style="margin-right:38px;">
				<input type="button" value="修改"
					onclick="javascript:openUpdatePage();" />
			</div>
			<div class="fun-div">
				<input type="button" value="删除"
					onclick="delTel('${code}',${page.pageNo});" />
			</div>
			<div class="fun-div">
				<input type="button" value="新增" onclick="javascript:openAddPage();" />
			</div>
		</div>
		<div class="table-div" align="center">
			<table width="98%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td2" style="width:4%;height:49px">序号</td>
					<td style="width:10%" class="td2">名称</td>
					<td style="width:10%" class="td2">组织</td>
					<td style="width:5%" class="td2">厂家</td>
					<td style="width:10%" class="td2">编号</td>
					<td style="width:13%" class="td2">更新维护时间</td>
					<td style="width:8%" class="td2">负责民警</td>
					<td style="width:10%" class="td2">状态</td>
					<td style="width:5%" class="td2">报警记录</td>
					<td style="width:5%" class="td2">操作</td>
					<!-- <td style="width:18%" class="td1">操作</td> -->
				</tr>
				<c:forEach items="${page.results}" var="page" varStatus="vs">
					<tr>
						<td class="td3"><input type="checkbox" id="ids" name="ids"
							value="${page.id}">&nbsp;&nbsp;${vs.count}</td>
						<td class="td3">${page.name}</td>
						<td class="td3">${page.pname}</td>
						<td class="td3">${page.fname}</td>
						<td class="td3">${page.code}</td>
						<td class="td3"><fmt:formatDate value="${page.inTime}"
								type="both" /></td>
						<td class="td3">${page.jname}</td>
							<c:if test="${page.status == 0}">
								<td class="td3">在线</td>
							</c:if>
							<c:if test="${page.status == 1}">
								<td class="td3">离线</td>
							</c:if>
						<td class="td4">${page.count}</td>
						<td class="td4">
							<span onclick="openCallPage();" style="cursor:pointer ; color:#0066FF">拨打</span>
						</td> 
					</tr>
				</c:forEach>
			</table>
			<div class="bottom-div" style="margin-top:40px;height:50px;">
				<div style="float:left;margin-top:-10px;margin-left:40px;background-color:#fff;font-size:24px;">
					共${page.totalRecord}记录,${page.totalPage}页
				</div>
				<div style="float:right;">
					<ul style="cursor:pointer">
						<c:if test="${page.pageNo>1}">
							<li onclick="page(1,'${code}')">首页</li>
							<li onclick="page(${page.pageNo}-1,'${code}')">&lt;</li>
						</c:if>
						<c:if test="${page.pageNo<=1}">
							<li>&lt;</li>
						</c:if>
						<li style="background-color:#0488ff;">${page.pageNo}</li>
						<c:if test="${page.pageNo<page.totalPage}">
							<li onclick="page(${page.pageNo}+1,'${code}')">&gt;</li>
							<li onclick="page(${page.totalPage},'${code}')">尾页</li>
						</c:if>
						<c:if test="${page.pageNo>=page.totalPage}">
							<li>&gt;</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- ----------   拨打电话      ---------- -->
	<div id="callBack"
		style="display:none; position:absolute;width:100%; height:100%;background-color:#777;opacity:0.5;-moz-opacity:0.5; filter:alpha(opacity=50);"></div>
	<div id="call" 
		style="display:none;position:absolute;left:50%; top:50%; width:300px; height:200px; margin-left:-150px; margin-top:-150px; background-color:#fff; text-align:center">
		<div style="margin-top: 20px">
			<table align="center">
			<tr><td><input type="text" id="from" value="" class="textCall"/></td>
				<td><input type="text" id="to" value="" class="textCall"/></td></tr>
			<tr><td align="left" width="100px"><input type="button" value="拨打" class="button" onclick="call()"/></td>
				<td align="right" width="100px"><input type="button" value="挂断" class="button" onclick="hangUp()"/></td></tr>
			<tr><td colspan="2"><input type="button" value="关闭"
						onclick="closeCallPage();" class="button"/></td></tr>
		</table>
		</div>
		
		
		
	</div>
	
	<!-- -----------   新增      ------------ -->
	
	<div id="addback"
		style="display:none; position:absolute;width:100%; height:100%;background-color:#777;opacity:0.5;-moz-opacity:0.5; filter:alpha(opacity=50);"></div>
	<div id="addwin"
		style="display:none; position:absolute;left:50%; top:50%; width:450px; height:400px; margin-left:-200px; margin-top:-200px; background-color:#fff; text-align:center">
		<div style="margin-top:20px;">请输入信息</div>
		<form action="/plantTel/insertTel" method="post">
			<table align="center">
				<tr>
					<td align="right" width="80px">名称：</td>
					<td align="left" width="240px">
						<input type="text" name="name" id="addname" class="text" onblur="checkname()";/>
						<span id="checkname" name="checkname" value="no"></span>
					</td>
				</tr>
				<tr>
					<td align="right">编号：</td>
					<td align="left">
						<input type="text" name="code" id="addcode" class="text" onblur="checkcode()";/>
						<span id="checkcode" name="checkcode" value="no"></span>
					</td>
				</tr>
				<td align="right">状态：</td>
				<td align="left">
					<input type="radio" name="status" value="0" class="radio" checked="checked"/>在线 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="status" value="1" class="radio" />不在线</td>
				<tr>
					<td align="right">组织：</td>
					<td align="left"><select name="regionId" class="checkbox">
							<option value="--请选择--">--请选择--</option>
							<c:forEach items="${organizationname}" var="org">
								<option value="${org.id}">${org.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">厂家：</td>
					<td align="left"><select name="fid" class="checkbox">
							<option value="--请选择--">--请选择--</option>
							<c:forEach items="${factoryname}" var="fac">
								<option value="${fac.id}">${fac.name}</option>
							</c:forEach>
					</select></td>
				<tr>
					<td align="right">负责人：</td>
					<td align="left"><input type="text" name="pid" value="1"
						class="text" /></td>
				</tr>
				<input type="hidden" name="pcode" value="${code}" />
				<tr>
					<td></td>
					<td><input type="button" value="关闭"
						onclick="javascript:closeAddPage();" class="button" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="提交" class="button" onfocus="addEqu();"/></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- -----------   修改      ------------ -->

	<div id="updateback"
		style="display:none; position:absolute;width:100%; height:100%;background-color:#777;opacity:0.5;-moz-opacity:0.5; filter:alpha(opacity=50);"></div>
	<div id="updatewin"
		style="display:none; position:absolute;left:50%; top:50%; width:450px; height:400px; margin-left:-200px; margin-top:-200px; background-color:#fff; text-align:center">
		<div style="margin-top:20px;">请输入信息</div>
		<form action="/plantTel/updateTel" method="post">
			<table align="center">
				<tr>
					<td align="right">名称：</td>
					<td align="left">
						<input type="text" id="name" class="text" name="name" value="" onblur="upname()";/>
						<span id="upname" name="upname" value="no"></span>
					</td>
				</tr>
				<tr>
					<td align="right">编号：</td>
					<td align="left">
						<input type="text" id="code" class="text" name="code" value="" onblur="upcode()";/>
						<span id="upcode" name="upcode" value="no"></span>
					</td>
				</tr>
				<tr>
					<td align="right">状态：</td>
					<td align="left">
						<input type="radio" id="goodstatus" name="status" value="0" class="radio">在线 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="badstatus" name="status" value="1" class="radio">不在线
					</td>
				</tr>
				<tr>
					<td align="right">组织：</td>
					<td align="left"><select name="regionId" id="region"
						class="checkbox">
							<c:forEach items="${organizationname}" var="org">
								<option value="${org.id}" selected="selected">${org.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">厂家：</td>
					<td align="left"><select name="fid" id="factory"
						class="checkbox">
							<c:forEach items="${factoryname}" var="fac">
								<option value="${fac.id}" selected="selected">${fac.name}</option>
							</c:forEach>
					</select></td>
				<tr>
					<td align="right">负责人：</td>
					<td align="left"><input type="text" id="pid" class="text"
						name="pid" value="" /></td>
				</tr>
				<input type="hidden" id="id" name="id" value="" />
				<input type="hidden" name="pcode" value="${code}" />
				<input type="hidden" name="pageNo" value="${page.pageNo}"/>
				<tr>
					<td></td>
					<td><input type="button" value="关闭"
						onclick="javascript:closeUpdatePage();" class="button" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="提交" class="button" onfocus="addEqu()";/></td>
				</tr>
			</table>
		</form>
	</div>

</body>
<script src="/js/running/operation.js"></script>
<jsp:include page="/include/jsLib.jsp" />
<script src="/js/running/tel/telview.js"></script>
</html>
