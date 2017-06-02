package yzwTax.itcast.nsfw.role.dao;

import yzwTax.itcast.core.dao.BaseDao;
import yzwTax.itcast.nsfw.role.entity.Role;

public interface RoleDao extends BaseDao<Role> {

	// 删除该角色对于所有权限
	public void deleteRolePrivilegeByRoleId(String roleId);

}
