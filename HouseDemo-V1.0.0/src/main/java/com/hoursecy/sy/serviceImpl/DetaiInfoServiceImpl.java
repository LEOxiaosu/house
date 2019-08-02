package com.hoursecy.sy.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.sy.dao.DetaiInfoMapper;
import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.pojo.UserPojo;
import com.hoursecy.sy.service.DetaiInfoService;

/**	注解的作用:
 * 	(1)标识当前类属于Service层
 * 	(2)将当前类的对象的创建交给Spring容器,
 *	   该对象会赋值给,同类型的且带有@Autowired 注解的变量
 */
@Service
public class DetaiInfoServiceImpl implements DetaiInfoService {
	
	@Autowired
	private DetaiInfoMapper detaiInfoMapper;
	
	/**	根据房屋id查询房屋的详情信息	*/
	@Override
	public ForSellPojo findSellhouseById(Integer id) {
		ForSellPojo house = detaiInfoMapper.findSellhouseById(id);
		return house;
	}
	/** 根据房屋id查询户主的个人信息	*/
	@Override
	public UserPojo findUserById(Integer id) {
		UserPojo user = detaiInfoMapper.findUserById(id);
		return user;
	}
	/** 根据出租房屋id查询房屋的详情信息	*/
	@Override
	public ForRentPojo findRentHouseById(Integer id) {
		ForRentPojo rent = detaiInfoMapper.findRentHouseById(id);
		return rent;
	}

}
