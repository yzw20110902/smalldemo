package yzwTax.itcast.nsfw.info.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yzwTax.itcast.nsfw.info.dao.InfoDao;
import yzwTax.itcast.nsfw.info.entity.Info;
import yzwTax.itcast.nsfw.info.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Resource
	private InfoDao infoDao;

	@Override
	public void save(Info info) {
		// TODO Auto-generated method stub

		infoDao.save(info);
	}

	@Override
	public void update(Info info) {
		// TODO Auto-generated method stub
		infoDao.update(info);

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

		System.out.println(id);

		infoDao.delete(id);
	}

	@Override
	public Info findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return infoDao.findObjectById(id);
	}

	@Override
	public List<Info> findObjects() {
		// TODO Auto-generated method stub
		return infoDao.findObjects();
	}

}
