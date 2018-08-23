<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<%--自己的css文件 --%>

<%-- 此处不得写js --%>

</head>
<body>
	<div class="top-div">
		<img src="/images/logo.png" width="304" height="54" class="top-img" />
		<ul class="topnav-zi">
			<li onclick="changeTab('/platform/main')"><span class="click">设备概括<img src="/images/title_press.png" style="margin-top: 20px;" id="bgimg"></span></li>
			<li onclick="changeTab('/secIn/prisonInform?code=${sessionScope.prison_code}')"><span>设备管理</span></li>
			<li onclick="changeTab('/factory/toPlantFactory')"><span>厂商管理</span></span></li>
			<!-- <li onclick="changeTab('/secIn/insertPage')"><span>服务管理</span></li> -->
			<li onclick="changeTab('/secService/homepage')"><span>服务管理</span></li>
			<li onclick="changeTab('/factory/toPlantFactoryInfo')"><span>标准规范</span></li>
		</ul>
	</div>
	<jsp:include page="/include/jsLib.jsp" />
	<%-- 自己的js 文件 --%>
	<script src="/js/frame/top.js"></script>
</body>
</html>