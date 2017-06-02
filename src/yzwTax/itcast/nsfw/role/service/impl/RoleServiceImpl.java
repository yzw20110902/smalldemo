package yzwTax.itcast.nsfw.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.nsfw.role.dao.RoleDao;
import yzwTax.itcast.nsfw.role.entity.Role;
import yzwTax.itcast.nsfw.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub

		roleDao.save(role);

	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub

		roleDao.update(role);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub\
		roleDao.delete(id);

	}

	@Override
	public Role findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return roleDao.findObjectById(id);
	}

	@Override
	public List<Role> findObjects() {
		// TODO Auto-generated method stub
		return roleDao.findObjects();
	}

}
