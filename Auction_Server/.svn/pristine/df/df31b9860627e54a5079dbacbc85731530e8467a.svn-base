package com.hwua.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwua.auction.dao.UsersDao;
import com.hwua.auction.po.Users;
import com.hwua.auction.util.Page;

/**
 * 用户业务逻辑层实现类
 * @author hwua
 *
 */
@Service("usersService")//当spring扫描到这里时，创建这个类的对象，并存入容器中，它的ID编号为:usersService
public class UsersServiceImpl extends AbstractBaseService<Users, Integer> implements UsersService {

	@Resource //告诉spring，当扫描到这里时，注入UsersDao对象进来，初始此属性
	private UsersDao dao;//用户数据访问层对象
	
	public UsersDao getDao() {
		return dao;
	}

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}

	public UsersServiceImpl() {
		super();
	}
	
	/**
	 * 添加用户
	 * @throws Exception 
	 *  
	 */
	@Override
	public boolean add(Users obj) throws Exception {
		boolean flag=false;
		this.getDao().add(obj);//调用数据访问层对象保存用户
		flag=true;
		return flag;
	}

	/**
	 * 修改用户
	 * @throws Exception 
	 */
	@Override
	public boolean update(Users obj) throws Exception {
		boolean flag=false;
		this.getDao().update(obj);//调用数据访问层对象修改用户
		flag=true;
		return flag;
	}

	/**
	 * 删除用户
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
	 * 获取用户
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Users get(Integer id) throws Exception {
		Users users=null;
		users = this.getDao().get(id);
		return users;
	}

	/**
	 * 获得用户表所有记录
	 * @throws Exception 
	 */
	@Override
	public List<Users> getList() throws Exception {
		List<Users> list=null;
		list = this.getDao().getList();
		
		return list;
	}

	/**
	 * 带条件获取用户记录
	 * @throws Exception 
	 */
	@Override
	public List<Users> getList(Users obj) throws Exception {
		List<Users> list=null;
		list = this.getDao().getList(obj);
		
		return list;
	}

	/**
	 * 通过条件获得信息列表,限制页数
	 */
	@Override
	public Page<Users> getList(Users obj, Integer page, Integer limit) throws Exception {
		return this.getDao().getList(obj, page, limit);
	}
	
	/**
	 * 通过用户名获取用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	@Override
	public Users getUsersByUserName(String userName) throws Exception{
		return this.getDao().getUsersByUserName(userName);
	}

}
