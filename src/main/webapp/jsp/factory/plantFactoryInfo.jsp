<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/include/tagLib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>My JSP 'plantFactoryInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
    span{
    	cursor:pointer; 
        }
    </style>
  </head> 
  <body bgcolor="#416987">
  	<div style="background-image: url('/images/backGround.png');width:100%;height:100%;position:absolute;text-align: center;top:0px;left:0px;">
  		<div style="margin-top:10%;">
  	      <table style="text-align:center;margin-left:25% ;" >
   			<tbody><tr style="margin-top: 30%">
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=01')"><img src="/images/camera.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=02')"><img src="/images/tel.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=03')"><img src="/images/door.png"></span></td>
   			  <td width="204px"></td>
   			</tr>
   			<tr>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=01')"><img src="/images/text-camera.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=02')"><img src="/images/text-tel.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=03')"><img src="/images/text-door.png"></span></td>
   			  <td width="204px"></td>
   			</tr>
   			<tr height="80px">
   			  <td></td><td></td><td></td>
   			</tr>
   			<tr>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=06')"><img src="/images/life.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=04')"><img src="/images/eWire.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=05')"><img src="/images/meet.png"></span></td>
   			  <td width="204px"></td>
   			</tr>
   			<tr>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=06')"><img src="/images/text-life.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=04')"><img src="/images/text-eWire.png"></span></td>
   			  <td width="204px"></td>
   			  <td><span onclick="plantFactoryDescription('/standard/plantFactoryInfoSecond?code=05')"><img src="/images/text-meet.png"></span></td>
   			  <td width="204px"></td>
   			</tr>
   		  </tbody></table>
  		</div> 		
   	</div> 		   	
  </body>
<script src="/js/service/service.js"></script>
</html>
