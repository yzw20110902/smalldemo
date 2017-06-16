package yzwTax.itcast.nsfw.dept.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.nsfw.dept.dao.DeptDao;
import yzwTax.itcast.nsfw.dept.entity.Dept;
import yzwTax.itcast.nsfw.dept.service.deptService;

@Service("deptService")
public class deptServiceImpl implements deptService {

	@Resource
	private DeptDao deptDao;

	@Override
	public void save(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.save(dept);

	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update(dept);

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

		deptDao.delete(id);
	}

	@Override
	public Dept findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return deptDao.findObjectById(id);
	}

	@Override
	public List<Dept> findObjects() {
		// TODO Auto-generated method stub

		System.out.println(deptDao.findObjects());
		return deptDao.findObjects();
	}
}
