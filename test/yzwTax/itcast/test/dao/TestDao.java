package yzwTax.itcast.test.dao;

import java.io.Serializable;

import yzwTax.itcast.test.entity.Person;

public interface TestDao {
	// 保存人员
	public void save(Person person);

	// 根据id查询人员
	public Person findPerson(Serializable id);
}
