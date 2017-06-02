package yzwTax.itcast.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.entity.UserRole;

public interface UserService {
	// 新增
	public void save(User user);

	// 更新

	public void update(User user);

	// 根据id删除

	public void delete(Serializable id);

	// 根据id查找

	public User findObjectById(Serializable id);

	// 查找列表
	public List<User> findObjects();

	// 导出用户列表
	public void exportExcel(List<User> userList,
			ServletOutputStream servletOutputStream);

	// 导入用户列表
	public void importExcel(File userExcel, String userExcelFileName);

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

	// 保存用户及其对应的角色
	public void saveUserAndRole(User user, String... roleIds);

	// 更新用户及其对应的角色
	public void updateUserAndRole(User user, String... roleIds);

	// 保存用户角色

	public void saveUserRole(UserRole userRole);

	// 根据用户id 删除该用户的所有用户角色
	public void deleteUserRoleByUserId(Serializable id);

	// 根据用户id 获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(Serializable id);

	// 根据用户的账号和密码查询用户列表
	public List<User> findUserByAccountAndPass(String account, String password);

}
