<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<jsp:include page="/include/jsLib.jsp" />
<%--自己的css文件 --%>
<link rel="stylesheet" href="/css/cameraview.css" />
<link rel="stylesheet" href="/css/main.css" />
<title>My JSP 'cameraview.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
  	 <div class="frame-div1">
		<div class="frame-div2">
			<div class="title-div">
				<img src="/images/1.png" class="frame-img" /><font color="#333333"><b>安防设备厂商管理-${plantDict.name}</b></font>
			</div>
		</div>
	</div>
	<div style="width:100%;height:40px;padding:0px;margin:0px;"></div>
	<!-- 左侧显示厂商列表  -->
	<div class="sec-left" align="center">
		<ul class="nav">
			<c:forEach items="${sList}" var="s">
				<li onclick="changeFactoryInfor('${s.id}')" value="${s.id}"} name="li">${s.name}</li>
			</c:forEach>
			<li onclick="uppage('/factory/toPlantFactoryInfo')" name="li">返回</li>
		</ul>
	</div>
	<!-- 右侧显示厂商描述  -->
	<div class="sec_right">
		<div class="right_title">接入要求</div>
    	<div class="right_text" id="sec_intro">
    		各厂商接入要求说明
		</div>
    </div>
</body>
<script src="/js/service/service.js"></script>
</html>

