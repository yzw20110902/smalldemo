package yzwTax.itcast.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

public class SysResultAction extends StrutsResultSupport {

	@Override
	protected void doExecute(String arg0, ActionInvocation arg1)
			throws Exception {
		// TODO Auto-generated method stub

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		ActionInvocation invocation = null;
		BaseAction action = (BaseAction) invocation.getAction();

	}

}
