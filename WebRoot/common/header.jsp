<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
	pageContext.setAttribute("basePath1", request.getScheme()+"://"+request.getServerName()+':'+request.getLocalPort()+"/") ;
%>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath}js/jquery/jquery-1.10.2.min.js"></script>
    <link href="${basePath}css/skin1.css" rel="stylesheet" type="text/css" />