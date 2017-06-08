package yzwTax.itcast.core.permission;

import yzwTax.itcast.nsfw.user.entity.User;

public interface permissionCheck {

	/*
	 * 判断用户是否拥有code对应的权限
	 * 
	 * @param user 用户
	 * 
	 * @param code 子系统权限标识符
	 * 
	 * @return true or false
	 */
	public boolean isAccessible(User user, String code);

}
