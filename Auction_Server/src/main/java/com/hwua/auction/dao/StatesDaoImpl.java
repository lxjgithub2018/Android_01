package com.hwua.auction.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwua.auction.po.States;
import com.hwua.auction.util.Page;
/**
 * 状态数据访问层实现类
 * @author hwua
 *
 */
@Repository("statesDao")//告诉spring扫描到这里时，把它创建对象并存放到spring容器，在容器中的id编号为：statesDao
public class StatesDaoImpl extends AbstractBaseDao<States,Integer> implements StatesDao{

	/**
	 * 删除状态
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public void delete(Integer id) throws Exception {
		States states=this.get(States.class,id);//先通过编号获取一个状态对象
		this.delete(states);//删除此状态对象
	}

	/**
	 * 获取状态
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public States get(Integer id) throws Exception {
		return this.get(States.class,id);
	}

	/**
	 * 获得状态表所有记录
	 */
	@Override
	public List<States> getList() throws Exception {
		//构建查询语句
		String sql="FROM States";//这是hql语句，from的是对象名而不是sql中的表名
		List<States> list = this.query(sql, new Object[]{});//调用AbstractBaseDao抽象类中的query查找方法
		return list;
	}

	/**
	 * 带条件获取状态记录
	 */
	@Override
	public List<States> getList(States obj) throws Exception {
		//构建查询语句
		String sql="FROM States a WHERE 1=1";
		
		if(obj!=null){//条件构造
			
			if(obj.getStateId()!=null){
				sql+=" AND a.stateId="+obj.getStateId();//注意id不能大写，因为是属性而不是数据库表的对象名，属性名是实体类中有的，且是小写
			}
			
			if(obj.getStateName()!=null&&!"".equals(obj.getStateName())){
				sql+=" AND a.stateName LIKE '%"+obj.getStateName()+"%'";
			}
		}
		
		List<States> list = this.query(sql, new Object[]{});	
		return list;
	}

	/**
	 * 带条件带翻页获状态列表
	 */
	@Override
	public Page<States> getList(States obj, Integer page, Integer limit) throws Exception {
		//构建查询语句
		String sql="FROM States a WHERE 1=1";
		
		if(obj!=null){//条件构造
			
			if(obj.getStateId()!=null){
				sql+=" AND a.stateId="+obj.getStateId();//注意stateId不能大写，因为是属性而不是数据库表的对象名，属性名是实体类中有的，且是小写
			}
			
			if(obj.getStateName()!=null&&!"".equals(obj.getStateName())){
				sql+=" AND a.stateName LIKE '%"+obj.getStateName()+"%'";
			}
		}
		
		Page<States> pageObj = this.searchForPager(sql, page, limit);	
		return pageObj;
	}

}