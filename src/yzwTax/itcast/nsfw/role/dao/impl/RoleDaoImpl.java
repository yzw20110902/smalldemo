package yzwTax.itcast.nsfw.role.dao.impl;

import org.hibernate.Query;

import yzwTax.itcast.core.dao.impl.BaseDaoImpl;
import yzwTax.itcast.nsfw.role.dao.RoleDao;
import yzwTax.itcast.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}
