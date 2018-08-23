<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<%--自己的css文件 --%>
<link rel="stylesheet" href="/css/cameraview.css" />
<link rel="stylesheet" href="/css/main.css"/>
<title>My JSP 'cameraview.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
</head>

<body>
	<div class="frame-div1">
		<div class="frame-div2">
			<div class="title-div">
				<img src="/images/1.png" class="frame-img" /><font color="#333333"><b>安防设备服务</b></font>
			</div>
		</div>
		<div class="table-div" align="center" style="margin-top:30px;margin-bottom:30px;">
			<table width="98%" align="center" cellpadding="0" cellspacing="0">
				<tr style="cursor:default;">
					<td class="td2" style="width:14%;height:49px;">监狱名称</td>
					<td style="width:12%" class="td2">视频接口</td>
					<td style="width:12%" class="td2">仓讲接口</td>
					<td style="width:12%" class="td2">门禁接口</td>
					<td style="width:12%" class="td2">电网接口</td>
					<td style="width:12%" class="td2">会见接口</td>
					<td style="width:12%" class="td2">生命探测接口</td>
					<td style="width:12%" class="td1">手机屏蔽接口</td>
				</tr>
				<c:forEach items="${secList}" var="sec">
					<tr style="cursor:pointer;">
						<td class="td3" style="cursor:default;">
							${sec.name}
						</td>
						<td class="td3" onclick="secInfor('${sec.code}','01')">
							${sec.video}
						</td>
						<td class="td3" onclick="secInfor('${sec.code}','02')">
							${sec.ware}
						</td>
						<td class="td3" onclick="secInfor('${sec.code}','03')">
							${sec.door}
						</td>
						<td class="td3" onclick="secInfor('${sec.code}','04')">
							${sec.grid}
						</td>
						<td class="td3" onclick="secInfor('${sec.code}','05')">
							${sec.meeting}
						</td>
						<td class="td3" onclick="secInfor('${sec.code}','06')">
							${sec.living}
						</td>
						<td class="td4" onclick="secInfor(${sec.code},'07')">
							${sec.shield}
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
  </body>
<script src="/js/service/service.js"></script>
</html>
