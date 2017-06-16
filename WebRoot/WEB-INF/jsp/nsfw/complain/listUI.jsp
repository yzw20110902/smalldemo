<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉受理管理</title>
    
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	投诉标题：<s:textfield name="complain.compTitle" cssClass="s_text"  cssStyle="width:160px;"/>
                    </li>
                    <li>
                       	投诉时间：<s:textfield id="startTime" name="startTime" cssClass="s_text"  cssStyle="width:160px;" readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});"/>
                              - 
                             <s:textfield id="endTime" name="endTime" cssClass="s_text"  cssStyle="width:160px;" readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});" />
                    </li>
                    <li>
                       	状态：<%-- <s:select name="complain.state" list=""/> --%>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                    	<input type="button" value="统计" class="s_button" onclick="doAnnualStatistic()"/>&nbsp;
                    </li>

                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">投诉标题</td>
                            <td width="120" align="center">被投诉部门</td>
                            <td width="120" align="center">被投诉人</td>
                            <td width="140" align="center">投诉时间</td>
                            <td width="100" align="center">受理状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                    <s:iterator value="pageResult.items" status="st"> 
                            <tr <s:if test="#st.odd"> bgcolor="f8f8f8" </s:if> >
                                <td align="center"><s:property value="compTitle"/></td>
                                <td align="center"><s:property value="toCompDept"/></td>
                                <td align="center"><s:property value="toCompName"/></td>
                                <td align="center"><s:date name="compTime" format="yyyy-MM-dd HH:mm"/></td>
                                <td align="center"><s:property value="#complainStateMap[state]"/></td>
                                <td align="center">
                                    <a href="javascript:doDeal('<s:property value='compId'/>')">受理</a>
                                </td>
                            </tr>
                       </s:iterator> 
                    </table>
                </div>
            </div>

        <div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共<s:property value="pageResult.totalCount"/>条记录，当前第 <s:property value="pageResult.pageNo"/> 页，共<s:property value="pageResult.totalPageCount"/>页 &nbsp;&nbsp;
                           <s:if test="pageResult.pageNo>1">
                           		<a href="javascript:doGoPage(<s:property value='pageResult.pageNo-1' />)">上一页</a>
                           </s:if>
                           
                           <s:if test="pageResult.pageNo<pageResult.totalPageCount">
                            	<a  href="javascript:doGoPage(<s:property value='pageResult.pageNo+1'/>)">下一页</a>
                           </s:if>
                           
					到&nbsp;<input type="text" id="pageNo" name="pageNo" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="<s:property value="pageResult.pageNo"/>" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>	
        </div>

        </div>
    </div>
</form>

</body>
<script type="text/javascript">

var list_url = "${basePath}nsfw/complain_listUI.action";
	//搜索
	function doSearch(){
		//重置页号
		$("#pageNo").val(1);
		document.forms[0].action = list_url;
		document.forms[0].submit();
	}
	//受理
	function doDeal(compId){
		document.forms[0].action = "${basePath}nsfw/complain_dealUI.action?complain.compId=" + compId;
		document.forms[0].submit();
	}
	//投诉统计
	function doAnnualStatistic(){
		document.forms[0].action = "${basePath}nsfw/complain_annualStatisticChartUI.action";
		document.forms[0].submit();
	}

	//翻页
	function doGoPage(pageNo){
		
		document.getElementById("pageNo").value = pageNo;
		document.forms[0].action=list_url;
		document.forms[0].submit();
	}
	

</script>

</html>