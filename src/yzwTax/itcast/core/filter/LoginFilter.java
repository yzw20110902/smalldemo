package yzwTax.itcast.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import yzwTax.itcast.core.constant.Constant;
import yzwTax.itcast.core.permission.permissionCheck;
import yzwTax.itcast.nsfw.user.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 判断当前请求地址是否登录的请求地址
		String uri = request.getRequestURI();

		if (!uri.contains("sys/login_")) {

			// 非登录请求

			if (request.getSession().getAttribute(Constant.USER) != null) {
				// 登录成功判断是否有纳税服务系统权限
				if (uri.contains("/nsfw/")) {
					User user = (User) request.getSession().getAttribute(
							Constant.USER);
					// 获取spring容器
					WebApplicationContext applicationContext = WebApplicationContextUtils
							.getWebApplicationContext(request.getSession()
									.getServletContext());

					permissionCheck pc = (permissionCheck) applicationContext
							.getBean("permissionCheck");

					if (pc.isAccessible(user, "nsfw")) {

						arg2.doFilter(arg0, arg1);

					} else {

						response.sendRedirect(request.getContextPath()
								+ "/sys/login_toNoPermissionUI.action");
					}

				} else {
					arg2.doFilter(arg0, arg1);
				}

			} else {
				// 没有登录的直接跳转到登录页面
				response.sendRedirect(request.getContextPath()
						+ "/sys/login_toLoginUI.action");

			}

		} else {

			// 登录请求 通过

			arg2.doFilter(arg0, arg1);

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
