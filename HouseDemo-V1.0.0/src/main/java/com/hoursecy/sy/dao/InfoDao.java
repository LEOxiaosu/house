package com.hoursecy.sy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hoursecy.sy.pojo.ForSellPojo;
@Mapper
public interface InfoDao {
	List<ForSellPojo> findPageObjects(
			  @Param("id")Integer id,
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);
	int getRows(@Param("id")Integer id);
	int deleteObjects(@Param("houseid")Integer houseid);
	ForSellPojo doFindObjectById(@Param("houseid")Integer houseid);
	void alterData(ForSellPojo alter);
}
