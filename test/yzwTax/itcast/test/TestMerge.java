package yzwTax.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yzwTax.itcast.test.entity.Person;
import yzwTax.itcast.test.service.TestService;

public class TestMerge {

	ClassPathXmlApplicationContext ctx;

	@Before
	public void loadCtx() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSpring() {
		TestService ts = (TestService) ctx.getBean("testService");
		ts.say();
	}

	@Test
	public void testHibernate() {

		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");

		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(new Person("小si"));
		transaction.commit();

		session.close();

	}
}
