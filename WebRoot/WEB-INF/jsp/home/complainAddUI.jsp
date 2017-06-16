<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>我要投诉</title>
</head>
<body>
<form id="form" name="form" action="${basePath }sys/home_complainAdd.action" method="post" enctype="multipart/form-data">
    <div class="vp_d_1">
        <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;我要投诉</div></div>
    <div class="tableH2">我要投诉</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="250px">投诉标题：</td>
            <td><s:textfield name="comp.compTitle"/></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人部门：</td>
            <td>
            	<s:select id="toCompDept" name="comp.toCompDept" list="#{'':'请选择','部门A':'A','部门B':'B' }" onchange=" doSelectDept()"></s:select>
            </td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人姓名：</td>
            <td>
            	<select id="toCompName" name="comp.toCompName">
            	</select>
            
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><s:textarea id="editor" name="comp.compContent" cssStyle="width:90%;height:160px;" /></td>
        </tr>
        <tr>
            <td class="tdBg">是否匿名投诉：</td>
            <td><s:radio name="comp.isNm" list="#{'0':'非匿名投诉','1':'匿名投诉' }" value="0"/></td>
        </tr>
       
    </table>

    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:window.close()" class="btnB2" value="关闭" />
    </div>
    </div></div>
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</form>
</body>
<script type="text/javascript">

	function doSelectDept(){
		//1.获取部门
		var dept=$("#toCompDept option:selected").val();
		if(dept!=""){
			
			$.ajax({
				url:"${basePath }sys/home_getUserJson.action",
				data:{"dept":dept},
				type:"post",
				dataType:"json",
				success:function(data){
					
					alert(JSON.stringify(data));
					console.log(JSON.stringify(data));
					if(data != null && data != "" && data != undefined){
    					if("success" == data.msg){
    						var toCompName = $("#toCompName");
    						toCompName.empty();
    						$.each(data.userList, function(index, user){
    							toCompName.append("<option value='" + user.name + "'>" + user.name + "</option>");
    						});
    					} else {alert("获取被投诉人列表失败！");}
    				} else {
    					alert("获取被投诉人列表失败！");
    				}
					
				},
				error:function(){
					
					
				}
				

			})
			
		}
		
	}















	function doSubmit(){
		$.ajax({
			url:"${basePath }sys/home_complainAdd.action",
			type:'post',
			data:$("#form").serialize(),
			async:'false',
			success:function(msg){

				if(msg=="success"){
					alert("投诉成功")
					window.opener.parent.location.reload(true);
					
					window.close();				
				}
			},
			error:function(err){
				
				alert("投诉失败")
			}		
		})
	}

</script>
</html>