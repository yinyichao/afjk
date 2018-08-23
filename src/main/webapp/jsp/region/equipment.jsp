<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<%--自己的css文件 --%>
<link rel="stylesheet" href="/css/main.css" />
<%-- 此处不得写js --%>
</head>

<body bgcolor="#ebecf3" style="overflow:hidden;">
<input type="hidden" value="${name}" id="diagramRoot">
<input type="hidden" value='${nodes}' id="diagramNodes">
	<div class="frame-div">
		<!-- [上方灰色小窄框  -->
		<div class="frame-div-d" style="float:left">
			<div style="float:left">
				<img src="/images/1.png" class="frame-img" />${prisonName}设备分布情况</div>
		</div>
		<canvas id="canvas" width="" height=""></canvas>
	</div>

	<!-- [显示监狱的div -->
	<div id="changeDiv" class="div-inform" ;onMouseOver="show()";onMouseOut="hidden()";>
		<ul>
			<c:forEach items="${plants}" var="p">
				<li class="li-prison"
					onclick="changePrison('/region/findAllEquipment?code=${p.code}')";>${p.name}</li>
			</c:forEach>
		</ul>
		<input type="hidden" id="resultVidicon" value="${resultVidicon}">
		<input type="hidden" id="warehouse" value="${warehouse}"> 
		<input type="hidden" id="access" value="${access}"> 
		<input type="hidden" id="lifeDetection" value="${lifeDetection}">
		<input type="hidden" id="shield" value="${shield}"> 
		<input type="hidden" id="grid" value="${grid}">
	</div>
	<!-- 显示监狱的div] -->
	<%-- 自己的js 文件 --%>
	<script type="text/javascript" src="/js/jtopo-0.4.8-min.js"></script>
	<script type="text/javascript" src="/js/region/equipment.js"></script>
</body>
</html>
