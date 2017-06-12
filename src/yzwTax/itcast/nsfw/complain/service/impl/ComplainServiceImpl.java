package yzwTax.itcast.nsfw.complain.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.core.page.PageResult;
import yzwTax.itcast.core.util.QueryHelper;
import yzwTax.itcast.nsfw.complain.dao.ComplainDao;
import yzwTax.itcast.nsfw.complain.entity.complain;
import yzwTax.itcast.nsfw.complain.service.ComplainService;

@Service("complainService")
public class ComplainServiceImpl implements ComplainService {

	@Resource
	private ComplainDao complainDao;

	@Override
	public void save(complain complain) {
		// TODO Auto-generated method stub
		complainDao.save(complain);

	}

	@Override
	public void update(complain complain) {
		// TODO Auto-generated method stub
		complainDao.update(complain);

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		complainDao.delete(id);

	}

	@Override
	public complain findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return complainDao.findObjectById(id);
	}

	@Override
	public List<complain> findObjects(String hql, List<Object> parameters) {
		// TODO Auto-generated method stub
		return complainDao.findObjects(hql, parameters);
	}

	@Override
	public List<complain> findObjects(QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		return complainDao.findObjects(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return complainDao.getPageResult(queryHelper, pageNo, pageSize);
	}

}
