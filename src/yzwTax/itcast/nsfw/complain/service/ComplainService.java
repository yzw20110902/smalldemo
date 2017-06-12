package yzwTax.itcast.nsfw.complain.service;

import java.io.Serializable;
import java.util.List;

import yzwTax.itcast.core.page.PageResult;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.complain.entity.complain;

public interface ComplainService {

	// 新增
	public void save(complain complain);

	// 更新

	public void update(complain complain);

	// 根据id删除

	public void delete(Serializable id);

	// 根据id查找

	public complain findObjectById(Serializable id);

	// 条件查询实体列表

	public List<complain> findObjects(String hql, List<Object> parameters);

	// 条件查询实体列表--查询QueryHelper;
	public List<complain> findObjects(QueryHelper queryHelper);

	// 分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);
}
