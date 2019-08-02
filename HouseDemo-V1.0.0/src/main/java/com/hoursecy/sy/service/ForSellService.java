package com.hoursecy.sy.service;


import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.pojo.ForSellPojo;

public interface ForSellService {
	/**获取总记录数 */
	public int getRowCount(ForSellPojo sells);
	/** 查询满足要求的房源*/
	public PageObject<ForSellPojo> findAllObjects(ForSellPojo sells,Integer pageCurrent);
	/** 为用户推荐的房源*/
	public PageObject<ForSellPojo> doFindRecommend(ForSellPojo sells, Integer pageCurrent);
}
