package com.hoursecy.sy.dao;

import org.apache.ibatis.annotations.Param;

import com.hoursecy.sy.pojo.UserPojo;

public interface LoginMapper {
	Integer PhoneIsExist(String phone);
	
	UserPojo accountPasswordExists(@Param("phone")String phone,@Param("password")String password);
	
}
