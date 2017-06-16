<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }nsfw/user_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户</div></div>
    <div class="tableH2">新增用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">所属部门：</td>
            <td><s:select name="user.dept1" list="#deptList" listKey="id" listValue="name"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">头像：</td>
            <td>
                <input type="file" name="headImg"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><s:textfield name="user.name"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><s:textfield name="user.account" id="account" onchange="doVerify()"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><s:textfield name="user.password"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td><s:radio list="#{'true':'男','false':'女'}" name="user.gender"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色：</td>
            <td>
            
        	  <s:checkboxlist list="#roleList" name="userRoleIds" listKey="roleId" listValue="name" ></s:checkboxlist>  
       
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电子邮箱：</td>
            <td><s:textfield name="user.email"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><s:textfield name="user.mobile"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">生日：</td>
            <td><s:textfield id="birthday" name="user.birthday" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" /></td>
        </tr>
		<tr>
            <td class="tdBg" width="200px">状态：</td>
            <td><s:radio list="#{'1':'有效','0':'无效'}" name="user.state" value="1"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td><s:textarea name="user.memo" cols="75" rows="3"/></td>
        </tr>
    </table>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
<script type="text/javascript">
	var strResult=false;
	//校验账号唯一
	function doVerify(){
		
		//获取账号
		var account=$("#account").val();
		
		if(account!=""){
			$.ajax({
				url:"${basePath }nsfw/user_verifyAccount.action",
				data:{"user.account":account},
				type:"post",
				async:false,
				success:function(msg){
					
					console.log(JSON.stringify(msg))
					if("true"!=msg){
						
						//帐号已经存在
						alert("帐号已经存在。请使用其它帐号！");
						//定焦
						$("#account").focus();
						vResult = false;
					}else{
						
						vResult = true;
					}
					
					
				}
				
				
			})
			
		}
		
	}

	//提交表单
	function doSubmit(){
		var name = $("#name");
		if(name.val() == ""){
			alert("用户名不能为空！");
			name.focus();
			return false;
		}
		var password = $("#password");
		if(password.val() == ""){
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		//帐号校验
		doVerify();
		if(vResult){
    		//提交表单
    		document.forms[0].submit();
		}
	}

</script>
</html>