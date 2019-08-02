package com.hoursecy.sy.service;

import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.pojo.UserPojo;

public interface DetaiInfoService {
	
	/**根据房屋id查询房屋的详情信息	*/
	public ForSellPojo findSellhouseById(Integer id);
	
	/**根据房屋id查询用户的信息	*/
	public UserPojo findUserById(Integer id);
	
	/** 通过房屋id查询租房详情数据	*/
	public ForRentPojo findRentHouseById(Integer id);
	
}
