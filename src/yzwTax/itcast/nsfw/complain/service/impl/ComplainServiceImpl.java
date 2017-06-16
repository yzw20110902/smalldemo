package yzwTax.itcast.nsfw.complain.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.core.page.PageResult;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.complain.dao.ComplainDao;
import yzwTax.itcast.nsfw.complain.entity.Complain;
import yzwTax.itcast.nsfw.complain.service.ComplainService;

@Service("complainService")
public class ComplainServiceImpl implements ComplainService {

	@Resource
	private ComplainDao complainDao;

	@Override
	public void save(Complain complain) {
		// TODO Auto-generated method stub
		complainDao.save(complain);

	}

	@Override
	public void update(Complain complain) {
		// TODO Auto-generated method stub
		complainDao.update(complain);

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		complainDao.delete(id);

	}

	@Override
	public Complain findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return complainDao.findObjectById(id);
	}

	@Override
	public List<Complain> findObjects(String hql, List<Object> parameters) {
		// TODO Auto-generated method stub
		return complainDao.findObjects(hql, parameters);
	}

	@Override
	public List<Complain> findObjects(QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		return complainDao.findObjects(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return complainDao.getPageResult(queryHelper, pageNo, pageSize);
	}

	@Override
	public void autoDeal() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置当前时间的日期为1号
		cal.set(Calendar.HOUR_OF_DAY, 0);// 设置当前时间的日期为1号，0时
		cal.set(Calendar.MINUTE, 0);// 设置当前时间的日期为1号，0分
		cal.set(Calendar.SECOND, 0);// 设置当前时间的日期为1号，0秒
		// 1.查询本月之前的待受理的投诉列表
		QueryHelper queryHelper = new QueryHelper(Complain.class, "c");
		queryHelper.addCondition("c.state=?", Complain.COMPLAIN_STATE_UNDONE);
		queryHelper.addCondition("c.compTime < ?", cal.getTime());// 本月1号0时0秒

		List<Complain> list = findObjects(queryHelper);

		if (list != null && list.size() > 0) {
			for (Complain com : list) {

				com.setState(Complain.COMPLAIN_STATE_DONE);
				update(com);
			}

		}

	}

	@Override
	public List<Map> getAnnualStatisticDataByYear(int year) {
		// TODO Auto-generated method stub
		List<Map> resList = new ArrayList<Map>();

		List<Object[]> list = complainDao.getAnnualStatisticDataByYear(year);

		// System.out.println("arr" + list.toString());
		if (list != null && list.size() > 0) {
			Calendar cal = Calendar.getInstance();
			// 是否为当前年份
			boolean isCurYear = (cal.get(Calendar.YEAR) == year);
			int curMonth = cal.get(Calendar.MONTH) + 1;// 当前月份
			// 格式化统计结果
			int temMonth = 0;
			Map<String, Object> map = null;

			for (Object[] obj : list) {

				System.out.println(obj[0]);

				temMonth = Integer.valueOf(obj[0] + "");
				map = new HashMap<String, Object>();
				map.put("label", temMonth + " 月");
				if (isCurYear) {
					if (temMonth > curMonth) {
						map.put("value", "");
					} else {
						map.put("value", obj[1] == null ? "0" : obj[1]);
					}

				} else {
					map.put("value", obj[1] == null ? "0" : obj[1]);
				}

				resList.add(map);
			}

		}

		return resList;
	}
}
