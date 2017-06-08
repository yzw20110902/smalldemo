package yzwTax.itcast.core.constant;

import java.util.HashMap;

public class Constant {

	// 用户登陆系统session标识符号

	public static String USER = "SYS_USER";

	/*
	 * 系统权限集合
	 */

	public static String PRIVILEGE_XZGL = "xzgl";
	public static String PRIVILEGE_HQFW = "hqfw";
	public static String PRIVILEGE_ZXXX = "zxxx";
	public static String PRIVILEGE_NSFW = "nsfw";
	public static String PRIVILEGE_SPACE = "spaces";

	public static HashMap<String, String> PRIVILEGE_Map;

	static {
		PRIVILEGE_Map = new HashMap<String, String>();

		PRIVILEGE_Map.put(PRIVILEGE_XZGL, "行政管理");
		PRIVILEGE_Map.put(PRIVILEGE_HQFW, "后勤服务");
		PRIVILEGE_Map.put(PRIVILEGE_ZXXX, "在线学习");
		PRIVILEGE_Map.put(PRIVILEGE_NSFW, "纳税服务");
		PRIVILEGE_Map.put(PRIVILEGE_SPACE, "我的空间");

	}

}
