package yzwTax.itcast.nsfw.user.action;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	@Resource
	private UserService userSerivce;
	private User user;
	private List<User> userList;

	private String[] selectRow;
	private File headImg;
	private String headImgContenttype;
	private String headImgFileName;

	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;

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

					// HttpServletRequest request = ServletActionContext
					// .getRequest();
					// String filePath = request.getScheme() + "://"
					// + request.getServerName() + ":"
					// + request.getServerPort() + "/";
					String fileName = UUID.randomUUID().toString()
							.replace("-", "")
							+ headImgFileName.substring(headImgFileName
									.lastIndexOf("."));

					FileUtils.copyFile(headImg, new File(filePath, fileName));

					// 2.设置用户头像路径
					user.setHeadImg(fileName);

				}
				userSerivce.save(user);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "list";
	}

	// 跳转到editUI
	public String editUI() {

		if (user != null && user.getId() != null) {
			user = userSerivce.findObjectById(user.getId());

		}

		return "editUI";
	}

	// 保存编辑
	public String edit() {
		try {
			if (user != null) {
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

				userSerivce.update(user);
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
}
