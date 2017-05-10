package yzwTax.itcast.nsfw.user.action;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// 列表页面
	@ResponseBody
	public String listUI() {

		// userList = userSerivce.findObjects();

		System.out.println("========");

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

					String filePath = ServletActionContext.getServletContext()
							.getRealPath("upload/user");

					String fileName = UUID.randomUUID().toString()
							.replace("-", "")
							+ headImgFileName.substring(headImgFileName
									.lastIndexOf("."));

					System.out.println(filePath + ":" + fileName);
					FileUtils.copyFile(headImg, new File(filePath, fileName));

					// 2.设置用户头像路径
					user.setHeadImg("user/" + fileName);

				}
				userSerivce.save(user);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
}
