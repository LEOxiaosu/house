package com.hoursecy.sy.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoursecy.sy.pojo.ForSellPojo;

public interface ForSellMapper {
	//获取总记录数
	int getRowCount(ForSellPojo sells);
	//查询页码范围内的记录
	public List<ForSellPojo> findAllObjects(
			@Param("provence")String provence,
			@Param("city")String city,
			@Param("place")String place,
			@Param("room")int room,
			@Param("door")int door,
			@Param("pricetype")String pricetype,
			@Param("minprice")String minprice,
			@Param("maxprice")String maxprice,
			@Param("startIndex")Integer startIndex, 
			@Param("pageSize")Integer pageSize);
	//推荐的房源
	List<ForSellPojo> doFindRecommend(@Param("provence")String provence, 
			@Param("city")String city, 
			@Param("place")String place, 
			@Param("startIndex")int startIndex, 
			@Param("pageSize")int pageSize);	
}
