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
    <title>My JSP 'startPreviewDH.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body onload="playBackDH()">			
	    <div style="width: 90%;height: 20px;overflow: auto;" id="RetInfo">			
		</div>
		
		<div style="width: 90%;height: 10px;overflow: auto;" id="GlobalInfo">		
		</div>										
		
		<div class="box_top"></div>		
			<div id="obj">
				<object id="DPSDK_OCX" classid="CLSID:D3E383B6-765D-448D-9476-DFD8B499926D" style="width: 100%; height: 80%" codebase="DpsdkOcx.cab#version=1.0.0.0"></object>
			</div>				
			<input type="hidden" id="textWndNum" value="1" /> 	
			<input type="hidden" id="textIP" value="${pfData.url}"/>
			<input type="hidden" id="textPort" value="${pfData.port}"/>
			<input type="hidden" id="textUser" value="${pfData.username }"/>
			<input type="hidden" id="textPassword" value="${pfData.password}"/>	
		
			<input type="hidden" id = "selectStreamType" value="1">
			<input type="hidden" id="selectMediaType" value="1">
			<input type="hidden" id="selectTransType" value="1">
			<input type="text" id="textCameraID" value="1000001$1$0$0"/>
			<input type="text" id="textChnlSN" value="30001" />
			<input type="button" id="buttonLogout" value="登出" class="button" onclick="return ButtonLogout_onclick()" />
			录像回放</br>
			来源：<select id="selectRecordSource" >
				<option value="3">平台录像</option>
				<option value="2">设备录像</option>
			</select>
			类型：
			<select id="selectRecordType" >
				<option value="0">全部录像</option>
				<option value="1">手动录像</option>
				<option value="2">报警录像</option>
				<option value="3">移动侦测</option>
				<option value="4">视频丢失</option>
				<option value="5">视频遮挡</option>
				<option value="6">定时录像</option>
				<option value="7">全天录像</option>
			</select>
			</br>
			开始时间：<input id="textStartTime" type="text" name="" value='2013-10-17 00:00:00' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',startDate:'%y-%M-%d 00:00:00',maxDate:'%y-%M-%d',minDate:'1970-01-01 10:00:00'})" class="select-text" style="padding: 0 5px;" readonly/>
			结束时间：<input id="textEndTime" type="text" name="" value='2013-10-17 23:59:59' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'1970-01-01 10:00:00'})" class="select-text" style="padding: 0 5px;" readonly/>
			<br />
			FileIndex：<input id="textFileIndex" type="text" name="" value="0" size="5" /><br /> <br />
			回放：<br />
			<input type="button" id="buttonQueryRecord" value="查询录像" onclick="return ButtonQueryRecord_onclick()" />		
  </body>
  
  <!-- <script src="/js/My97DatePicker/WdatePicker.js"></script> -->
<script src="/js/running/camera/getVideoDH.js"></script>
<script type="text/javascript">		  		
</script>
</html>
