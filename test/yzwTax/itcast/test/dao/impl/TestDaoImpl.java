package yzwTax.itcast.test.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import yzwTax.itcast.test.dao.TestDao;
import yzwTax.itcast.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub

		getHibernateTemplate().save(person);

	}

	@Override
	public Person findPerson(Serializable id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Person.class, id);
	}

}
