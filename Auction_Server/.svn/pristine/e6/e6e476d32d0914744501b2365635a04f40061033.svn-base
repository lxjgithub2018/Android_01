package com.hwua.auction.dao;

import java.io.Serializable;
import java.util.List;

import com.hwua.auction.util.Page;

//数据访问层接口,T表示表对象的po或者叫实体类型，K表示表中的主键对应的类型
public interface IBaseDao<T, K extends Serializable> {
	// 添加信息
	public void add(T obj) throws Exception;

	// 更新信息
	public void update(T obj) throws Exception;

	// 删除信息
	public void delete(K obj) throws Exception;
	
	//传入删除语句进行删除记录
	public void delete(String sql) throws Exception;
	
	//通过主键获得一条信息
	public T get(K obj) throws Exception;
	
	//获得信息列表
	public List<T> getList() throws Exception;
	
	//通过条件获得信息列表
	public List<T> getList(T obj) throws Exception;

	//通过条件获得信息列表,限制页数
	public Page<T> getList(T obj, Integer page,Integer limit) throws Exception;
	
	//通过hql获得信息列表
	public List<T> findEntity(String hql) throws Exception;

	//通过hql获得信息列表,限制页数
	public List<T> findEntity(String hql, Integer start, Integer limit) throws Exception;
	
}