package yzwTax.itcast.test.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.test.dao.TestDao;
import yzwTax.itcast.test.entity.Person;
import yzwTax.itcast.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	TestDao personDao;

	// @Override
	// public void say() {
	// // TODO Auto-generated method stub
	// System.out.println("hello spring .......");
	//
	// }

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub

		personDao.save(person);

	}

	@Override
	public Person findPerson(Serializable id) {
		// TODO Auto-generated method stub
		return personDao.findObjectById(id);
	}

	@Override
	public List<Person> findObList() {

		return personDao.findObjects();
	}

}
