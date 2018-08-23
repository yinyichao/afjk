<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="/include/cssLib.jsp" />
<%--自己的css文件 --%>

<%-- 此处不得写js --%>
<jsp:include page="/include/jsLib.jsp" />
</head>
<frameset rows="70,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="/platform/top" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" title="topFrame"/>
	<frame src="/platform/main" name="main" id="main" title="main" />
</frameset>
</html>