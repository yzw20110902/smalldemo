package yzwTax.itcast.home.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import yzwTax.itcast.core.constant.Constant;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.complain.entity.complain;
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

	private Info info;

	private complain complain;

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

		return "home";
	}

	public String complainAddUI() {

		return "complainAddUI";
	}

	public void getUserJson() {

	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public complain getComplain() {
		return complain;
	}

	public void setComplain(complain complain) {
		this.complain = complain;
	}

	public Map<String, Object> getReturn_map() {
		return return_map;
	}

	public void setReturn_map(Map<String, Object> return_map) {
		this.return_map = return_map;
	}

}
