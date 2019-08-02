package com.hoursecy.sy.dao;

import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.pojo.UserPojo;

/**
 * 	Dao接口类
 */
public interface DetaiInfoMapper {
	
	/** 1.根据房屋id查询出售房屋的详情信息 	*/
	public ForSellPojo findSellhouseById(Integer id); 
	
	/** 2.根据房屋id查询用户的详情信息	*/
	public UserPojo findUserById(Integer id);
	
	/** 3.根据房屋id查询出售房屋的详情信息 	*/
	public ForRentPojo findRentHouseById(Integer id); 
}
