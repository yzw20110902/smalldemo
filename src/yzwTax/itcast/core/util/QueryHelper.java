package yzwTax.itcast.core.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {

	// from
	private String fromClause = "";
	// where
	private String whereClause = "";
	// order by
	private String orderByClause = "";

	private List<Object> parameters;

	// 排列顺序的语句
	public static String OREDER_BY_DESC = "DESC";// 降序
	public static String OREDER_BY_ASC = "ASC";// 升序

	/*
	 * 构造from的查询语句
	 * 
	 * @param clazz 实体类
	 * 
	 * @param alias 实体类对应的别名
	 */
	public QueryHelper(Class clazz, String alias) {

		fromClause = " FROM " + clazz.getSimpleName() + " " + alias;

	}

	/*
	 * 构造where的查询语句
	 * 
	 * @param condition 条件
	 * 
	 * @param params 查询条件语句中 对应的查询条件值；
	 */

	public void addCondition(String condition, Object... params) {
		if (whereClause.length() > 1) {
			whereClause += " AND " + condition;
		} else {
			whereClause += " WHERE " + condition;
		}
		// 设置查询条件值到查询条件值集合中;
		if (parameters == null) {
			parameters = new ArrayList<Object>();
		}
		if (params != null) {

			for (Object param : params) {
				parameters.add(param);
			}
		}

	}

	/*
	 * 构造order by查询语句
	 * 
	 * @param property 排序属性
	 * 
	 * @param order 排序顺序
	 */

	public void addOrderByProperty(String property, String order) {

		if (orderByClause.length() > 1) {
			orderByClause += "," + property + " " + order;

		} else {
			orderByClause += " ORDER BY " + property + " " + order;

		}
	}

	// 查询hql语句】
	public String getQueryListHql() {

		return fromClause + whereClause + orderByClause;
	}

	// 查询统计数的hql语句
	public String getQueryCountHql() {

		return "SELECT COUNT(*)" + fromClause + whereClause;
	}

	// 查询hql语句中？ 对应的查询条件值集合

	public List<Object> getParameters() {
		return parameters;
	}
}
