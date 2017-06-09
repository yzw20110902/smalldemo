package yzwTax.itcast.nsfw.complain.action;

import java.util.Map;

import javax.annotation.Resource;

import yzwTax.itcast.core.action.BaseAction;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.complain.entity.complain;
import yzwTax.itcast.nsfw.complain.entity.complainReply;
import yzwTax.itcast.nsfw.complain.service.ComplainService;

import com.opensymphony.xwork2.ActionContext;

public class ComplainAction extends BaseAction {

	@Resource
	private ComplainService complainService;

	private complain complain;
	private String startTime;
	private String endTime;

	private complainReply compReply;
	private String strTitle;
	private String strState;
	private Map<String, Object> statisticMap;

	// 加载列表页

	public String listUI() {

		ActionContext.getContext().getContextMap()
				.put("complainStateMap", complain.COMPLAIN_STATE_MAP);

		QueryHelper queryHelper = new QueryHelper(complain.getClass(), "c");

		return "listUI";
	}

	// 处理页面
	public String dealUI() {

		// 加载状态集合
		ActionContext.getContext().getContextMap()
				.put("complainStateMap", complain.COMPLAIN_STATE_MAP);

		return "dealUI";
	}

}
