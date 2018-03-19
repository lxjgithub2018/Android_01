package com.hwua.auction.service;

import java.util.List;

import com.hwua.auction.util.Page;
/**
*@author hwua
*
* @param <T>
* @param <K>
* T表示表对象的po类型，K表示表中的主键对应的类型
*/
public interface IBaseService<T, K> {
	// 添加信息
	public boolean add(T obj)  throws Exception;

	// 更新信息
	public boolean update(T obj)  throws Exception;

	// 删除信息
	public boolean delete(K obj) throws Exception;

	// 通过主键获得一条信息
	public T get(K obj) throws Exception;

	// 获得信息列表
	public List<T> getList() throws Exception;

	// 通过条件获得信息列表
	public List<T> getList(T obj) throws Exception;
	
	// 通过条件分页获得信息列表
	public Page<T> getList(T obj, Integer page,Integer limit) throws Exception;
}