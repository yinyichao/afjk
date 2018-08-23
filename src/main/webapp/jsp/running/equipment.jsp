<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/include/tagLib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title></title>
  <jsp:include page="/include/cssLib.jsp" /> 
  <link rel="stylesheet" href="/css/style.css">
</head>
<body bgcolor="#ebecf3">
  <!-- [整个外部div -->
  <div class="frame-div">
    <!-- [上方灰色小窄框  -->
    <div class = "frame-div-d" style="float:left">
    	<div style = "float:left"><img src="/images/1.png" class="frame-img"/>${prisonName}设备运行情况</div>
    </div>
    <!-- 上方灰色小窄框 ] -->
   
    <!-- [显示监狱的div -->
    <div id="changeDiv" class ="div-inform";onMouseOver="show()";onMouseOut="hidden()";> 
    	<ul >
    		<c:forEach items="${plants}" var="p">
    			<li class="li-prison" onclick="changePrison('/secIn/prisonInform?code=${p.code}')";>${p.name}</li>
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
    
    <!-- [下方仪表div -->
	  <div style="position:absolute; top:100px;width:92%">
	  	<table>
	  		<tr>
	  			<td id="myChart" onclick="equipmentInform('/plantPerimeter/cameraview?code=${code}')"; style="width: 600px;height:400px;"></td>
	  			<td id="myChart1" onclick="equipmentInform('/plantTel/telview?code=${code}')"; style="width: 600px;height:400px;"></td>
	  			<td id="myChart2" onclick="equipmentInform('/plantDoor/doorview?code=${code}')"; style="width: 600px;height:400px;"></td>
	  		</tr>
	  		<tr>
	  			<td id="myChart3" onclick="equipmentInform('/plantLife/lifeview?code=${code}')"; style="width:600px;height:400px;"></td>
	  			<td id="myChart4" onclick="equipmentInform('/plantPhone/phoneview?code=${code}')"; style="width:600px;height:400px;"></td>
	  			<td id="myChart5" onclick="equipmentInform('/plantEwire/ewireview?code=${code}')"; style="width:600px;height:400px;"></td>
	  		</tr>
	  	</table>
	  </div>
    <!-- 下方仪表div] -->
  </div>
  <!-- 整个外部div] --> 
  <script src="/js/echarts.min.js"></script> 
  <script src="/js/running/equipment.js"></script>
  </body>
  
  <!--仪表盘-->

</html>
