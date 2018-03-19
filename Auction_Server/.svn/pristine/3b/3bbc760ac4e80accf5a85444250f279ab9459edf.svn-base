package com.hwua.auction.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwua.auction.po.Bids;
import com.hwua.auction.util.Page;

/**
 * 竞拍记录数据访问层实现类
 * @author hwua
 *
 */
@Repository("bidsDao")//告诉spring扫描到这里时，把它创建对象并存放到spring容器，在容器中的id编号为：bidsDao
public class BidsDaoImpl extends AbstractBaseDao<Bids, Integer> implements BidsDao {

	/**
	 * 删除竞拍记录
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public void delete(Integer id) throws Exception {
		Bids admin = this.get(Bids.class, id);//先通过编号获取一个竞拍对象
		this.delete(admin);//删除此竞拍对象
	}

	/**
	 * 获取竞拍记录
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Bids get(Integer id) throws Exception {
		return this.get(Bids.class, id);
	}

	/**
	 * 获得竞拍记录表所有记录
	 */
	@Override
	public List<Bids> getList() throws Exception {
		//构建查询语句
		String sql="FROM Bids";
		List<Bids> list = this.query(sql, new Object[]{});
		return list;
	}

	/**
	 * 带条件获取竞拍记录记录
	 */
	@Override
	public List<Bids> getList(Bids obj) throws Exception {
		//构建查询语句
		String sql="FROM Bids a WHERE 1=1";
		if(obj!=null){//条件构造
			
			if(obj.getBidId()!=null){
				sql+=" AND a.bidId="+obj.getBidId();
			}
			
			//参与了哪一个商品
			if(obj.getItems()!=null&&obj.getItems().getItemId()!=null){
				sql+=" AND a.items.itemId="+obj.getItems().getItemId();
			}
			
			//参与了哪一个商品
			if(obj.getItems()!=null&&obj.getItems().getItemName()!=null){
				sql+=" AND a.items.itemName LIKE '%"+obj.getItems().getItemName()+"%'";
			}
			
			//谁参与这次竞拍
			if(obj.getUsers()!=null&&obj.getUsers().getUserId()!=null){
				sql+=" AND a.users.userId="+obj.getUsers().getUserId();
			}
			
			//谁参与这次竞拍
			if(obj.getUsers()!=null&&obj.getUsers().getUserName()!=null){
				sql+=" AND a.users.userName LIKE '%"+obj.getUsers().getUserName()+"%'";
			}
		}
		
		sql+=" ORDER BY a.bidPrice DESC";//通过价格进行排序
		
		List<Bids> list = this.query(sql, new Object[]{});//调用父类的查询方法拿数据
		return list;
	}
	
	/**
	 * 带条件带翻页获取竞拍记录列表
	 */
	@Override
	public Page<Bids> getList(Bids obj, Integer page, Integer limit) throws Exception {
		//构建查询语句
		String sql="FROM Bids a WHERE 1=1";
		if(obj!=null){//条件构造
			
			if(obj.getBidId()!=null){
				sql+=" AND a.bidId="+obj.getBidId();
			}
			
			//参与了哪一个商品
			if(obj.getItems()!=null&&obj.getItems().getItemId()!=null){
				sql+=" AND a.items.itemId="+obj.getItems().getItemId();
			}
			
			//参与了哪一个商品
			if(obj.getItems()!=null&&obj.getItems().getItemName()!=null){
				sql+=" AND a.items.itemName LIKE '%"+obj.getItems().getItemName()+"%'";
			}
			
			//谁参与这次竞拍
			if(obj.getUsers()!=null&&obj.getUsers().getUserId()!=null){
				sql+=" AND a.users.userId="+obj.getUsers().getUserId();
			}
			
			//谁参与这次竞拍
			if(obj.getUsers()!=null&&obj.getUsers().getUserName()!=null){
				sql+=" AND a.users.userName LIKE '%"+obj.getUsers().getUserName()+"%'";
			}
		}
		
		Page<Bids> pageObj = this.searchForPager(sql, page, limit);//调用父类的查询方法拿数据
		return pageObj;
	}

}