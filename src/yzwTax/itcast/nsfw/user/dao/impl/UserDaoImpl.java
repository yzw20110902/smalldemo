package yzwTax.itcast.nsfw.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import yzwTax.itcast.core.dao.impl.BaseDaoImpl;
import yzwTax.itcast.nsfw.user.dao.UserDao;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.entity.UserRole;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		// TODO Auto-generated method stub

		String hql = "FROM User WHERE account=?";
		if (StringUtils.isNotBlank(id)) {
			hql += "AND id!=?";

		}

		Query query = getSession().createQuery(hql);

		query.setParameter(0, account);

		if (StringUtils.isNotBlank(id)) {
			query.setParameter(1, id);

		}

		return query.list();
	}

	@Override
	public void saveUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(userRole);

	}

	@Override
	public void deleteUserRoleByUserId(Serializable id) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"DELETE FROM UserRole WHERE id.userId=? ");
		query.setParameter(0, id);
		query.executeUpdate();

	}

	@Override
	public List<UserRole> getUserRolesByUserId(Serializable id) {
		// TODO Auto-generated method stub

		Query query = getSession().createQuery(
				"FROM　UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		return query.list();
	}

	@Override
	public List<User> findUserByAccountAndPass(String account, String password) {
		// TODO Auto-generated method stub

		Query query = getSession().createQuery(
				"FROM User WHERE account=? AND password=? ");
		query.setParameter(0, account);
		query.setParameter(1, password);

		return query.list();
	}

}
