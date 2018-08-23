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


</head>

<body>
	<div class="frame-div1">
		<div class="frame-div2">
			<div class="title-div">
				<img src="/images/1.png" class="frame-img" /><font color="#333333"><b>安防设备服务状态-${prisonName}-${plantDict.name}</b></font>
			</div>
		</div>
	</div>
	<div class="sec-left" align="center">
		<ul class="nav">
			<c:forEach items="${ssList}" var="ss">
				<li onclick="changeSecInfor('${ss.id}')" value="${ss.id}"} name="li">${ss.name}</li>
			</c:forEach>
			<li onclick="uppage('/secService/homepage')" name="li">返回</li>
		</ul>
	</div>
	<div class="sec_right">
		<div class="right_title" id="jianjie">简介</div>
    	<div class="right_text" id="sec_intro">
    		此接口目的是制定在黑龙江省21所监狱视频厂商需要提供接口功能。
		</div>
    	<div class="right_title">功能介绍</div>
    	<div class="right_text" id="sec_function">
    		客户端向服务发送请求，服务返回数据。
		</div>
    	<div class="right_title">使用说明</div>
    	<div class="right_text" id="sec_instruction">
	    	同步：调用一个服务接口即可得到结果。
			<p>异步：异步方式调用可细分为两种实现方式，如下：</p>
			<p>a. 客户端先调用服务的一个接口，若干时间后再调用服务的另一个接口获取前一个接口调用的结果数据；</p>
			<p>b. 客户端先调用服务的一个接口，服务执行完处理后，调用客户端提供的一个接口把结果数据发给客户端。</p>
		</div>
    	<div class="right_title">示例代码</div>
    	<div class="right_text" id="sec_sample">
	    	using System;
	    	<p>using System.Collections.Generic;</p>
	    	<p>using System.Text;using System.Collections;</p>
	    	<p>using System.Net;</p>
	    	<p>using System.IO;</p>
	    	<p>using System.Threading;</p>
	    	<p>using System.Diagnostics;</p>
	    	<p>namespace eLive.Common{ }</p>
    	</div>
    </div>
</body>
<jsp:include page="/include/jsLib.jsp" />
<script src="/js/service/service.js"></script>
</html>
