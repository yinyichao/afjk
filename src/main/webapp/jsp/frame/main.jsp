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

<body bgcolor="#ebecf3">
<%-- body 正文部分 --%>
	<div class="frame-div">
		<div class="frame-div-d">
			<img src="/images/1.png" class="frame-img"/><div>各监狱设备接入情况统计图</div>
		</div>
		<div id="main" style="width: 100%;height:400px;"></div>
		<div>
		<div class="frame-div-ud">
			<img src="/images/1.png" class="frame-img"/><div>各监狱设备接入情况详细数据</div>
		</div>
		<input type="hidden" value="${sec1}" id="sec1">
		<input type="hidden" value="${sec2}" id="sec2">
		<input type="hidden" value="${sec3}" id="sec3">
		<input type="hidden" value="${sec4}" id="sec4">
		<input type="hidden" value="${sec5}" id="sec5">
		<input type="hidden" value="${sec6}" id="sec6">
		<input type="hidden" value="${sec7}" id="sec7">
		<table class="frame-table">
				<thead style="background-color: #fafafa">
			    <tr>
			    	<th width="106px;"></th>
			        <th onclick="showEquipmentItem('01')">哈尔滨</th>
					<th onclick="showEquipmentItem('02')">北安</th>
					<th onclick="showEquipmentItem('03')">牡丹江</th>
					<th onclick="showEquipmentItem('04')">呼兰</th>
					<th onclick="showEquipmentItem('05')">泰来</th>
					<th onclick="showEquipmentItem('06')">六三</th>
					<th onclick="showEquipmentItem('07')">讷河</th>
					<th onclick="showEquipmentItem('08')">凤凰山</th>
					<th onclick="showEquipmentItem('09')">华山</th>
					<th onclick="showEquipmentItem('10')">五大连池</th>
					<th onclick="showEquipmentItem('11')">香兰</th>
					<th onclick="showEquipmentItem('12')">新康</th>
					<th onclick="showEquipmentItem('13')">佳木斯</th>
					<th onclick="showEquipmentItem('14')">双鸭山</th>
					<th onclick="showEquipmentItem('15')">松滨</th>
					<th onclick="showEquipmentItem('16')">未犯所</th>
					<th onclick="showEquipmentItem('17')">新建</th>
					<th onclick="showEquipmentItem('18')">鸡西</th>
					<th onclick="showEquipmentItem('19')">七台河</th>
					<th onclick="showEquipmentItem('20')">女子监狱</th>
					<th onclick="showEquipmentItem('21')">齐齐哈尔</th>
			    </tr>
			    </thead>
			    <tbody style="font-size: 14px;">
				<tr>
				<td>摄像头</td>
				<c:forEach var="sec" items="${fn:substring(sec1,1,fn:length(sec1)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				<tr>
				<td>仓讲</td>
				<c:forEach var="sec" items="${fn:substring(sec2,1,fn:length(sec2)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				<tr>
				<td>门禁</td>
				<c:forEach var="sec" items="${fn:substring(sec3,1,fn:length(sec3)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				<tr>
				<td>电网</td>
				<c:forEach var="sec" items="${fn:substring(sec4,1,fn:length(sec4)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				<tr>
				<td>会见</td>
				<c:forEach var="sec" items="${fn:substring(sec5,1,fn:length(sec5)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				<tr>
				<td>生命探测</td>
				<c:forEach var="sec" items="${fn:substring(sec6,1,fn:length(sec6)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				<tr>
				<td>手机屏蔽</td>
				<c:forEach var="sec" items="${fn:substring(sec7,1,fn:length(sec7)-1)}">
			    	<td>${sec}</td>
			    </c:forEach>
				</tr>
				</tbody>
			</table>
			</div>
	</div>
	<jsp:include page="/include/jsLib.jsp" />
<%-- 自己的js 文件 --%>
<script src="/js/echarts.js"></script>
<script src="/js/frame/main.js"></script>
</body>
</html>