package yzwTax.itcast.nsfw.dept.service;

import java.io.Serializable;
import java.util.List;

import yzwTax.itcast.nsfw.dept.entity.Dept;

public interface deptService {

	// 新增
	public void save(Dept dept);

	// 更新

	public void update(Dept dept);

	// 根据id删除

	public void delete(Serializable id);

	// 根据id查找

	public Dept findObjectById(Serializable id);

	// 查找列表
	public List<Dept> findObjects();

}
