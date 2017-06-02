package yzwTax.itcast.nsfw.role.service;

import java.io.Serializable;
import java.util.List;

import yzwTax.itcast.nsfw.role.entity.Role;

public interface RoleService {

	public void save(Role role);

	// 更新
	public void update(Role role);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public Role findObjectById(Serializable id);

	// 查找列表
	public List<Role> findObjects();

}
