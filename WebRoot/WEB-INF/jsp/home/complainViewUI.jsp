<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉信息</title>
</head>
<body class="rightBody">
    <div class="vp_d_1">
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;投诉信息</div></div>
    <div class="tableH2">投诉详细信息<span style="color:red;">()</span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">是否匿名投诉：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
            </td>
        </tr>
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td></td>
        </tr>
        <tr><td colspan="2" align="center">受理信息</td></tr>
        <tr>
            <td colspan="2">
            <fieldset style="border: solid 1px #c0c0c0;margin-top:5px;"><legend style="color:green;font-weight:bold;">回复1&nbsp;</legend>
						<div style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
						回复部门：xxx&nbsp;&nbsp;
						回复人：xxx&nbsp;&nbsp;
						回复时间：2014-09-17
						</div>
						<div style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;"><s:property value="replyContent"/></div>
					</fieldset>
            </td>
        </tr>
    </table>
    </div></div>
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</body>
</html>