package yzwTax.itcast.login.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import yzwTax.itcast.core.constant.Constant;
import yzwTax.itcast.nsfw.dept.entity.Dept;
import yzwTax.itcast.nsfw.dept.service.deptService;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	@Resource
	private UserService userService;
	@Resource
	private deptService deptService;

	private User user;
	private String loginResult;
	private Dept dept;

	public String toLoginUI() {

		return "loginUI";
	}

	// 登陆

	public String login() {

		if (user != null) {

			if (StringUtils.isNotBlank(user.getAccount())
					&& StringUtils.isNotBlank(user.getPassword())) {

				List<User> list = userService.findUserByAccountAndPass(
						user.getAccount(), user.getPassword());

				if (list != null && list.size() > 0) {

					User user = list.get(0);

					user.setUserRoles(userService.getUserRolesByUserId(user
							.getId()));

					ServletActionContext.getRequest().getSession()
							.setAttribute(Constant.USER, user);

					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute(
									"dept",
									deptService.findObjectById(user.getDept1())
											.getName());
					Log log = LogFactory.getLog(getClass());
					log.error("用户名称" + user.getAccount() + "登录了系统");
					return "home";
				} else {
					loginResult = "账号密码不正确";
					Log log = LogFactory.getLog(getClass());
					log.error("用户名称" + loginResult + "登录了系统");
				}

			} else {
				loginResult = "账号和密码不能为空";
				Log log = LogFactory.getLog(getClass());
				log.error(loginResult);

			}

		} else {
			loginResult = "请输入账号和密码";
			Log log = LogFactory.getLog(getClass());
			log.error(loginResult);
		}

		return toLoginUI();
	}

	// 退出和注销
	public String loginout() {

		// 清除session中的消息

		ServletActionContext.getRequest().getSession()
				.removeAttribute(Constant.USER);

		return toLoginUI();
	}

	// 跳转到没有权限的提示的页面

	public String toNoPermissionUI() {

		return "noPermissionUI";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
