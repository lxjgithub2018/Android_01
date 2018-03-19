package com.hwua.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwua.auction.dao.KindsDao;
import com.hwua.auction.po.Kinds;
import com.hwua.auction.util.Page;

/**
 * 商品类别业务逻辑层实现类
 * @author hwua
 *
 */
@Service("kindsService") //当spring扫描到这里时，创建这个类的对象，并存入容器中，它的ID编号为:kindsService
public class KindsServiceImpl extends AbstractBaseService<Kinds, Integer> implements KindsService {
	
	@Resource //告诉spring，当扫描到这里时，注入KindsDao对象进来，初始此属性
	private KindsDao dao;//商品类别数据访问层对象
	
	public KindsDao getDao() {
		return dao;
	}

	public void setDao(KindsDao dao) {
		this.dao = dao;
	}

	public KindsServiceImpl() {
		super();
	}
	
	/**
	 * 添加商品类别
	 * @throws Exception 
	 *  
	 */
	@Override
	public boolean add(Kinds obj) throws Exception {
		boolean flag=false;
		this.getDao().add(obj);
		flag=true;
		return flag;
	}

	/**
	 * 修改商品类别
	 * @throws Exception 
	 */
	@Override
	public boolean update(Kinds obj) throws Exception {
		boolean flag=false;
		this.getDao().update(obj);
		flag=true;
		return flag;
	}

	/**
	 * 删除商品类别
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public boolean delete(Integer id) throws Exception {
		boolean flag=false;
		this.getDao().delete(id);
		flag=true;
		return flag;
	}

	/**
	 * 获取商品类别
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Kinds get(Integer id) throws Exception {
		Kinds kinds=null;
		kinds = this.getDao().get(id);
		return kinds;
	}

	/**
	 * 获得商品类别表所有记录
	 * @throws Exception 
	 */
	@Override
	public List<Kinds> getList() throws Exception {
		List<Kinds> list=null;
		list = this.getDao().getList();
		
		return list;
	}

	/**
	 * 带条件获取商品类别记录
	 * @throws Exception 
	 */
	@Override
	public List<Kinds> getList(Kinds obj) throws Exception {
		List<Kinds> list=null;
		list = this.getDao().getList(obj);
		
		return list;
	}

	@Override
	public Page<Kinds> getList(Kinds obj, Integer page, Integer limit) throws Exception {
		return this.getDao().getList(obj, page, limit);
	}

}