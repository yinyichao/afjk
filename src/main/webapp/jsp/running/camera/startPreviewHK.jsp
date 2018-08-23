<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${name}</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body onload="showStartPreview('${addressUrl}')" style="text-align: center;margin:0 auto">
    	
	<!--调用控件 -->
	<div class="startPreview" id="sp" style="margin:0 auto;" >
		<object classid="clsid:BE020CC9-521F-4641-85E1-3B631B7ADDD9" id="preview" width="600" height="400"  name="preview" ></object>
	</div>
	<!-- 视频预览所需信息  -->
	<!-- <form name="frmApp" method="post" action=""> -->
	    <!--回调结果  -->
			<input type="hidden" name="Result" style="width:440px"  id="Result" value="">
			<br>
		<!-- 监控点编号 -->
			<input type="hidden" name="CameraIndexCode" style="width:160px" id="CameraIndexCode" value="${code}">
		<!-- IP -->
			<input type="hidden" name="IP" id="IP" value="${pfData.url}" >
		<!-- Port -->
			<input type="hidden" name="port" id="port" value="${pfData.port}" >
		<!-- UserName -->
			<input type="hidden" name="UserName" id="UserName" value="${pfData.username}" >
		<!-- Password -->
			<input type="hidden" name="Password" id="Password" value="${pfData.password}">
	<!-- </form> -->
		    <%-- <input type="button"  value="文字" onclick="shoWenzi('${name}')"> --%>
	<!-- <input type="button" name="Password1" id="Password1" value="播放" onclick="showStartPreview('${addressUrl}')"> -->
</body>
<jsp:include page="/include/jsLib.jsp"/>
<script src="/js/running/camera/getVideoHK.js"></script>
<!--以下是事件触发函数接口 --> 
<script language="javascript" for="preview" event="MsgNotify(iMsg,iError,szDetail,lWnd)">  
	szMsg = "消息类型:" + iMsg + "，错误码:" + iError + "，详细信息:" + szDetail + "，窗口ID: " + lWnd;
	//alert(szMsg);
	//document.frmApp.Result.value = szMsg;
	document.getElementById("Result").value = szMsg;
	if (iMsg == 0x0200000E) {
		var _id = iError;
		var _token = "#token#";
		//var _url="url=sdk://hc8://10.17.48.49:8000:0:MAIN:admin:12345:TCP";
		//preview.SetToken(_id, _url);;
	}
	if (iMsg == 0x02000007)
	{
		var _right = "10034,10033,10032,10020,10027,10014,10001,10028,10002,10015,10005,10010,10024,10006,10011,10003,10021,10012,10022,10004,10013,10009,10029";
		preview.SetRightCode(_right);
		var _toolbar = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<ToolBar><Item type=\"0\" /><Item type=\"24\" /><Item type=\"5\" />"
				+ "<Item type=\"6\" /><Item type=\"7\" /><Item type=\"8\" />"
				+ "<Item type=\"9\" /><Item type=\"10\" /><Item type=\"12\" />"
				+ "<Item type=\"17\" /><Item type=\"20\" /><Item type=\"21\" />"
				+ "<Item type=\"22\" /></ToolBar>";
		preview.SetToolBar(_toolbar);
		preview.SetToolBarAlwaysShow(1);
		preview.SetInstPlayCfg(30);
		var _snap = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<SnapShot><PicType>jpeg</PicType><Quality>80</Quality><SnapMulti>1</SnapMulti>"
				+ "<SnapTimes>3</SnapTimes><TimeSpan>1</TimeSpan><SaveFolder>E:\\</SaveFolder><KeyWords></KeyWords></SnapShot>";
		preview.SetSnapParam(_snap);
		var _record = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<VideoRecord><PackType>0</PackType><MaxRecTime>0</MaxRecTime>"
				+ "<PackTime>100</PackTime><PackSize>100</PackSize><SaveFolder>E:\\</SaveFolder><KeyWords></KeyWords></VideoRecord>";
		preview.SetRecordParam(_record);
	}
</script> 
</html>
