package com.hoursecy.sy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hoursecy.sy.pojo.UserPojo;


@Mapper
public interface RegisterMapper {
	
	java.lang.Integer PhoneExist(String phone);
	
	java.lang.Integer idcardExist(String idcard);
	
	java.lang.Integer ExistUserToDatabase(UserPojo user);
}
