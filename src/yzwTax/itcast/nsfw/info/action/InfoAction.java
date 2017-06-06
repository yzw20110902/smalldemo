package yzwTax.itcast.nsfw.info.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
		}

		return "list";

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
