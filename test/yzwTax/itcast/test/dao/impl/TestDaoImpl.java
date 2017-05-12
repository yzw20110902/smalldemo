package yzwTax.itcast.test.dao.impl;

import yzwTax.itcast.core.dao.impl.BaseDaoImpl;
import yzwTax.itcast.test.dao.TestDao;
import yzwTax.itcast.test.entity.Person;

public class TestDaoImpl extends BaseDaoImpl<Person> implements TestDao {

	// @Override
	// public void save(Person person) {
	// // TODO Auto-generated method stub
	//
	// getHibernateTemplate().save(person);
	//
	// }
	//
	// @Override
	// public Person findPerson(Serializable id) {
	// // TODO Auto-generated method stub
	// return getHibernateTemplate().get(Person.class, id);
	// }
	//
	// @Override
	// public List<Person> findObList() {
	// Query query = getSession().createQuery(
	// "FROM" + Person.class.getSimpleName());
	// return query.list();
	//
	// }

}
