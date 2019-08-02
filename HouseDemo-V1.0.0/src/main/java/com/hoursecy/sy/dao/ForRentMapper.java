package com.hoursecy.sy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoursecy.sy.pojo.ForRentPojo;

public interface ForRentMapper {
	/** 获取从记录数*/
	int getRowCount(ForRentPojo rents);
	/** 获取满足条件的记录*/
	List<ForRentPojo> findRentObjects(
			@Param("provence")String provence, 
			@Param("city")String city,
			@Param("place")String place, 
			@Param("room")int room, 
			@Param("door")int door, 
			@Param("minprice")String minprice,
			@Param("maxprice")String maxprice, 
			@Param("startIndex")int startIndex, 
			@Param("pageSize")int pageSize);

}
