package yzwTax.itcast.nsfw.user.action;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import yzwTax.itcast.core.action.BaseAction;
import yzwTax.itcast.nsfw.role.service.RoleService;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.entity.UserRole;
import yzwTax.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {

	@Resource
	private UserService userSerivce;

	@Resource
	private RoleService roleService;
	private User user;
	private List<User> userList;

	private String[] selectRow;
	private File headImg;
	private String headImgContenttype;
	private String headImgFileName;

	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;

	private String[] userRoleIds;

	// 列表页面
	// @ResponseBody
	public String listUI() throws Exception {

		try {
			userList = userSerivce.findObjects();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listUI";
	}

	// 跳转到新增页面
	public String addUI() {

		ActionContext.getContext().getContextMap()
				.put("roleList", roleService.findObjects());

		return "addUI";
	}

	// 保存新增

	public String add() {

		try {
			if (user != null) {
				// 处理头像
				if (headImg != null) {

					// 1.保存头像到upload/user
					// 获取保存路径的绝对地址

					// String filePath =
					// ServletActionContext.getServletContext()
					// .getRealPath("upload/user");
					String filePath = "C:/Users/50188/Desktop/apache-tomcat-7.0.72/webapps/img/";

					String fileName = UUID.randomUUID().toString()
							.replace("-", "")
							+ headImgFileName.substring(headImgFileName
									.lastIndexOf("."));

					FileUtils.copyFile(headImg, new File(filePath, fileName));

					// 2.设置用户头像路径
					user.setHeadImg(fileName);

				}
				userSerivce.saveUserAndRole(user, userRoleIds);
				// userSerivce.save(user);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "list";
	}

	// 跳转到editUI
	public String editUI() {
		ActionContext.getContext().getContextMap()
				.put("roleList", roleService.findObjects());
		if (user != null && user.getId() != null) {
			user = userSerivce.findObjectById(user.getId());

			// 处理角色回显
			List<UserRole> list = userSerivce
					.getUserRolesByUserId(user.getId());
			if (list != null && list.size() > 0) {
				userRoleIds = new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					userRoleIds[i] = list.get(i).getId().getRole().getRoleId();
				}
			}

		}

		return "editUI";
	}

	// 保存编辑
	public String edit() {
		try {
			if (user != null && user.getId() != null) {
				// 处理头像
				if (headImg != null) {
					// 1、保存头像到upload/user
					// 获取保存路径的绝对地址

					String filePath = "C:/Users/50188/Desktop/apache-tomcat-7.0.72/webapps/img/";

					String fileName = UUID.randomUUID().toString()
							.replaceAll("-", "")
							+ headImgFileName.substring(headImgFileName
									.lastIndexOf("."));
					System.out.println(filePath + ":" + fileName);
					// 复制文件
					FileUtils.copyFile(headImg, new File(filePath, fileName));

					// 2、设置用户头像路径
					user.setHeadImg(fileName);

				}

				// userSerivce.update(user);
				userSerivce.updateUserAndRole(user, userRoleIds);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// 删除
	public String delete() {

		if (user != null && user.getId() != null) {

			userSerivce.delete(user.getId());

		}

		return "list";
	}

	// 批量删除
	public String deleteAll() {

		if (selectRow != null) {

			for (String id : selectRow) {

				userSerivce.delete(id);
			}
		}
		return "list";
	}

	// 导出用户列表
	public void exportExcel() {

		try {
			// 1.查找用户列表
			userList = userSerivce.findObjects();
			// 2.导出
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/x-execl");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String("用户列表.xls".getBytes(), "ISO-8859-1"));

			ServletOutputStream outputStream = response.getOutputStream();

			userSerivce.exportExcel(userList, outputStream);

			if (outputStream != null) {

				outputStream.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 导入用户列表
	public String importExcel() {

		if (userExcel != null) {

			if (userExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
				// 2.导入
				userSerivce.importExcel(userExcel, userExcelFileName);

			}
		}
		return "list";
	}

	// 验证账户的唯一性
	public void verifyAccount() {
		try {
			if (user != null && StringUtils.isNotBlank(user.getAccount())) {

				List<User> list = userSerivce.findUserByAccountAndId(
						user.getId(), user.getAccount());

				String strResult = "true";
				if (list != null && list.size() != 0) {

					strResult = "false";
				}

				// 输出

				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(strResult.getBytes());
				outputStream.close();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserService getUserSerivce() {
		return userSerivce;
	}

	public void setUserSerivce(UserService userSerivce) {
		this.userSerivce = userSerivce;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getSelectRow() {
		return selectRow;
	}

	public void setSelectRow(String[] selectRow) {
		this.selectRow = selectRow;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgContenttype() {
		return headImgContenttype;
	}

	public void setHeadImgContenttype(String headImgContenttype) {
		this.headImgContenttype = headImgContenttype;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public File getUserExcel() {
		return userExcel;
	}

	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}

	public String getUserExcelContentType() {
		return userExcelContentType;
	}

	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}

	public String getUserExcelFileName() {
		return userExcelFileName;
	}

	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}

	public String[] getUserRoleIds() {
		return userRoleIds;
	}

	public void setUserRoleIds(String[] userRoleIds) {
		this.userRoleIds = userRoleIds;
	}

}
