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
	<meta http-equiv="description" content="This is my page">
    <style type="text/css">
        div,td,input
        {
            font-size:12px;
        }
        .ptzBtn
        {
            width:32px;
        }
        #Select1
        {
            width: 67px;
        }
        #SelectWnd
        {
            width: 70px;
        }
    </style>
    
</head>

<body onload="init()" center style="margin: 0 auto;">
	
		<div style="overflow:hidden;text-align:center">
            <!-- 添加回放控件（需要先在windows下注册） -->
            <div style="text-align:center">
            <!-- <form name="frmApp" method="post" action="">  -->           
                         开始时间：<input id="BeginTime" type="text" name="BeginTime" value='' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" class="select-text" style="padding: 0 5px;" readonly/>
			 结束时间：<input id="EndTime" type="text" name="EndTime" value='' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" class="select-text" style="padding: 0 5px;" readonly/>
            <input type="button" value="录像回放" onclick="playBackHK()" />
					<!--回调结果-->
						<input type="hidden" name="Result" style="width:440px"  id="Result" value="">
						<br>
					<!--IP-->
						<input type="hidden" name="IP" id="IP" value="${pfData.url}" style="width:120px">
					<!--Port-->
						<input type="hidden" name="port" id="port" value="${pfData.port}" style="width:40px">
					<!--UserName-->
						<input type="hidden" name="UserName" id="UserName" value="${pfData.username}" style="width:60px">
					<!--Password-->
						<input type="hidden" name="Password" id="Password" value="${pfData.password}" style="width:100px">
					<!--CameraIndexCode-->
						<input type="hidden" name="CameraIndexCode" style="width:160px"  id="CameraIndexCode" value="${code}">
					<!--CameraName-->
						<input type="hidden" name="CameraName" id="CameraName" value="${name}" style="width:120px">
						<!-- <input type="text" name="EndTime" id="EndTime" value="2017-10-09T14:59:59.000Z" style="width:160px"> -->
					<!--StoreDeviceType-->
						<input type="hidden" name="StoreDeviceType" id="StoreDeviceType" value="0" style="width:20px">
					<!--PlayPosition-->
						<input type="hidden" name="PlayPosition" id="PlayPosition" value="1493946300" style="width:100px">
					<!--PreNextBtnVisible-->
						<input type="hidden" name="PreNextBtnVisible" id="PreNextBtnVisible" value="true" style="width:60px">
						<!-- <input type="button" value="录像回放" onclick="playBackHK()" /><input type="button" value="停止播放" onclick="StopPlay()" /> -->
				<!-- </form> -->
			</div>			
			<div id="ocxContainer">
                <object classid="CLSID:D4E11A6C-245F-48FB-9D02-8C53C0AB10F6" id="playback" width="<c:if test="${not empty width}">${width}</c:if><c:if test="${empty width}">400</c:if>" height="<c:if test="${not empty height}">${height}</c:if><c:if test="${empty height}">400</c:if>"  name="preview" ></object>
            </div>
			<div style="overflow:hidden">
            &nbsp;<br />
				<table>
					<tr>
						<td ><input type="hidden" value="登录平台" onclick="LoginPlat()" /></td>
					</tr>
					<tr>
						<td ><input type="hidden" value="获取播放时间" onclick="GetPlayerTime()" /></td>
						<td ><input type="hidden" value="设置播放时间" onclick="SetPlayPos()" /></td>
						<td ><input type="hidden" value="设置左右按钮" onclick="SetPreNextBtnState()" /></td>
					</tr>
				</table>
            </div>
		 </div>     
    
</body>
<jsp:include page="/include/jsLib.jsp"/>
<script src="/js/running/camera/getVideoHK.js"></script>
<!-- 以下是事件触发函数接口 -->  
<script language="javascript" for="playback" event="MsgNotify(iMsg,iError,szDetail,lWnd)">  
    szMsg = "消息类型:" + iMsg + "，错误码:" + iError + "，详细信息:" + szDetail + "，窗口ID: " + lWnd;  
    //alert(szMsg);
    //document.frmApp.Result.value = szMsg;
    document.getElementById("Result").value = szMsg;
    if (iMsg == 0x02000006) 
    {
        var id = iError;
        var _token = "#token#"; //通过webservice获取
        //playback.SetToken(id, "");
    }
    else if (iMsg == 0x02000005) 
    {
        var v = "抓图结果："+szDetail;
        alert(v);
    }
    else if (iMsg == 0x200000E) 
    {
        alert("上一个按钮被按下");
    }
    else if (iMsg == 0x200000F) 
    {
        alert("下一个按钮被按下");
    }
</script>
</html>

