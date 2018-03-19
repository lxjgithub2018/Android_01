package com.hwua.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwua.auction.dao.BidsDao;
import com.hwua.auction.po.Bids;
import com.hwua.auction.util.Page;

/**
 * 商品竞拍记录业务逻辑层实现类
 * @author hwua
 *
 */
@Service("bidsService") //当spring扫描到这里时，创建这个类的对象，并存入容器中，它的ID编号为:bidsService
public class BidsServiceImpl extends AbstractBaseService<Bids, Integer> implements BidsService {

	@Resource //告诉spring，当扫描到这里时，注入BidsDao对象进来，初始此属性
	private BidsDao dao;//商品竞拍记录数据访问层对象
	
	public BidsDao getDao() {
		return dao;
	}

	public void setDao(BidsDao dao) {
		this.dao = dao;
	}

	public BidsServiceImpl() {
		super();
	}
	
	/**
	 * 添加商品竞拍记录
	 * @throws Exception 
	 *  
	 */
	@Override
	public boolean add(Bids obj) throws Exception {
		boolean flag=false;
		this.getDao().add(obj);
		flag=true;
		return flag;
	}

	/**
	 * 修改商品竞拍记录
	 * @throws Exception 
	 */
	@Override
	public boolean update(Bids obj) throws Exception {
		boolean flag=false;
		this.getDao().update(obj);
		flag=true;
		return flag;
	}

	/**
	 * 删除商品竞拍记录
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
	 * 获取商品竞拍记录
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Bids get(Integer id) throws Exception {
		Bids bids=null;
		bids = this.getDao().get(id);
		return bids;
	}

	/**
	 * 获得商品竞拍记录表所有记录
	 * @throws Exception 
	 */
	@Override
	public List<Bids> getList() throws Exception {
		List<Bids> list=null;
		list = this.getDao().getList();
		
		return list;
	}

	/**
	 * 带条件获取商品竞拍记录记录
	 * @throws Exception 
	 */
	@Override
	public List<Bids> getList(Bids obj) throws Exception {
		List<Bids> list=null;
		list = this.getDao().getList(obj);
		
		return list;
	}

	@Override
	public Page<Bids> getList(Bids obj, Integer page, Integer limit) throws Exception {
		return this.getDao().getList(obj, page, limit);
	}

}
