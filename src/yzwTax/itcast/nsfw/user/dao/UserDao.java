package yzwTax.itcast.nsfw.user.dao;

import java.io.Serializable;
import java.util.List;

import yzwTax.itcast.core.dao.BaseDao;
import yzwTax.itcast.nsfw.dept.entity.Dept;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.entity.UserRole;

public interface UserDao extends BaseDao<User> {

	/*
	 * 根据账户和用户id查询用户
	 * 
	 * @param id 用户ID
	 * 
	 * @param account 用户账户
	 * 
	 * @return 用户列表
	 */

	public List<User> findUserByAccountAndId(String id, String account);

	// 保存用户角色

	public void saveUserRole(UserRole userRole);

	// 保存用户对应的部门

	public void saveUserDept(Dept dept);

	// 根据用户id 删除该用户的所有用户角色
	public void deleteUserRoleByUserId(Serializable id);

	// 根据用户id 获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);

	// 根据用户的账号和密码查询用户列表
	public List<User> findUserByAccountAndPass(String account, String password);

}
