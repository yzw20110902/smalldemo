package yzwTax.itcast.nsfw.info.service;

import java.io.Serializable;
import java.util.List;

import yzwTax.itcast.nsfw.info.entity.Info;

public interface InfoService {

	// 保存
	public void save(Info info);

	// 更新
	public void update(Info info);

	// 根据id 删除
	public void delete(Serializable id);

	// 根据id查找

	public Info findObjectByid(Serializable id);

	// 查找列表
	public List<Info> findObjects();

}
