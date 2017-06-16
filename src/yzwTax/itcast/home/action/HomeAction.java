package yzwTax.itcast.home.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import yzwTax.itcast.core.constant.Constant;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.complain.entity.Complain;
import yzwTax.itcast.nsfw.complain.service.ComplainService;
import yzwTax.itcast.nsfw.info.entity.Info;
import yzwTax.itcast.nsfw.info.service.InfoService;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	@Resource
	private InfoService infoService;
	@Resource
	private UserService userService;
	@Resource
	private ComplainService complainService;

	private Info info;

	private Complain comp;

	private Map<String, Object> return_map;

	public String execute() {

		// 加载信息列表

		ActionContext.getContext().getContextMap()
				.put("InfoTypeMap", Info.INFO_TYPE_MAP);

		QueryHelper queryHelper1 = new QueryHelper(Info.class, "i");
		queryHelper1.addOrderByProperty("i.createTime",
				QueryHelper.OREDER_BY_DESC);
		List<Info> infoList = infoService.findObjects();

		ActionContext.getContext().getContextMap().put("infoList", infoList);

		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute(Constant.USER);

		// 加载集合状态
		ActionContext.getContext().getContextMap()
				.put("compState", Complain.COMPLAIN_STATE_MAP);

		// 加载投诉信息列表
		QueryHelper queryHelper2 = new QueryHelper(Complain.class, "c");

		queryHelper2.addCondition("c.compName=?", user.getName());
		// 根据投诉时间升序
		queryHelper2.addOrderByProperty("c.compTime",
				QueryHelper.OREDER_BY_DESC);
		// 根据投诉状态进行降序
		queryHelper2.addOrderByProperty("c.state", QueryHelper.OREDER_BY_ASC);

		List<Complain> compList = complainService.getPageResult(queryHelper2,
				1, 6).getItems();
		ActionContext.getContext().getContextMap().put("compList", compList);

		return "home";
	}

	public String complainAddUI() {

		return "complainAddUI";
	}

	public void complainAdd() {

		try {
			if (comp != null) {

				comp.setState(Complain.COMPLAIN_STATE_UNDONE);
				comp.setCompTime(new Timestamp(new Date().getTime()));
				User user = (User) ServletActionContext.getRequest()
						.getSession().getAttribute(Constant.USER);
				comp.setCompName(user.getName());

				complainService.save(comp);

				// 输出投诉结果
				HttpServletResponse response = ServletActionContext
						.getResponse();

				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();

				outputStream.write("success".getBytes("utf-8"));
				outputStream.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getUserJson() {

		try {
			// 1.获取部门
			String dept = ServletActionContext.getRequest()
					.getParameter("dept");

			if (StringUtils.isNotBlank(dept)) {
				QueryHelper queryHelper = new QueryHelper(User.class, "u");
				queryHelper.addCondition("u.dept like ?", " % " + dept);
				// 2.根据部门查询用户列表
				List<User> userList = userService.findObjects();

				// 创建json对象

				JSONObject json = new JSONObject();
				json.put("msg", "success");

				json.accumulate("userList", userList);

				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(json.toString().getBytes("utf-8"));
				outputStream.close();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public String complainViewUI() {
		// 加载集合状态
		ActionContext.getContext().getContextMap()
				.put("compState", Complain.COMPLAIN_STATE_MAP);

		if (comp != null) {

			comp = complainService.findObjectById(comp.getCompId());

		}

		return "complainViewUI";
	}

	public String infoViewUI() {
		// 加载信息列表

		ActionContext.getContext().getContextMap()
				.put("InfoTypeMap", Info.INFO_TYPE_MAP);

		if (info != null && info.getInfoId() != null) {

			info = infoService.findObjectById(info.getInfoId());

		}
		return "infoViewUI";
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Complain getComp() {
		return comp;
	}

	public void setComp(Complain comp) {
		this.comp = comp;
	}

	public Map<String, Object> getReturn_map() {
		return return_map;
	}

	public void setReturn_map(Map<String, Object> return_map) {
		this.return_map = return_map;
	}

}
