<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
    <script type="text/javascript">
	//全选、全反选
	function doSelectAll(){
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
    function doAdd(){
    	
    	document.forms[0].action="${basePath}nsfw/info_addUI.action";
  		document.forms[0].submit();
    	
    }
	function doEdit(){
    	
    	document.forms[0].action="${basePath}nsfw/info_editUI.action";
  		document.forms[0].submit();
    	
    }
	function doDelete(id){
    	
    	document.forms[0].action="${basePath}nsfw/info_delete.action?info.infoId="+id;
  		document.forms[0].submit();
    	
    }
	
	function doEdit(id){
    	
    	document.forms[0].action="${basePath}nsfw/info_editUI.action?info.infoId="+id;
  		document.forms[0].submit();
    	
    }
	//批量删除
  	function doDeleteAll(){
  		document.forms[0].action = "${basePath}nsfw/info_deleteSelected.action";
  		document.forms[0].submit();
  	}
	
	//更新状态
	function doPublic(id,state){
		
		$.ajax({
			url:"${basePath}nsfw/info_publicInfo.action?",
			data:{"info.infoId":id,"info.state":state},
			type:"post",
			success:function(msg){
				
				alert(msg)
				if(msg=="success"){
					if(state=="1"){
						$("#show_"+id).html('发布');
						$("#oper_"+id).html('<a href="javascript:doPublic(\''+id+'\',0)">停用</a>');
					}else{
						
						$("#show_"+id).html('停用');
						$("#oper_"+id).html('<a href="javascript:doPublic(\''+id+'\',1)">发布</a>');
					}
					
				}else{
					alert("更新信息状态失败！");
				}
				
				
			},
			error:function(err){
				
				alert(err)
				
			}
					
			
			
		})
		
		
		
	}
	
	
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        信息标题：<s:textfield name="info.title" cssClass="s_text" id="infoTitle"  cssStyle="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doS earch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td align="center">信息标题</td>
                            <td width="120" align="center">信息分类</td>
                            <td width="120" align="center">创建人</td>
                            <td width="140" align="center">创建时间</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                        <s:iterator value="listInfos" status="st">
                            <tr <s:if test="#st.odd"> bgcolor="f8f8f8" </s:if> >
                                <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='infoId'/>"/></td>
                                <td align="center"><s:property value="title"/></td>
                                <td align="center">
                                	<s:property value="#infoTypeMap[type]"/>	
                                </td>
                                <td align="center"><s:property value="creator"/></td>
                                <td align="center"><s:date name="createTime" format="yyyy-MM-dd HH:mm"/></td>
                                <td align="center" id="show_<s:property value='infoId'/>"><s:property value="state==1?'发布':'停用'"/></td>
                                <td align="center">
                                	<span id="oper_<s:property value='infoId'/>">
                                		
                                		<s:if test="state==1">
                                			<a href="javascript:doPublic('<s:property value='infoId'/>',0)">停用</a>
                                		</s:if>	
                                		<s:else>
                                			<a href="javascript:doPublic('<s:property value='infoId'/>',1)">发布</a>
                                		</s:else>
                                	</span>
                                    <a href="javascript:doEdit('<s:property value='infoId'/>')">编辑</a>
                                    <a href="javascript:doDelete('<s:property value='infoId'/>')">删除</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        <div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"cellpadding="0">
			<tr>
				<td align="right">
                 	总共1条记录，当前第 1 页，共 1 页 &nbsp;&nbsp;
                            <a href="#">上一页</a>&nbsp;&nbsp;<a href="#">下一页</a>
					到&nbsp;<input type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="1" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>	
        </div>
        </div>
    </div>
</form>
</body>
</html>