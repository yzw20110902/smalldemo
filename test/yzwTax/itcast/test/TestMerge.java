package yzwTax.itcast.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.service.UserService;
import yzwTax.itcast.test.entity.Person;
import yzwTax.itcast.test.service.TestService;

public class TestMerge {

	ClassPathXmlApplicationContext ctx;

	// @Resource
	// private UserService userSerivce;

	@Before
	public void loadCtx() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSpring() {
		TestService ts = (TestService) ctx.getBean("testService");

		// ts.say();
		// ts.save(new Person("xiaos"));
		// List<Person> lis = ts.findObList();
		Person person = ts.findPerson("402847a95b7b604e015b7b6053240000");

		System.out.println(person);

	}

	@Test
	public void testHibernate() {

		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");

		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		User user = new User();

		user.setAccount("3423423412");
		user.setBirthday(new Date());
		user.setDept("1");
		user.setEmail("501887062@qq.com");
		user.setGender(true);
		user.setHeadImg("./dwefwe/msh.jpg");
		user.setMemo("momo");
		user.setMobile("18133250566");
		user.setName("yuzhaowu");
		user.setPassword("12312312");
		user.setState("0");

		session.save(user);
		transaction.commit();

		session.close();

	}

	@Test
	public void testSQL() throws Exception {
		UserService ts = (UserService) ctx.getBean("userService");

		User user = ts.findObjectById("402847a95bf110f7015bf111b2f40000");

		System.out.println(user);

	}

}
