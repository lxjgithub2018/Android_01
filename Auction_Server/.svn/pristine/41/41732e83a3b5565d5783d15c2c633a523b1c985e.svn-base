package com.hwua.auction.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwua.auction.po.Users;
import com.hwua.auction.util.Page;
/**
 * 用户数据访问层实现类
 * @author hwua
 *
 */
@Repository("usersDao")//告诉spring扫描到这里时，把它创建对象并存放到spring容器，在容器中的id编号为：usersDao
public class UsersDaoImpl extends AbstractBaseDao<Users, Integer> implements UsersDao {


	/**
	 * 删除用户
	 * @param id 编号
	 */
	@Override
	public void delete(Integer id) throws Exception {
		Users users=this.get(Users.class,id);//先通过编号获取一个用户对象
		this.delete(users);//删除此用户对象
	}

	/**
	 * 获取用户
	 * @param id 编号
	 */
	@Override
	public Users get(Integer id) throws Exception {
		return this.get(Users.class,id);//包裝有這個類的原始數據對象
	}

	/**
	 * 获取所有用户所有记录
	 */
	@Override
	public List<Users> getList() throws Exception {
		//构建查询语句
		String sql="from Users";
		List<Users> list = this.query(sql, new Object[]{});
		return list;
	}

	/**
	 * 带条件获取用户记录
	 */
	@Override
	public List<Users> getList(Users obj) throws Exception {
		//构建查询语句
		String sql="from Users a where 1=1";
		if(obj!=null){//条件构造
			
			if(obj.getUserId()!=null){
				sql+=" AND a.userId="+obj.getUserId();
			}
			
			if(obj.getUserName()!=null&&!"".equals(obj.getUserName())){
				sql+=" AND a.userName like '%"+obj.getUserName()+"%'";
			}
			
			if(obj.getEmail()!=null&&!"".equals(obj.getEmail())){
				sql+=" AND a.email like '%"+obj.getEmail()+"%'";
			}
			
		}

		List<Users> list = this.query(sql, new Object[]{});
		return list;
	}

	/**
	 * 带条件带翻页获取用户列表
	 */
	@Override
	public Page<Users> getList(Users obj, Integer page, Integer limit) throws Exception {
		//构建查询语句
		String sql="from Users a where 1=1";
		if(obj!=null){//条件构造
			
			if(obj.getUserId()!=null){
				sql+=" AND a.userId="+obj.getUserId();
			}
			
			if(obj.getUserName()!=null&&!"".equals(obj.getUserName())){
				sql+=" AND a.userName like '%"+obj.getUserName()+"%'";
			}
			
			if(obj.getEmail()!=null&&!"".equals(obj.getEmail())){
				sql+=" AND a.email like '%"+obj.getEmail()+"%'";
			}
			
		}
		
		Page<Users> pageObj = this.searchForPager(sql, page, limit);
		return pageObj;//返回翻页对象
	}

	/**
	 * 通过用户名查询用户
	 * @param userName 用户名
	 */
	@Override
	public Users getUsersByUserName(String userName) throws Exception{
		//构建查询语句
		String sql="FROM Users a WHERE a.userName=?";
		Users users = this.uniqueQuery(sql, new Object[]{userName});//调用父类的查询方法拿数据
		return users;
	}

}
