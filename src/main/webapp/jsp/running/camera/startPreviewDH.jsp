<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/include/tagLib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<html>
  <head>
     <base href="<%=basePath%>">
    <link rel="stylesheet" href="/css/main.css" />     
    <title>My JSP 'startPreviewDH.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>			
	    <div style="width: 90%;height: 30px;overflow: auto;" id="RetInfo">			
		</div>
		
		<div style="width: 90%;height: 30px;overflow: auto;" id="GlobalInfo">		
		</div>										
		
		<div class="box_top"></div>		
			<div id="obj">
				<object id="DPSDK_OCX" classid="CLSID:D3E383B6-765D-448D-9476-DFD8B499926D" style="width: 100%; height: 80%" codebase="DpsdkOcx.cab#version=1.0.0.0"></object>
			</div>				
			<input type="hidden" id="textWndNum" value="1" /> 	
			<input type="hidden" id="textIP" value="${pfData.url}"/>
			<input type="hidden" id="textPort" value="${pfData.port}"/>
			<input type="hidden" id="textUser" value="${pfData.username}"/>
			<input type="hidden" id="textPassword" value="${pfData.password}"/>	
		
			<input type="hidden" id = "selectStreamType" value="1">
			<input type="hidden" id="selectMediaType" value="1">
			<input type="hidden" id="selectTransType" value="1">
			<input type="hidden" id="textCameraID" value="1000001$1$0$0"/>
			<input type="hidden" id="textChnlSN" value="30001" />
			<div class="fun-div" style="float:left;margin-top:0">
			  <input type="button"  value="播放" onclick="startPreviewDH()"	/>
			</div>
			<div class="fun-div" style="float:left;margin-top:0">
			  <input type="button" id="buttonLogout" value="登出" class="button" onclick="return ButtonLogout_onclick()" />
			</div>
			
  </body> 
  <!-- <script src="/js/My97DatePicker/WdatePicker.js"></script> -->
<script src="/js/running/camera/getVideoDH.js"></script>
<script type="text/javascript">
</script>
</html>
