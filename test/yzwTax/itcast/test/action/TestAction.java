package yzwTax.itcast.test.action;

import yzwTax.itcast.test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private TestService testService;

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public String execute() {

		// testService.say();

		return SUCCESS;

	}

}
