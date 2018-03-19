package com.hwua.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwua.auction.dao.StatesDao;
import com.hwua.auction.po.States;
import com.hwua.auction.util.Page;

/**
 * 状态业务逻辑层实现类
 * @author hwua
 *
 */
@Service("statesService") //当spring扫描到这里时，创建这个类的对象，并存入容器中，它的ID编号为:statesService
public class StatesServiceImpl extends AbstractBaseService<States, Integer> implements StatesService {

	@Resource //告诉spring，当扫描到这里时，注入StatesDao对象进来，初始此属性
	private StatesDao dao;//状态数据访问层对象
	
	public StatesDao getDao() {
		return dao;
	}

	public void setDao(StatesDao dao) {
		this.dao = dao;
	}

	public StatesServiceImpl() {
		super();
	}
	
	/**
	 * 添加状态
	 * @throws Exception 
	 *  
	 */
	@Override
	public boolean add(States obj) throws Exception {
		boolean flag=false;
		this.getDao().add(obj);
		flag=true;
		return flag;
	}

	/**
	 * 修改状态
	 * @throws Exception 
	 */
	@Override
	public boolean update(States obj) throws Exception {
		boolean flag=false;
		this.getDao().update(obj);
		flag=true;
		return flag;
	}

	/**
	 * 删除状态
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
	 * 获取状态
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public States get(Integer id) throws Exception {
		States states=null;
		states = this.getDao().get(id);
		return states;
	}

	/**
	 * 获得状态表所有记录
	 * @throws Exception 
	 */
	@Override
	public List<States> getList() throws Exception {
		List<States> list=null;
		list = this.getDao().getList();
		
		return list;
	}

	/**
	 * 带条件获取状态记录
	 * @throws Exception 
	 */
	@Override
	public List<States> getList(States obj) throws Exception {
		List<States> list=null;
		list = this.getDao().getList(obj);
		
		return list;
	}

	@Override
	public Page<States> getList(States obj, Integer page, Integer limit) throws Exception {
		return this.getDao().getList(obj, page, limit);
	}

}