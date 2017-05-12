package yzwTax.itcast.nsfw.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.nsfw.user.dao.UserDao;
import yzwTax.itcast.nsfw.user.entity.User;
import yzwTax.itcast.nsfw.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

		userDao.save(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

		userDao.update(user);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

		userDao.delete(id);

	}

	@Override
	public User findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		System.out.println(userDao.findObjectById(id));
		return userDao.findObjectById(id);
	}

	@Override
	public List<User> findObjects() {
		// TODO Auto-generated method stub
		return userDao.findObjects();
	}

}
