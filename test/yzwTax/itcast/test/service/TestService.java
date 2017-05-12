package yzwTax.itcast.test.service;

import java.io.Serializable;
import java.util.List;

import yzwTax.itcast.test.entity.Person;

public interface TestService {
	// 输出
	// public void say();

	// 保存人员
	public void save(Person person);

	// 根据id查询人员
	public Person findPerson(Serializable id);

	public List<Person> findObList();

}
