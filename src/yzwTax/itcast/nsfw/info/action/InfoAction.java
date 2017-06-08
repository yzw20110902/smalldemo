package yzwTax.itcast.nsfw.info.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import yzwTax.itcast.core.action.BaseAction;
import yzwTax.itcast.nsfw.info.entity.Info;
import yzwTax.itcast.nsfw.info.service.InfoService;

import com.opensymphony.xwork2.ActionContext;

public class InfoAction extends BaseAction {

	@Resource
	private InfoService infoService;

	private List<Info> listInfos;
	private Info info;

	public String listUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap()
				.put("infoTypeMap", Info.INFO_TYPE_MAP);
		try {
			listInfos = infoService.findObjects();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "listUI";
	}

	public String addUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap()
				.put("infoTypeMap", Info.INFO_TYPE_MAP);

		info = new Info();

		info.setCreateTime(new Timestamp(new Date().getTime()));

		return "addUI";
	}

	public String add() {

		try {

			if (info != null) {
				infoService.save(info);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return "list";
	}

	public String delete() {

		try {
			if (info != null && info.getInfoId() != null) {

				infoService.delete(info.getInfoId());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "list";

	}

	// 删除所有的

	public String deleteSelected() {

		if (selectedRow != null) {

			for (String id : selectedRow) {

				infoService.delete(id);
			}

		}

		return "list";
	}

	// 编辑页面

	public String editUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap()
				.put("infoTypeMap", Info.INFO_TYPE_MAP);

		if (info != null && info.getInfoId() != null) {

			info = infoService.findObjectById(info.getInfoId());

		}

		return "editUI";
	}

	// 编辑

	public String edit() {

		try {
			if (info != null) {

				infoService.update(info);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "list";
	}

	// 异步发布消息

	public void publicInfo() {
		try {

			if (info != null) {

				// 1.更新信息状态
				Info item = infoService.findObjectById(info.getInfoId());

				item.setState(info.getState());

				infoService.update(item);

				// 2.输出接口信息

				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();

				outputStream.write("success".getBytes());
				outputStream.close();

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

	public List<Info> getListInfos() {
		return listInfos;
	}

	public void setListInfos(List<Info> listInfos) {
		this.listInfos = listInfos;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

}
