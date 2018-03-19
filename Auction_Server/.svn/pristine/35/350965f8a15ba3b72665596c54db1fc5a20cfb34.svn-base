package com.hwua.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwua.auction.dao.ItemsDao;
import com.hwua.auction.po.Items;
import com.hwua.auction.util.Page;

/**
 * 商品业务逻辑层实现类
 * @author hwua
 *
 */
@Service("itemsService") //当spring扫描到这里时，创建这个类的对象，并存入容器中，它的ID编号为:itemsService
public class ItemsServiceImpl extends AbstractBaseService<Items, Integer> implements ItemsService {

	@Resource //告诉spring，当扫描到这里时，注入ItemsDao对象进来，初始此属性
	private ItemsDao dao;//商品数据访问层对象
	
	public ItemsDao getDao() {
		return dao;
	}

	public void setDao(ItemsDao dao) {
		this.dao = dao;
	}

	public ItemsServiceImpl() {
		super();
	}
	
	/**
	 * 添加商品
	 * @throws Exception 
	 *  
	 */
	@Override
	public boolean add(Items obj) throws Exception {
		boolean flag=false;
		this.getDao().add(obj);
		flag=true;
		return flag;
	}

	/**
	 * 修改商品
	 * @throws Exception 
	 */
	@Override
	public boolean update(Items obj) throws Exception {
		boolean flag=false;
		this.getDao().update(obj);
		flag=true;
		return flag;
	}

	/**
	 * 删除商品
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
	 * 获取商品
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Items get(Integer id) throws Exception {
		Items items=null;
		items = this.getDao().get(id);
		return items;
	}

	/**
	 * 获得商品表所有记录
	 * @throws Exception 
	 */
	@Override
	public List<Items> getList() throws Exception {
		List<Items> list=null;
		list = this.getDao().getList();
		
		return list;
	}

	/**
	 * 带条件获取商品记录
	 * @throws Exception 
	 */
	@Override
	public List<Items> getList(Items obj) throws Exception {
		List<Items> list=null;
		list = this.getDao().getList(obj);
		
		return list;
	}

	@Override
	public Page<Items> getList(Items obj, Integer page, Integer limit) throws Exception {
		return this.getDao().getList(obj, page, limit);
	}

}