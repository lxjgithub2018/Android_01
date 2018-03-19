package com.hwua.auction.service;

import com.hwua.auction.po.Items;

/**
 * 竞拍结果业务逻辑层接口
 * @author hwua
 *
 */
public interface BidOpeningService extends IBaseService<Items, Integer> {
	/**
	 * 扫描竞拍结果
	 * @throws Exception
	 */
	public void add() throws Exception;
}