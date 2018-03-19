package com.hwua.auction.dao;

import com.hwua.auction.po.Users;

/**
 * 
 * 系统功能数据访问层接口
 * @author hwua
 *
 */
public interface UsersDao extends IBaseDao<Users, Integer> {

	/**
	 * 通过用户名查找用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public Users getUsersByUserName(String userName) throws Exception;

}