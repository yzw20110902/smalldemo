package yzwTax.itcast.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import yzwTax.itcast.core.page.PageResult;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.dept.entity.Dept;
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

	// 根据用户id 获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);

	// 根据用户的账号和密码查询用户列表
	public List<User> findUserByAccountAndPass(String account, String password);

	// 条件查询实体列表

	public List<User> findObjects(String hql, List<Object> parameters);

	// 条件查询实体列表--查询QueryHelper;
	public List<User> findObjects(QueryHelper queryHelper);

	// 分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);

	// 保存用户对应的部门

	public void saveUserDept(Dept dept);
}
