package com.hwua.auction.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwua.auction.po.Items;
import com.hwua.auction.util.Page;

/**
 * 商品数据访问层实现类
 * @author hwua
 *
 */
@Repository("itemsDao")//告诉spring扫描到这里时，把它创建对象并存放到spring容器，在容器中的id编号为：itemsDao
public class ItemsDaoImpl extends AbstractBaseDao<Items, Integer> implements ItemsDao {

	/**
	 * 删除商品
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public void delete(Integer id) throws Exception {
		Items items = this.get(Items.class, id);//先通过编号获取一个商品对象
		
		items.getKinds().getItemsList().remove(items);//去除关联
		items.setKinds(null);//去除关联
		
		items.getOwnerUsers().getOwnItemsList().remove(items);//去除关联
		items.setOwnerUsers(null);//去除关联
		
		items.getStates().getItemsList().remove(items);//去除关联
		items.setStates(null);//去除关联
		
		if(items.getWinerUsers()!=null){//先判断是否为null
			items.getWinerUsers().getWinItemsList().remove(items);//去除关联
			items.setWinerUsers(null);//去除关联
		}
		
		this.delete(items);//删除此商品对象
	}

	/**
	 * 获取商品
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Items get(Integer id) throws Exception {
		return this.get(Items.class, id);
	}

	/**
	 * 获得商品表所有记录
	 */
	@Override
	public List<Items> getList() throws Exception {
		//构建查询语句
		String sql="FROM Items";
		List<Items> list = this.query(sql, new Object[]{});
		return list;
	}

	/**
	 * 带条件获取商品记录
	 */
	@Override
	public List<Items> getList(Items obj) throws Exception {
		//构建查询语句
		String sql="FROM Items a WHERE 1=1";
		if(obj!=null){//条件构造
			
			if(obj.getItemId()!=null){
				sql+=" AND a.itemId="+obj.getItemId();
			}
			
			if(obj.getItemName()!=null&&!"".equals(obj.getItemName())){
				sql+=" AND a.itemName LIKE '%"+obj.getItemName()+"%'";
			}
			
			if(obj.getKinds()!=null&&obj.getKinds().getKindId()!=null){
				sql+=" AND a.kinds.kindId="+obj.getKinds().getKindId();
			}
			
			//通过状态查找商品
			if(obj.getStates()!=null&&obj.getStates().getStateId()!=null){
				sql+=" AND a.states.stateId="+obj.getStates().getStateId();
			}
			
			if(obj.getOwnerUsers()!=null&&obj.getOwnerUsers().getUserId()!=null){
				sql+=" AND a.ownerUsers.userId="+obj.getOwnerUsers().getUserId();
			}
			
			if(obj.getWinerUsers()!=null){
				sql+=" AND a.winerUsers.userId="+obj.getWinerUsers().getUserId();
			}
		}
		
		List<Items> list = this.query(sql, new Object[]{});//调用父类的查询方法拿数据
		return list;
	}
	
	/**
	 * 带条件带翻页获取商品列表
	 */
	@Override
	public Page<Items> getList(Items obj, Integer page, Integer limit) throws Exception {
		//构建查询语句
		String sql="FROM Items a WHERE 1=1";
		if(obj!=null){//条件构造
			
			if(obj.getItemId()!=null){
				sql+=" AND a.itemId="+obj.getItemId();
			}
			
			if(obj.getItemName()!=null&&!"".equals(obj.getItemName())){
				sql+=" AND a.itemName LIKE '%"+obj.getItemName()+"%'";
			}
			
			if(obj.getKinds()!=null&&obj.getKinds().getKindId()!=null){
				sql+=" AND a.kinds.kindId="+obj.getKinds().getKindId();
			}
			
			if(obj.getStates()!=null&&obj.getStates().getStateId()!=null){
				sql+=" AND a.states.stateId="+obj.getStates().getStateId();
			}
			
			//创建日期格式化对象
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
			if(obj.getAddTime()!=null){//添加日期
				sql+=" AND a.addTime='"+df.format(obj.getAddTime())+"'";
			}
			
			if(obj.getEndTime()!=null){//拍卖结束日期
				sql+=" AND a.endTime='"+df.format(obj.getEndTime())+"'";
			}
			
			//谁发布此商品
			if(obj.getOwnerUsers()!=null&&obj.getOwnerUsers().getUserId()!=null){
				sql+=" AND a.ownerUsers.userId="+obj.getOwnerUsers().getUserId();
			}
			
			//谁赢得个商品
			if(obj.getWinerUsers()!=null&&obj.getWinerUsers().getUserId()!=null){
				sql+=" AND a.winerUsers.userId="+obj.getWinerUsers().getUserId();
			}
		}
		
		Page<Items> pageObj = this.searchForPager(sql, page, limit);//调用父类的查询方法拿数据
		return pageObj;
	}

}

