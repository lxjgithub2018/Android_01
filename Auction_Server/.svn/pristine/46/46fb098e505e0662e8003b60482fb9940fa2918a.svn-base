package com.hwua.auction.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwua.auction.po.Kinds;
import com.hwua.auction.util.Page;
/**
 * 商品类别数据访问层实现类
 * @author hwua
 *
 */
@Repository("kindsDao")//告诉spring扫描到这里时，把它创建对象并存放到spring容器，在容器中的id编号为：kindsDao
public class KindsDaoImpl extends AbstractBaseDao<Kinds,Integer> implements KindsDao{

	/**
	 * 删除商品类别
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public void delete(Integer id) throws Exception {
		Kinds kinds=this.get(Kinds.class,id);//先通过编号获取一个商品类别对象
		this.delete(kinds);//删除此商品类别对象
	}

	/**
	 * 获取商品类别
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Kinds get(Integer id) throws Exception {
		return this.get(Kinds.class,id);
	}

	/**
	 * 获得商品类别表所有记录
	 */
	@Override
	public List<Kinds> getList() throws Exception {
		//构建查询语句
		String sql="FROM Kinds";//这是hql语句，from的是对象名而不是sql中的表名
		List<Kinds> list = this.query(sql, new Object[]{});//调用AbstractBaseDao抽象类中的query查找方法
		return list;
	}

	/**
	 * 带条件获取商品类别记录
	 */
	@Override
	public List<Kinds> getList(Kinds obj) throws Exception {
		//构建查询语句
		String sql="FROM Kinds a WHERE 1=1";
		
		if(obj!=null){//条件构造
			
			if(obj.getKindId()!=null){
				sql+=" AND a.kinId="+obj.getKindId();//注意id不能大写，因为是属性而不是数据库表的对象名，属性名是实体类中有的，且是小写
			}
			
			if(obj.getKindName()!=null&&!"".equals(obj.getKindName())){
				sql+=" AND a.kindName LIKE '%"+obj.getKindName()+"%'";
			}
		}
		
		List<Kinds> list = this.query(sql, new Object[]{});	
		return list;
	}

	/**
	 * 带条件带翻页获取商品类别列表
	 */
	@Override
	public Page<Kinds> getList(Kinds obj, Integer page, Integer limit) throws Exception {
		//构建查询语句
		String sql="FROM Kinds a WHERE 1=1";
		
		if(obj!=null){//条件构造
			
			if(obj.getKindId()!=null){
				sql+=" AND a.kinId="+obj.getKindId();//注意kinId不能大写，因为是属性而不是数据库表的对象名，属性名是实体类中有的，且是小写
			}
			
			if(obj.getKindName()!=null&&!"".equals(obj.getKindName())){
				sql+=" AND a.kindName LIKE '%"+obj.getKindName()+"%'";
			}
		}
		
		Page<Kinds> pageObj = this.searchForPager(sql, page, limit);	
		return pageObj;
	}

}