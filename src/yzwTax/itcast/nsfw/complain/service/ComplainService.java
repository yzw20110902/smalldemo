package yzwTax.itcast.nsfw.complain.service;

import java.io.Serializable;

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
}
