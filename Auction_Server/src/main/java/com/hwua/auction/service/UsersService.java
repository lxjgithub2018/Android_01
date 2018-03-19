package com.hwua.auction.service;

import com.hwua.auction.po.Users;

/**
 * 用户业务逻辑层接口
 * @author hwua
 *
 */
public interface UsersService extends IBaseService<Users, Integer> {

	/**
	 * 通过用户名获取用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public Users getUsersByUserName(String userName) throws Exception;

}
