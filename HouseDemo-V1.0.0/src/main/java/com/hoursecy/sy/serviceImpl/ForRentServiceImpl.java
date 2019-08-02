package com.hoursecy.sy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.common.exception.ServiceException;
import com.hoursecy.common.util.PageUtil;
import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.dao.ForRentMapper;
import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.ForRentService;
@Service
public class ForRentServiceImpl implements ForRentService{
	@Autowired ForRentMapper rentDao;
	/** 获取从记录数*/
	public int getRowCount(ForRentPojo rents){
		int rows = rentDao.getRowCount(rents);
		return rows;
	}
	//查询页面加载时需要显示的默认初始条件的租房信息
	@Override
	public PageObject<ForRentPojo> findRentObjects(ForRentPojo rents,Integer pageCurrent) {
		//1.判断当前页数的合法性
		if(pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("当前页码值不正确");
		}
		//2.对总记录数进行一个判断
		int rowCount = rentDao.getRowCount(rents);
		if(rowCount==0){
			throw new ServiceException("没有找到对应的记录");//自定义异常
		}
		//3.查询当前页日志记录
		int pageSize=4;  //每页显示3条数据
		int startIndex=(pageCurrent-1)*pageSize; //起始页码

		//4.查询页码范围内的所有满足条件的记录
		String provence = rents.getProvence();//省
		String city = rents.getCity(); //市
		String place = rents.getPlace();//区/县
		int room = rents.getRoom();//室
		int door=rents.getDoor();//厅
		String minprice = rents.getMinprice();//最低价
		String maxprice =rents.getMaxprice();//最高价
		//此方法用于分页获取满足条件的记录
		List<ForRentPojo> records=rentDao.findRentObjects(provence,city,place,
				room,door,minprice,maxprice,startIndex, pageSize);
    	//5.对查询结果进行封装并返回
		return PageUtil.newPageObject(pageCurrent, rowCount, pageSize, records);
	}
}
