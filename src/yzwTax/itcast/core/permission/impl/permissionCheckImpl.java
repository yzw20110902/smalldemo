package yzwTax.itcast.core.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import yzwTax.itcast.core.permission.permissionCheck;
import yzwTax.itcast.nsfw.role.entity.Role;
import yzwTax.itcast.nsfw.role.entity.RolePrivilege;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.entity.UserRole;
import yzwTax.itcast.nsfw.user.service.UserService;

public class permissionCheckImpl implements permissionCheck {

	@Resource
	private UserService userService;

	@Override
	public boolean isAccessible(User user, String code) {
		// 获取用户的所有角色

		List<UserRole> list = user.getUserRoles();

		if (list == null) {

			list = userService.getUserRolesByUserId(user.getId());
		}
		// 2.根据每个角色对于所有的权限进行比较

		if (list != null && list.size() > 0) {

			for (UserRole ur : list) {

				Role role = ur.getId().getRole();

				for (RolePrivilege rp : role.getRolePrivileges()) {

					if (code.equals(rp.getId().getCode())) {

						return true;
					}
				}

			}

		}

		return false;
	}

}
